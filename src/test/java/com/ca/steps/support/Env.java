package com.ca.steps.support;

import com.ca.runner.RunTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Created by Derin on 15/03/16.
 */

public class Env extends RunTest{
    private static String build;
    private static String url;

//    build environment is set at command line
    public static String getBuild() {
        build = System.getProperty("env");
        if (build.equals("qa")) {
            url = "https://ca-qa.ats.itv.com/";
        } else if (build.equals("uat")) {
            url = "https://ca-uat.ats.itv.com/";
        } else {
            url = "https://ca-qa.ats.itv.com/";
        }
        return url;
    }


    @Before
    public void beforeTest() throws Exception {
        getBuild();
        driver.get(url);
    }

    @After
    public void afterTest(Scenario scenario) throws Exception {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
    }
}

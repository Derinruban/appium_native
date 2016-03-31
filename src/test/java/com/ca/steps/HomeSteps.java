package com.ca.steps;

import com.ca.runner.RunTest;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Derin on 30/11/15.
 */
public class HomeSteps extends RunTest {

    @Given("^I am on home screen$")
    public void i_am_on_home_screen() throws Throwable {
        driver.get("http://google.com");
        wait.until(ExpectedConditions.visibilityOf(common.Search_field));
        common.Search_field.sendKeys("Travelex");
        Thread.sleep(5000);
    }

}

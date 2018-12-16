package com.ca.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty", "html:target/cucumber-html", "json:target/cucumber-json-report.json"},
        features={"src/test/resources/features"},
        monochrome = true,
        tags={"@derin"},
        glue = {"com.ca.steps"}
)

public class RunTest {
//    public static WebDriver driver;
//    public static WebDriverWait wait;
//
////    Pages
//    public static Common common;
//    public static Login login;


    @BeforeClass
    public static void setUp() throws Exception {
//        driver = Drivers.getDriver();
//        wait = new WebDriverWait(driver, 15);
//
////     Page Object instances
//        common = new Common();
//        login = new Login();
    }

    @AfterClass
    public static void tearDown() {
//        driver.quit();
    }
}

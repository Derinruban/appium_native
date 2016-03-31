package com.ca.steps;

import com.ca.runner.RunTest;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Derin on 30/03/16.
 */
public class HomeSteps extends RunTest {

    @Given("^I am on home screen$")
    public void i_am_on_home_screen() throws Throwable {
        driver.get("http://google.com");
        wait.until(ExpectedConditions.visibilityOf(common.Search_field));
        common.Search_field.sendKeys("Travelex");
        Thread.sleep(2000);
    }

    @Given("^I am logged in$")
    public void i_am_logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }


}

package com.ca.steps;

import com.ca.runner.RunTest;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Derin on 30/03/16.
 */
public class HomeSteps extends RunTest {

    @Given("^I am logged in$")
    public void i_am_logged_in() throws Throwable {
        login.Username.sendKeys("");
        login.Password.sendKeys("");
        login.Login_button.click();
        wait.until(ExpectedConditions.visibilityOf(common.Icons));
        Thread.sleep(2000);

    }


}

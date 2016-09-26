package com.ca.steps;

import com.ca.runner.RunTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

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

    @Given("^I can Loop$")
    public void i_can_Loop(DataTable table) throws Throwable {
        for (Map<String, String> map : table.asMaps(String.class, String.class)) {
            String attribute = map.get("attributes");
            String word = map.get("words");

            System.out.println(attribute + word);
        }
    }

    @Given("^I can Switch$")
    public void i_can_Switch(DataTable table) throws Throwable {
        for (Map<String, String> map : table.asMaps(String.class, String.class)) {
            String attribute = map.get("attributes");

                switch (attribute) {
                    case "Monday":
                        System.out.println("What a bore");
                    case "Tueday":
                        System.out.println("What a drag");
                    case "Wednesday":
                        System.out.println("Almost done");
                }
        }
    }

    @Given("^I can hover$")
    public void i_can_hover() throws Throwable {
       driver.get("https://www.amazon.co.uk/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-yourAccount"))));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-yourAccount"))).build().perform();
        Thread.sleep(5000);
    }

    @Given("^I can select$")
    public void i_can_select() throws Throwable {
        driver.get("https://www.amazon.co.uk/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchDropdownBox")));
        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Baby");
        Thread.sleep(5000);
    }

}

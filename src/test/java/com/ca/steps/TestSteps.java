package com.ca.steps;

import com.ca.runner.RunTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Map;


public class TestSteps extends RunTest {

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


    @When("^I use while option$")
    public void i_select_the_transfer_button() throws Throwable {

        int count = 0;

        while (count <7) {
            if () {
                break;
            } else {
                count++;
            }
        }
    }


}

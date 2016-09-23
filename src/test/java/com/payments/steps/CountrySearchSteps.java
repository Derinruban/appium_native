package com.payments.steps;

import com.payments.runner.RunTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 01/02/16.
 */
public class CountrySearchSteps extends RunTest {

    @Then("^countries are listed in alphabetical order$")
    public void countries_are_listed_in_alphabetical_order() throws Throwable {
        List<MobileElement> countries;
        if (platform.equals("iOS")) {
            countries = driver.findElementsById("x");
        } else {
            countries = driver.findElementsById("text_country_name");
        }

        System.out.println(countries);
    }

    @Then("^every listed currency displays these following attributes$")
    public void every_listed_currency_displays_these_following_attributes(DataTable table) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Country_Flag));

        List<MobileElement> countries;
        if (platform.equals("iOS")) {
            countries = driver.findElementsById("x");
        } else {
            countries = driver.findElementsById("img_flag");
        }
        int count = countries.size();
        System.out.println(count);

            for (Map<String, String> map : table.asMaps(String.class, String.class)) {
                String attribute = map.get("attributes");

                switch (attribute) {
                    case "Country Name":
                        if (platform.equals("iOS")) {
                            Assert.assertEquals(count, driver.findElementsById("x").size());
                        } else {
                            Assert.assertTrue(count <= driver.findElementsById("text_country_name").size());
                        }

                    case "Currency Name":
                        if (platform.equals("iOS")) {
                            Assert.assertEquals(count, driver.findElementsById("x").size());
                        } else {
                            Assert.assertEquals(count, driver.findElementsById("text_currency_name").size());
                        }

                    case "Rate":
                        if (platform.equals("iOS")) {
                            Assert.assertEquals(count, driver.findElementsById("x").size());
                        } else {
                            Assert.assertEquals(count, driver.findElementsById("text_rate").size());
                        }

                }

            }

    }
    @Then("^I can see the selected country and currency rate$")
    public void i_can_see_the_selected_country_and_currency_rate() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Selected_Country));
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Base_Currency));
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Quoted_Currency));
    }


    @Then("^I can see the Transfer Funds button$")
    public void i_can_see_the_Transfer_Funds_button() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Transfer));
    }


    @When("^I tap on \"([^\"]*)\" from the Country Search results$")
    public void i_tap_on_from_the_Country_Search_results(String nation) throws Throwable {

        wait.until(ExpectedConditions.visibilityOf(countrySearch.Currency_Name));

        List<MobileElement> countries;
        if (platform.equals("iOS")) {
            countries = driver.findElementsByName("x");
        } else {
            countries = driver.findElementsById("text_country_name");
        }

        for (MobileElement country : countries) {
            if (country.getText().contains(nation)) {
                country.click();
                break;
            }
        }
    }

    @Then("^\"([^\"]*)\" is dislayed as the destination country$")
    public void is_dislayed_as_the_destination_country(String nation) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(liveQuote.Rate));
        Assert.assertTrue(liveQuote.Rate.getText().contains(nation));
    }

    @Then("^I can see a search bar with repopulated hint text$")
    public void i_can_see_a_search_bar_with_repopulated_hint_text() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Country_Search));
        Assert.assertTrue(countrySearch.Country_Search.getText().contains("Search over 50 countries"));
    }

    @When("^I tap on the search bar$")
    public void i_tap_on_the_search_bar() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Country_Search)).click();
    }

    @Then("^the search bar is positioned at the top of the screen$")
    public void the_search_bar_is_positioned_at_the_top_of_the_screen() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Header_Country_Search));
    }

    @Then("^the keyboard is displayed$")
    public void the_keyboard_is_displayed() throws Throwable {
       driver.getKeyboard();
    }

    @When("^I enter \"([^\"]*)\"$")
    public void i_enter(String text) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Header_Country_Search));
        countrySearch.Header_Country_Search.sendKeys(text);
    }

    @Then("^\"([^\"]*)\" and \"([^\"]*)\" are displayed in the Country Search results$")
    public void and_are_displayed_in_the_Country_Search_results(String nation1, String nation2) throws Throwable {
        List<MobileElement> countries;
        if (platform.equals("iOS")) {
            countries = driver.findElementsByName("x");
        } else {
            countries = driver.findElementsById("text_country_name");
        }

        for (MobileElement country : countries) {
            Assert.assertTrue(country.getText().contains(nation1) || country.getText().contains(nation2));
        }
    }

    @Then("^no countries are listed$")
    public void no_countries_are_listed() throws Throwable {
        if (platform.equals("iOS")) {
            Assert.assertEquals(0, driver.findElementsById("x").size());
        } else {
            Assert.assertEquals(0, driver.findElementsById("text_country_name").size());
        }
    }

    @Then("^the Not Listed message is displayed$")
    public void the_Not_Listed_message_is_displayed() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(countrySearch.Message));
        Assert.assertTrue(countrySearch.Message.getText().contains("Not listed?"));
    }
}

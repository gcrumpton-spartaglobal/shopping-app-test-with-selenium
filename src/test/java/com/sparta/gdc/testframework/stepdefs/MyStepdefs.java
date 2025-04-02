package com.sparta.gdc.testframework.stepdefs;

import com.sparta.gdc.testframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.io.IOException;

public class MyStepdefs {
    private Website website;
    private static final String BASE_URL = "https://react-shopping-cart-67954.firebaseapp.com/";

    @Before
    public static void setUp() throws IOException {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }


    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        website = TestSetup.getWebsite(BASE_URL);
    }

    @When("I click the cart button")
    public void iClickTheCartButton() {
        website.getHomePage().clickCartButton();
    }

    @Then("The cart menu is opened")
    public void theCartMenuIsOpened() {
        String emptyCartMsg = website.getHomePage().getEmptyCartText();
        MatcherAssert.assertThat(emptyCartMsg, Matchers.containsStringIgnoringCase("Add some products"));
    }
}

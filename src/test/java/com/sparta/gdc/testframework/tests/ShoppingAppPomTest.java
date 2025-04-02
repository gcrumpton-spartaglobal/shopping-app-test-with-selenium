package com.sparta.gdc.testframework.tests;

import com.sparta.gdc.testframework.pages.Website;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.is;

public class ShoppingAppPomTest extends TestSetup {
    protected static final String BASE_URL = "https://react-shopping-cart-67954.firebaseapp.com/";
    private Website website;


    @Test
    @DisplayName("Check that we are on the homepage")
    void openWebsite_OpensToHomePage() {
       website = getWebsite(BASE_URL);

        MatcherAssert.assertThat(website.getCurrentUrl(),
                Matchers.containsStringIgnoringCase("https://react-shopping-cart-67954.firebaseapp.com/"));
    }

    @Test
    @DisplayName("Check that we can open the cart")
    void clickOnCart_OpensCart() {
        website = getWebsite(BASE_URL);

        website.getHomePage().clickCartButton();

        String emptyCartMsg = website.getHomePage().getEmptyCartText();

        MatcherAssert.assertThat(emptyCartMsg,
                Matchers.containsStringIgnoringCase("Add some products in the cart"));
    }
}

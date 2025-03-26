package com.sparta.gdc.simpletests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleTest extends TestSetup {
    @Test
    @DisplayName("Check that the webdriver works")
    public void checkWebDriver() {
        webDriver.get(BASE_URL);
        Assertions.assertEquals(BASE_URL, webDriver.getCurrentUrl());
        Assertions.assertEquals("Typescript React Shopping cart", webDriver.getTitle());
    }
}

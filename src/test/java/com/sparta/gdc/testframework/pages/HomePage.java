package com.sparta.gdc.testframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver webDriver;
    private By cartButton = new By.ByCssSelector("#root > div > div.sc-1h98xa9-1.fMOJZp > button");
//
    private By emptyCartText = new By.ByCssSelector("#root > div > div.sc-1h98xa9-1.kQlqIC > div > div.sc-7th5t8-0.jehOnP > p");
//
    private By cartButtonItemNum = new By.ByXPath("//*[@id=\"root\"]/div/div[2]/button/div/div");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    // Method to click cart button
    public void clickCartButton() {
        webDriver.findElement(this.cartButton).click();
    }

    public String getEmptyCartText() { return webDriver.findElement(this.emptyCartText).getText(); }

    // Method to check number of items in cart
    public void getNumItemsInCart() { webDriver.findElement(this.cartButtonItemNum).getText(); }

}

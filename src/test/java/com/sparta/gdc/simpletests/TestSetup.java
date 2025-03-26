package com.sparta.gdc.simpletests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class TestSetup {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    protected static final String BASE_URL = "https://react-shopping-cart-67954.firebaseapp.com/";

    private static ChromeDriverService service;
    protected static WebDriver webDriver;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
//        options.setImplicitWaitTimeout(Duration.ofSeconds(10));

        return options;
    }

    @BeforeAll
    static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();

        service.start();
    }

    @AfterAll
    static void afterAll() {
        service.stop();
    }

    @BeforeEach
    void setUp() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void afterEach() {
        webDriver.quit();
    }
}

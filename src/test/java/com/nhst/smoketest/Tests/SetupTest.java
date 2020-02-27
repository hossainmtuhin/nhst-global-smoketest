package com.nhst.smoketest.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;


public class SetupTest {

    private WebDriver driver = null;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new RemoteWebDriver(new URL("http://nhst-test-automation.test.nhst.cloud/wd/hub"), DesiredCapabilities.chrome());
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        driver.get("https://www.tradewindsnews.com/");
        String metaTitle = driver.getTitle();
        System.out.println("homepage title is: " +metaTitle);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

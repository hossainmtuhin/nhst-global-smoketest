/**
 * The purpose of this Test file is to execute,
 * test and verify the valid Login and Logout
 * as part of the Global Editorial Smote Test,
 * for all the Publications under ROCKET project.
 *
 * @author Hossain Mahmood Tuhin
 */

package com.nhst.smoketest.Tests;

import com.nhst.smoketest.Utils.URLTextUtils;
import com.nhst.smoketest.Utils.XPathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.linkText;

import com.nhst.smoketest.Pages.GoogleSearchPage;


public class GoogleSearchTest {

    private WebDriver driver = null;
//    private WebDriverWait wait = null;
//    public String loginMenuButton = XPathUtils.Login.LOGIN_MENU;

    /* --------------------------- ALL TEST METHODS ARE UNDER THIS SECTION --------------------------------------------*/

    @BeforeTest
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("start-maximized"); // open Browser in maximized mode - instead of using driver.manage().window().maximize();
        options.addArguments("enable-automation");

        options.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(new URL("http://nhst-test-automation.test.nhst.cloud/wd/hub"), options);
//        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), options);

    // Initialize WAIT - timeout in seconds
//        wait = new WebDriverWait(driver, 50);
    }

    @AfterTest
    public void tearDow() {
        driver.close();
        driver.quit();
    }

    @Test(priority = 1)
    public void googleSearch() {
        driver.get("https://www.google.com/");

        GoogleSearchPage.textboxSearch(driver).sendKeys("POM Example");
        GoogleSearchPage.btnSearch(driver).sendKeys(Keys.RETURN);
    }

    /* ------------------------------------- WILL BE ABANDONED --------------------------------------------------------*/


} // END OF GoogleSearchTest Class



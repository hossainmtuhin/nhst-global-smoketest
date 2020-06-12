/**
 * The purpose of this Test file is to execute,
 * test and verify the valid Login and Logout
 * as part of the Global Editorial Smote Test,
 * for all the Publications under ROCKET project.
 *
 * @author Hossain Mahmood Tuhin
 */

package com.nhst.smoketest.Tests;

import com.nhst.smoketest.Pages.GoogleSearchPageObjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;


public class GoogleSearchPageObjTest {

    private WebDriver driver = null;
//    private WebDriverWait wait = null;

    // create object for the page class by calling constructor method
    GoogleSearchPageObjects googleSearchPageObjects = new GoogleSearchPageObjects(driver);

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
    public void googleSearchObj() {
        driver.get("https://www.google.com/");
        googleSearchPageObjects.setTextInSearchBox("POM Example");
        googleSearchPageObjects.clickSearchButton();
    }

    /* ------------------------------------- WILL BE ABANDONED --------------------------------------------------------*/


} // END OF GoogleSearchTest Class



/**
 * The purpose of this Test file is to execute,
 * test and verify the valid Login and Logout
 * as part of the Global Editorial Smote Test,
 * for all the Publications under ROCKET project.
 *
 * @author Hossain Mahmood Tuhin
 */

package com.nhst.smoketest.Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.nhst.smoketest.Utils.URLTextUtils;
import com.nhst.smoketest.Utils.XPathUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.linkText;


public class LoginTest {

    private WebDriver driver = null;
    private WebDriverWait wait = null;

    public String loginMenuButton = XPathUtils.Login.LOGIN_MENU;

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
        wait = new WebDriverWait(driver, 50);
    }

    @Test(priority = 1)
    public void testTWLoginLogout() {
        driver.get(URLTextUtils.TW_HomePage.BASE_URL);
        testTWHomePageTitleCheck();
        clickCancelWisepopPopup();
        testTWLoginFromHomePage();
//        testSuccessfulLogoutENSite();
    // To check if user is successfully logged out and navigated back to the home page
//        testTWHomePageTitleCheck();
//        testTWLoginFromLoginPage();
        /*
           TODO
           Check whether the 'Paywall' is present or not after successful login for all the publications
        */
    }

    @Test(priority = 2)
    public void testUPSLoginLogout() {
        driver.get(URLTextUtils.UP_HomePage.BASE_URL);
        testUPSHomePageTitleCheck();
//        clickCancelWisepopPopup();
        testUPSLoginFromHomePage();
//        testSuccessfulLogoutENSite();
//        testUPSHomePageTitleCheck();
    }

//     @Test(priority = 3)
    public void testRELoginLogout() {
        driver.get(URLTextUtils.RE_HomePage.BASE_URL);
        testREHomePageTitleCheck();
//        clickCancelWisepopPopup();
        testRELoginFromHomePage();
        testSuccessfulLogoutENSite();
        testREHomePageTitleCheck();
    }

//    @Test(priority = 4)
    public void testIFCOMLoginLogout() {
        driver.get(URLTextUtils.IFCOM_HomePage.BASE_URL);
        testIFCOMHomePageTitleCheck();
        clickCancelWisepopPopup();
        testIFCOMLoginFromHomePage();
        testSuccessfulLogoutENSite();
        testIFCOMHomePageTitleCheck();
    }

//    @Test(priority = 5)
    public void testIFNOLoginLogout() {
        driver.get(URLTextUtils.IFNO_HomePage.BASE_URL);
        testIFNOHomePageTitleCheck();
        clickCancelWisepopPopup();
        testIFNOLoginFromHomePage();
        testSuccessfulLogoutNOSite();
        testIFNOHomePageTitleCheck();
    }

//    @Test(priority = 6)
    public void testEPELoginLogout() {
        driver.get(URLTextUtils.EPE_HomePage.BASE_URL);
        testEPEHomePageTitleCheck();
        clickCancelWisepopPopup();
        testEPELoginFromHomePage();
        testSuccessfulLogoutNOSite();
        testEPEHomePageTitleCheck();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    /* ---------------------------------------- TW Login Logout -------------------------------------------------------*/

    // To assert the title of the TW homepage - verify that user is on the homepage.
    // Also, to check if user is successfully logged out and navigated back to the home page.
    public void testTWHomePageTitleCheck() {
        Assert.assertEquals(driver.getTitle(), URLTextUtils.TW_HomePage.HOME_PAGE_TITLE, "Home page Meta title didn't match - page mismatch");
        System.out.println("TW Homepage Title has been matched. TW homepage has been loaded.");
    }

    public void testTWLoginFromHomePage() {
        try {
            // To wait unit the element(button) became clickable - timeout in 10 seconds.
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginMenuButton)));
            driver.findElement(By.xpath(XPathUtils.Login.LOGIN_MENU)).click();
            driver.findElement(By.id("username")).sendKeys("testuser_standard@dispostable.com");
            driver.findElement(By.id("password")).sendKeys("testuser");
            driver.findElement(By.id("login_button")).click();
            System.out.println("login button click action performed");
        // Implicit wait - timeout in 10 seconds
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // To verify that the login was successful for valid credentials
            testPageElementsCheckAfterSuccessfulLoginEN("Home page", "TW");
        } catch (ElementClickInterceptedException exception) {
            System.out.println("For Tradewinds, login test from homepage has failed due to wisepop issues. Do this manually as of now");
        }
    }

//    will do this under regression
//    public void testTWLoginFromLoginPage() {
//        driver.get(URLTextUtils.UP_HomePage.LOGIN_PAGE);
//        // send the username/email
//        driver.findElement(By.id("username")).sendKeys("testuser_up@dispostable.com");
//        // send the password
//        driver.findElement(By.id("password")).sendKeys("testuser");
//        // click the login button
//        driver.findElement(By.id("login_button")).click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        testPageElementsCheckAfterSuccessfulLoginEN("Login page", "TW");
//    }

    /* ---------------------------------------- UPS Login Logout -------------------------------------------------------*/

    public void testUPSHomePageTitleCheck() {
    // Compare the actual and expected page titles.
        Assert.assertEquals(driver.getTitle(), URLTextUtils.UP_HomePage.HOME_PAGE_TITLE, "Home page Meta title didn't match - page mismatch");
        System.out.println("UPS Homepage Title has been matched. UPS site has been loaded.");
    }

    public void testUPSLoginFromHomePage() {
        try {
        // To wait unit the element(button) became clickable - timeout in 10 seconds.
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginMenuButton)));
        // click on the LOGIN MENU button  when it's clickable
            driver.findElement(By.xpath(loginMenuButton)).click();
            System.out.println("login button click action performed");
            driver.findElement(By.id("username")).sendKeys("testuser_up@dispostable.com");
            driver.findElement(By.id("password")).sendKeys("testuser");
            driver.findElement(By.id("login_button")).click();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            testPageElementsCheckAfterSuccessfulLoginEN("Home page", "UPS");
        } catch (ElementClickInterceptedException e) {
            System.out.println("login menu wasn't clickable - login test from homepage has failed");
        }

    }

    /* ---------------------------------------- RE Login Logout -------------------------------------------------------*/

    public void testREHomePageTitleCheck() {
        Assert.assertEquals(driver.getTitle(), URLTextUtils.RE_HomePage.HOME_PAGE_TITLE, "Home page Meta title didn't match - page mismatch");
        System.out.println("RE Homepage Title has been matched. RE site has been loaded.");
    }

    public void testRELoginFromHomePage() {
    // click on the LOGIN MENU button  when it's clickable
        driver.findElement(By.xpath(loginMenuButton)).click();
        driver.findElement(By.id("username")).sendKeys("testuser_reon");
        driver.findElement(By.id("password")).sendKeys("testuser");
        driver.findElement(By.id("login_button")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testPageElementsCheckAfterSuccessfulLoginEN("Home page", "RE");
    }

    /* ---------------------------------------- IFCOM Login Logout -------------------------------------------------------*/

    public void testIFCOMHomePageTitleCheck() {
        Assert.assertEquals(driver.getTitle(), URLTextUtils.IFCOM_HomePage.HOME_PAGE_TITLE, "Home page Meta title didn't match - page mismatch");
        System.out.println("IFCOM Homepage Title has been matched. IFCOM site has been loaded.");
    }

    public void testIFCOMLoginFromHomePage() {
    // click on the LOGIN MENU button  when it's clickable
        driver.findElement(By.xpath(loginMenuButton)).click();
        driver.findElement(By.id("username")).sendKeys("testuser_ifco");
        driver.findElement(By.id("password")).sendKeys("testuser");
        driver.findElement(By.id("login_button")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testPageElementsCheckAfterSuccessfulLoginEN("Home page", "IFCOM");
    }

    /* ---------------------------------------- IFNO Login Logout -------------------------------------------------------*/

    public void testIFNOHomePageTitleCheck() {
        Assert.assertEquals(driver.getTitle(), "Intrafish.no | De siste nyhetene om oppdrettsn\u00E6ringen.", "Home page Meta title didn't match - page mismatch");
        System.out.println("IFNO Homepage Title has been matched. IFNO site has been loaded.");
    }

    public void testIFNOLoginFromHomePage() {
    // click on the LOGIN MENU button  when it's clickable
        driver.findElement(By.xpath(loginMenuButton)).click();
        driver.findElement(By.id("username")).sendKeys("testuser_ifno");
        driver.findElement(By.id("password")).sendKeys("testuser");
        driver.findElement(By.id("login_button")).click();
        testPageElementsCheckAfterSuccessfulLoginNO("Home page", "IFNO");
    }

    /* ---------------------------------------- EPE Login Logout -------------------------------------------------------*/

    public void testEPEHomePageTitleCheck() {
        driver.get(URLTextUtils.EPE_HomePage.BASE_URL);
        Assert.assertEquals(driver.getTitle(), URLTextUtils.EPE_HomePage.HOME_PAGE_TITLE, "Home page Meta title didn't match - page mismatch");
        System.out.println("EPE Homepage Title has been matched. EPE site has been loaded.");
    }

    public void testEPELoginFromHomePage() {
    // click on the LOGIN MENU button  when it's clickable
        driver.findElement(By.xpath(loginMenuButton)).click();
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("testuser");
        driver.findElement(By.id("login_button")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testPageElementsCheckAfterSuccessfulLoginNO("Home page", "EPE");
    }

    /*---------------------------------- Verify the login is successful -----------------------------------------------*/

    // Verify that the 'subscribe' link text for EN sites is not visible on the top nav-bar after successful login.

    /**
     *
     * TODO
     * ASSERT vpw_id cookie after login
     * use base64 decoder to collect cpid to validate
     */
    public void testPageElementsCheckAfterSuccessfulLoginEN(String Location, String Publication) {
//        boolean subLinkText = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Subscribe")));
        Assert.assertTrue(driver.findElements(By.linkText("Subscribe")).size() < 1);
        System.out.println("Login is successful from the " + Location + " for " + Publication);
    }

    // Verify that the 'Abonner' link text for Norwegian sites is not visible on the top nav-bar after successful login.
    public void testPageElementsCheckAfterSuccessfulLoginNO(String Location, String Publication) {
//        boolean subLinkText = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Abonner")));
        Assert.assertTrue(driver.findElements(By.linkText("Abonner")).size() < 1);
        System.out.println("Login is successful from the " + Location + " for " + Publication);
    }

    /*-------------------------------- Verify the Logout is successful ------------------------------------------------*/

    // Check and verify that user has successfully been logged out.
    public void testSuccessfulLogoutENSite() {
        // Check if user is already logged out
        if (driver.findElements(linkText("Subscribe")).size() > 0) {
            System.out.println("User is already logged out");
        } else {
            /** TODO
            * use explicit wait
            * before the click action on the user icon
            */
            driver.findElement(By.xpath("//div//div[2]/ul/li[1]/div/button")).click();
            // Click on the logout link text
            driver.findElement(By.xpath("//div[1]//nav/div[2]/ul/li[1]//div/a[1]")).click();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("User is logged out successfully");
        }
    }

    public void testSuccessfulLogoutNOSite() {
        // Check if user is already logged out
        if (driver.findElements(linkText("Abonner")).size() > 0) {
            System.out.println("User is already logged out");
        } else {
            /** TODO
             * use explicit wait
             * before the click action on the user icon
             */
            // To click on the 'user icon' button
            driver.findElement(By.xpath("//div//div[2]/ul/li[1]/div/button")).click();
            // To click on the logout link text
            driver.findElement(By.xpath("//div[1]//nav/div[2]/ul/li[1]//div/a[1]")).click();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("User is logged out successfully");
        }
    }

    /* ------------------------- Open new tabs and test each publications on separate tabs ----------------------------*/

    public void openNewBlankTab(int NumberOfTab) {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(NumberOfTab));
    }

    /* ------------------------------------- cancel Wisepop popup ----------------------------------------------------*/

    /*
    execute $('.wisepops-close').trigger('click'); on browser console to see the result
     */
    public void clickCancelWisepopPopup() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath("//div[contains(@class, 'wisepops-popup')]")).size() > 0 == true)
        {
            System.out.println("Wisepop Popup IS present");
            driver.findElement(By.xpath("//div[contains(@class, 'wisepops-popup')]/button")).click();
            System.out.println("wisepop cancel (click) action performed");
        } else {
            System.out.println("Wisepop Popup is not present");
        }
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /* ------------------------------------- WILL BE ABANDONED --------------------------------------------------------*/


} // END OF LOGIN CLASS



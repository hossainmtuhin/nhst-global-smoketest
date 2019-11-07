package com.nhst.smoketest.Tests;

import com.nhst.smoketest.Utils.XPathUtils;
import org.testng.Assert;
import com.nhst.smoketest.Utils.DriverManager;
import com.nhst.smoketest.Utils.URLTextUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest {

    private WebDriver driver = null;

    @Test(priority = 1)
    public void testHomePageTitleCheck() {
        driver = DriverManager.driver;
//        driver.manage().window().maximize();
        driver.get(URLTextUtils.UP_HomePage.BASE_URL);
        Assert.assertEquals(driver.getTitle(), URLTextUtils.UP_HomePage.HOME_PAGE_TITLE, "Home page Meta title didn't match");
    }

    @Test(priority = 2)
    public void testLoginFromHomePage() {
        // click on the LOGIN MENU button  when it's clickable
        driver.findElement(By.xpath(XPathUtils.UP_Login.UP_LOGIN_MENU)).click();
        // send the username/email
        driver.findElement(By.id("username")).sendKeys("testuser_up@dispostable.com");
        // send the password
        driver.findElement(By.id("password")).sendKeys("testuser");
        // click the login button
        driver.findElement(By.id("login_button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 3)
    // Verify that the 'subscribe' link text is not visible on the header after successful login.
    public void testHomePageElementsCheck() throws InterruptedException {
        boolean subscribe = driver.findElements(By.linkText("Subscribe")).size() < 1;
        Assert.assertTrue(subscribe);
    }

    @Test(priority = 4)
    public void tearDown() {
        driver.quit();
    }
}

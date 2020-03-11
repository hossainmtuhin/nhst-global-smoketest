package com.nhst.smoketest.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;


public class SetupTest {

    private WebDriver driver = null;
    private WebDriverWait wait = null;

    @BeforeTest
    public void setUp() throws Exception {
//        final DesiredCapabilities dc = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("start-maximized"); // open Browser in maximized mode - instead of using driver.manage().window().maximize();
        options.addArguments("enable-automation");

        options.setCapability(ChromeOptions.CAPABILITY, options);


//        driver = new RemoteWebDriver(new URL("http://nhst-test-automation.test.nhst.cloud/wd/hub"), options);
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), options);

//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.chromiumdriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.iedriver().setup();
//        WebDriverManager.edgedriver().setup();

//        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new InternetExplorerDriver();
//        driver = new EdgeDriver();

//        driver.manage().window().maximize();

        // Initialize WAIT - timeout in xx seconds
        wait = new WebDriverWait(driver, 50);
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

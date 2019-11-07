package com.nhst.smoketest.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverManager {

    static {
        /*
        TODO
        Set drivers for other browsers
        IE is higher priority
         */
        System.setProperty("webdriver.chrome.driver","D:/testAutomation_/tools/chromedriver_win32/chromedriver.exe");
    }

    public static WebDriver driver = new ChromeDriver();

    @Test
    public void DriverExecution() {
        System.out.println("Driver Executed!");
    }

    private DriverManager() {}
}

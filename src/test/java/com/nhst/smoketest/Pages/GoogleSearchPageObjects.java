package com.nhst.smoketest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
    // create a class for each web page
    WebDriver driver = null;

    // add object locators
    By textSearch = By.name("q");
    By btnSearch = By.name("btnK");

    // constructor
    public GoogleSearchPageObjects(WebDriver driver) {
        this.driver = driver;
    }
    // add action methods
    public void setTextInSearchBox(String text) {
        driver.findElement(textSearch).sendKeys(text);
    }
    // add action methods
    public void clickSearchButton() {
        driver.findElement(btnSearch).sendKeys(Keys.RETURN);
    }
}

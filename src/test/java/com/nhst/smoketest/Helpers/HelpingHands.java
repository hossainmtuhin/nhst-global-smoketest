package com.nhst.smoketest.Helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HelpingHands {

    public boolean isElementPresent(WebElement element) {
//        Boolean result = false;
        try {
          if (element != null) {
              return true;
          }
        } catch (NoSuchElementException e) {}
        return false;
    }

    public boolean isElementPresentWithStringAttribute(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                return true;
            }
        } catch (NoSuchElementException e) {
//            return false;
        }
        return result;
    }
}

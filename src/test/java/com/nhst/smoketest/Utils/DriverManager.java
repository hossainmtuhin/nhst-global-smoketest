/**
 * OBSOLETE
 */

package com.nhst.smoketest.Utils;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class DriverManager {

    static {
        /*
        TODO
        Set drivers for other browsers
        IE is higher priority
        Launch all browser drivers with webDriverManager - DONE
         */
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.edgedriver().setup();
}

    public static WebDriverManager m_driver = new EdgeDriverManager();

    @Test
    public void DriverExecution() {
        System.out.println("Driver Executed!");
    }
//
    private DriverManager() {}
}

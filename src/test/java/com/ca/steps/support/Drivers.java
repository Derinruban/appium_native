package com.ca.steps.support;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * Created by Derin on 26/3/16.
 */
public class Drivers {

    private static WebDriver driver;
    private static String browser = null;


    public static String getBrowser() {
        browser = System.getProperty("browser");
        return browser;
    }
    

    public static WebDriver getDriver() throws IOException {
        getBrowser();

//		browser is set at command line
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

}

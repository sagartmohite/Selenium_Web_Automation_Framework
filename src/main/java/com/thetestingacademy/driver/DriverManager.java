package com.thetestingacademy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager
{
    public static WebDriver driver;

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void init()
    {
        if(driver==null)
        {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--guest");
            options.addArguments("--headless");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
    }

    public static void down()
    {
        if(driver != null)
        {
            driver.quit();
            driver=null;
        }
    }
}

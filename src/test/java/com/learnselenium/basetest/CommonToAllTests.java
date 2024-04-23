package com.learnselenium.basetest;

import com.learnselenium.driver.DriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class CommonToAllTests
{
    // To call the Start the Webdriver
    // Down the WebDriver

    // Start Webdirver start

    @BeforeTest
    public void setUp()
    {
        DriverManager.init();
    }


    // Who will close the Webdriver
    @AfterTest
    public void tearDown()
    {
        DriverManager.down();
    }

    protected void takeScreenShot(String name, WebDriver driver)
    {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    public static String captureScreenshot(WebDriver driver) throws IOException {
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination_filepath = new File(System.getProperty("user.dir") + "images/screenshot" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(srcfile, destination_filepath);
        return destination_filepath.toString();
    }
}

package com.thetestingacademy.tests;

import com.aventstack.extentreports.ExtentTest;
import com.thetestingacademy.basetest.CommonToAllTests;
import com.thetestingacademy.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.thetestingacademy.basetest.CommonToAllTests.captureScreenshot;


public class TestVWOLogin extends CommonToAllTests
{
    ExtentTest test;
    private static final Logger logger = LogManager.getLogger(TestVWOLogin.class);

    @Test
    public void testLoginNegative(Method method) throws IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");


        WebElement emailInputBox =  driver.findElement(By.id("login-username")); // Page Locator
        emailInputBox.sendKeys("admin@admin.com"); // Page Action

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text  = error_msg.getText();
        String error_msg_attribute_dataqa  = error_msg.getAttribute("data-qa");
        System.out.println(error_msg_attribute_dataqa);

        logger.info("Failed");

        if (error_msg_text.equalsIgnoreCase(error_msg_text)) {
            logger.info("Failed");
            test.fail("Failed Testcases");
            test.addScreenCaptureFromBase64String(captureScreenshot(DriverManager.getDriver()));
            takeScreenShot(method.getName(), DriverManager.getDriver());
        }

        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");
        driver.quit();
    }
}

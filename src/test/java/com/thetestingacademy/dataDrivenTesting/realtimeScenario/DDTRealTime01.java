package com.thetestingacademy.dataDrivenTesting.realtimeScenario;

import com.thetestingacademy.dataDrivenTesting.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DDTRealTime01
{
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "loginData")
    public void testDataDriven(String email, String password, String expectedResult) {
        driver.get("https://app.vwo.com");
        WebElement emailElement = driver.findElement(By.id("login-username"));
        emailElement.clear();
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id("login-password"));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

        if (expectedResult.equalsIgnoreCase("Valid")) {
            String text = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
            System.out.println(text);
            Assert.assertEquals(text,"Wingify");
        }
        if (expectedResult.equalsIgnoreCase("InValid")) {
            WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(error_message));
            Assert.assertTrue(error_message.isDisplayed());
            Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
        }
    }

    @DataProvider(name = "loginData")
    public String[][] testDataExcel() throws IOException {
        String testDataFile = "src/test/resources/TataData.xlsx";
        ExcelReader excelReader = new ExcelReader(testDataFile);
        String[][] data = excelReader.getDataFromSheet(testDataFile, "LoginData");
        return data;
    }

//    @Test(dataProvider = "loginData")
//    public void testDataDriven(String td, String email, String password, String expectedResult)
//    {
//        //System.out.println(td);
//        driver.get("https://app.vwo.com");
//        WebElement emailElement = driver.findElement(By.id("login-username"));
//        emailElement.clear();
//        emailElement.sendKeys(email);
//        WebElement passwordElement = driver.findElement(By.id("login-password"));
//        passwordElement.clear();
//        passwordElement.sendKeys(password);
//        driver.findElement(By.id("js-login-btn")).click();
//
//        if (expectedResult.equalsIgnoreCase("Valid")) {
//            String text = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
//            System.out.println(text);
//            Assert.assertEquals(text,"Wingify");
//        }
//        if (expectedResult.equalsIgnoreCase("InValid")) {
//            WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//            wait.until(ExpectedConditions.visibilityOf(error_message));
//            Assert.assertTrue(error_message.isDisplayed());
//            Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
//        }
//    }
//
//
//    @DataProvider(name = "loginData")
//    public Object [][] testDataExcel()
//    {
//        return new Object[][]{
//                {"TD1", "93npu2yyb0@esiix.comi", "Wingify@123", "InValid"},
//                {"TD2", "93npu2yyb0@esiix.com", "Wingify@123", "Valid"},
//        };
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

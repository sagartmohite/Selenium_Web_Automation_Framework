package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.driver;
import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPages
{
    public CommonToAllPages() {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVWOLoginURL()
    {
        getDriver().get(PropertyReader.readKey("url"));
    }

    // This is common to all the Pages
    public void clickElement(By by)
    {
        getDriver().findElement(by).click();
    }

    public void enterInput(By by, String key)
    {
        getDriver().findElement(by).sendKeys(key);
    }

    // Wait Explicits here

    public WebElement presenceOfElement(By elementLocation)
    {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation)
    {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key)
    {
        return getDriver().findElement(key);
    }
}

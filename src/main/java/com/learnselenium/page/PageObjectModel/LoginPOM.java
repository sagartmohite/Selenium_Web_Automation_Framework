package com.learnselenium.page.PageObjectModel;

import com.learnselenium.base.CommonToAllPages;
import com.learnselenium.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM extends CommonToAllPages {
    WebDriver driver;

    public LoginPOM() {
        super();
    }

    //page locators
    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");
    By error_message = By.id("js-notification-box-msg");


    //page actions
    public String loginToVWOInvalidCreds() {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password, "admin");
        clickElement(signButton);
        //presenceOfElement(error_message);
        visibilityOfElement(error_message);
        return getElement(error_message).getText();

    }

    public void loginToVWOValidCreds() {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password, PropertyReader.readKey("password"));
        clickElement(signButton);
        // Dashboard
    }

    public DashboardPage_POM afterLoginVWOValidCreds() {
        return new DashboardPage_POM();
    }
}
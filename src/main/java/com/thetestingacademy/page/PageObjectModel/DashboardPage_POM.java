package com.thetestingacademy.page.PageObjectModel;

import com.thetestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPages
{
    public DashboardPage_POM()
    {

    }

    //page locattors
    By userNameOnDashboardPage = By.cssSelector("[data-qa=\"lufexuloga\"]");

    //page actions

    public String LoggedInUsername()
    {
        return presenceOfElement(userNameOnDashboardPage).getText();
    }
}

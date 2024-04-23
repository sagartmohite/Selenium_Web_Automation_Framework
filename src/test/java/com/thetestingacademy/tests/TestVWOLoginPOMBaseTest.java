package com.thetestingacademy.tests;

import com.thetestingacademy.basetest.CommonToAllTests;
import com.thetestingacademy.page.PageObjectModel.DashboardPage_POM;
import com.thetestingacademy.page.PageObjectModel.LoginPOM;
import com.thetestingacademy.utils.PropertyReader;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginPOMBaseTest extends CommonToAllTests
{
    @Test(groups = {"smoke"}, priority = 1)
    public void testLoginNegative()
    {
        LoginPOM loginPOM = new LoginPOM();
        loginPOM.openVWOLoginURL();
        String error_messge = loginPOM.loginToVWOInvalidCreds();

        //  TestNG
        Assert.assertEquals(error_messge, "Your email, password, IP address or location did not match");

        //AssertJ
        Assertions.assertThat(error_messge)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("error_message"));
    }

    @Test(priority = 2)
    public void testLoginPositive()
    {
        LoginPOM loginPOM = new LoginPOM();
        loginPOM.openVWOLoginURL();
        loginPOM.loginToVWOValidCreds();

        DashboardPage_POM dashboardPagePom = loginPOM.afterLoginVWOValidCreds();
        String name = dashboardPagePom.LoggedInUsername();

        //TestNG
        Assert.assertEquals(name, PropertyReader.readKey("expected_username"));

        //AssertJ
        Assertions.assertThat(name)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("expected_username"));
    }
}

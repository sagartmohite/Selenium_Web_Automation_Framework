package com.thetestingacademy.tests;

import com.thetestingacademy.basetest.CommonToAllTests;
import com.thetestingacademy.page.PageObjectModel.LoginPOM;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginPOM extends CommonToAllTests
{
    @Test
    public void testLoginNegative()
    {
        LoginPOM loginPOM = new LoginPOM();
        loginPOM.openVWOLoginURL();
        //loginPOM.
        String error_message = loginPOM.loginToVWOInvalidCreds();
        Assert.assertEquals(error_message, "Your email, password, IP address or location did not match");
    }
}

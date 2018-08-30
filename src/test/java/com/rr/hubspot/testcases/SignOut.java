package com.rr.hubspot.testcases;


import com.rr.hubspot.pages.LogInPage;
import org.junit.Assert;
import org.junit.Test;

public class SignOut extends BaseTest {
    @Test
    public void SignOutTest() throws InterruptedException {

        LogInPage logInPage = new LogInPage(driver)
                .open()
                .logInAs(credentials.getProperty("email"), credentials.getProperty("password"))
                .openAccountMenu()
                .clickSignOutButton();

        waitPageTitle("HubSpot Login");
        Assert.assertEquals("HubSpot Login", logInPage.getPageTitle());
    }
}

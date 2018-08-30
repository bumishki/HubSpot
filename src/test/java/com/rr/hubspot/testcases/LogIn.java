package com.rr.hubspot.testcases;

import com.rr.hubspot.pages.LogInPage;
import com.rr.hubspot.pages.ReportsDashboardPage;
import org.junit.Assert;
import org.junit.Test;

public class LogIn extends BaseTest {

    @Test
    public void logInTest() throws InterruptedException {

        ReportsDashboardPage reportsDashboardPage = new LogInPage(driver).open()
                        .logInAs(credentials.getProperty("email"), credentials.getProperty("password"));

        waitPageTitle("Reports dashboard");
        Assert.assertEquals(properties.getProperty("companyname"),  reportsDashboardPage.getAccountName());
    }
}

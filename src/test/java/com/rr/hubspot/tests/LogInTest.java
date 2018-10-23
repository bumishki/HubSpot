package com.rr.hubspot.tests;

import com.rr.hubspot.pages.LogInPage;
import com.rr.hubspot.pages.ReportsDashboardPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class LogInTest extends BaseTest {

    @Test(priority = 3)
    public void logInLogOut() throws InterruptedException {

        ReportsDashboardPage reportsDashboardPage = new LogInPage().logInAs(userEmail, userPassword);

        assertEquals( reportsDashboardPage.getAccountName(), "Test Company");

        LogInPage logInPage = reportsDashboardPage
                .openAccountMenu()
                .clickSignOutButton();

        assertEquals( logInPage.getPageTitle(), "HubSpot Login");
    }
}

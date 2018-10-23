package com.rr.hubspot.tests;

import com.rr.hubspot.pages.CompanyInfoPage;
import com.rr.hubspot.pages.LogInPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddTaskToCompanyTest extends BaseTest {

    @Test(priority = 2)
    public void addTaskToCompany() throws InterruptedException {

        CompanyInfoPage companyInfoPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openCompaniesPage()
                .openCompanyByName("Test Company LLC");

        companyInfoPage.addTask("Test task ...");

        assertEquals( companyInfoPage.getAddedTask(), "Test task ...");
    }
}

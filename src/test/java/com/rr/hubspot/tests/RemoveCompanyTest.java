package com.rr.hubspot.tests;

import com.rr.hubspot.pages.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveCompanyTest extends BaseTest {

    @Test(priority = 3)
    public void removeNewCreatedContact() throws InterruptedException {

        CompanyInfoPage companyInfoPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openCompaniesPage()
                .openCompanyByName("Test Company LLC");

        CompaniesPage companiesPage = companyInfoPage
                .openActionsMenu()
                .pressDelete()
                .confirmDeleteCompanie();

        assertEquals(companiesPage.getPageTitle(), "Companies");
    }
}

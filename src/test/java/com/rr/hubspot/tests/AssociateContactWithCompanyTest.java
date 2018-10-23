package com.rr.hubspot.tests;

import com.rr.hubspot.elements.AssociateContactsWithCompany;
import com.rr.hubspot.pages.CompanyInfoPage;
import com.rr.hubspot.pages.LogInPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AssociateContactWithCompanyTest extends BaseTest {

    @Test(priority = 2)
    public void changeContactEmail() throws InterruptedException {

        CompanyInfoPage companyInfoPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openCompaniesPage()
                .openCompanyByName("Test Company LLC");

        AssociateContactsWithCompany associateContactsWithCompany = companyInfoPage.addContactToCompany();

        associateContactsWithCompany
                .searchContactByName("Morrison")
                .selectFindedClient("Jim", "Morrison")
                .associateContact();

        assertEquals( companyInfoPage.getAssociatedContactName(), "Jim" + " " + "Morrison");
    }
}

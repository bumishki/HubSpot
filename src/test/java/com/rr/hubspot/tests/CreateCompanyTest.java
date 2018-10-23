package com.rr.hubspot.tests;

import com.rr.hubspot.pages.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CreateCompanyTest extends BaseTest {

    @Test(priority = 1)
    public void createNewCompany() throws InterruptedException {

        CompaniesPage companiesPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openCompaniesPage();

        CompanyInfoPage companyInfoPage = companiesPage
                .addNewCompany()
                .enterCompanyDomainName("newcompanyname.com")
                .enterName("Test Company LLC")
                .createCompany();

        assertEquals( companyInfoPage.getCompanyName(), "Test Company LLC");
    }
}

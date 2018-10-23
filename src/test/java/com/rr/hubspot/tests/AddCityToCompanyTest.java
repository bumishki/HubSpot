package com.rr.hubspot.tests;

import com.rr.hubspot.pages.CompanyInfoPage;
import com.rr.hubspot.pages.LogInPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddCityToCompanyTest extends BaseTest {

    @Test(priority = 2)
    public void changeContactEmail() throws InterruptedException {

        CompanyInfoPage companyInfoPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openCompaniesPage()
                .openCompanyByName("Test Company LLC");

        companyInfoPage.changeCompanyCity("Toronto");

        assertEquals(companyInfoPage.getCompanyCity(), "Toronto");
    }
}

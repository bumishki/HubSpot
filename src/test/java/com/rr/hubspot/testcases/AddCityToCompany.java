package com.rr.hubspot.testcases;

import com.rr.hubspot.pages.CompaniesPage;
import com.rr.hubspot.pages.CompanyInfoPage;
import com.rr.hubspot.pages.LogInPage;
import org.junit.Assert;
import org.junit.Test;

public class AddCityToCompany extends BaseTest {
    @Test
    public void changeContactEmailTest() throws InterruptedException {

        CompaniesPage companiesPage = new LogInPage(driver).open()
                .logInAs(credentials.getProperty("email"), credentials.getProperty("password"))
                .openContactsMenu()
                .openCompaniesPage();

        CompanyInfoPage companyInfoPage = companiesPage.openCompanyByName(properties.getProperty("newCompanyName"));

        companyInfoPage.changeCompanyCity(properties.getProperty("newCompanyCity"));

        Assert.assertEquals(properties.getProperty("newCompanyCity"), companyInfoPage.getCompanyCity());
    }

}

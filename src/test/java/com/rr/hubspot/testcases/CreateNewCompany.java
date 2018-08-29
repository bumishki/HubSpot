package com.rr.hubspot.testcases;

import com.rr.hubspot.pages.*;
import org.junit.Assert;
import org.junit.Test;

public class CreateNewCompany extends BaseTest {
    @Test
    public void createNewCompanyTest() throws InterruptedException {

        CompaniesPage companiesPage = new LogInPage(driver).open()
                .logInAs(properties.getProperty("email"), properties.getProperty("password"))
                .openContactsMenu()
                .openCompaniesPage();

        CompanyInfoPage companyInfoPage = companiesPage
                .addNewCompany()
                .enterCompanyDomainName(properties.getProperty("newCompanyDomain"))
                .enterName(properties.getProperty("newCompanyName"))
                .createCompany();

        waitPageTitle(properties.getProperty("newCompanyName"));
        Assert.assertEquals(properties.getProperty("newCompanyName"), companyInfoPage.getCompanyName());
    }
}

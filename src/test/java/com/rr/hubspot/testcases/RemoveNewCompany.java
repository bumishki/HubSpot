package com.rr.hubspot.testcases;

import com.rr.hubspot.pages.*;
import org.junit.Assert;
import org.junit.Test;

public class RemoveNewCompany extends BaseTest {

    @Test
    public void removeNewCreatedContactTest() throws InterruptedException {

        CompaniesPage companiesPage = new LogInPage(driver).open()
                .logInAs(properties.getProperty("email"), properties.getProperty("password"))
                .openContactsMenu()
                .openCompaniesPage();

        CompanyInfoPage companyInfoPage = companiesPage.openCompanyByName(properties.getProperty("newCompanyName"));

        companyInfoPage.openActionsMenu()
                .deleteCantact()
                .deleteCantact();


        waitPageTitle("Companies");

        Assert.assertEquals("Companies", companiesPage.getPageTitle());

    }


}

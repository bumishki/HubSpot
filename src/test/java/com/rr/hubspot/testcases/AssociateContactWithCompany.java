package com.rr.hubspot.testcases;

import com.rr.hubspot.entities.AssociateContactsWithCompany;

import com.rr.hubspot.pages.CompaniesPage;
import com.rr.hubspot.pages.CompanyInfoPage;
import com.rr.hubspot.pages.LogInPage;
import org.junit.Assert;
import org.junit.Test;


public class AssociateContactWithCompany extends BaseTest {

    @Test
    public void changeContactEmailTest() throws InterruptedException {

        CompaniesPage companiesPage = new LogInPage(driver)
                .open()
                .logInAs(credentials.getProperty("email"), credentials.getProperty("password"))
                .openContactsMenu()
                .openCompaniesPage();

        CompanyInfoPage companyInfoPage = companiesPage.openCompanyByName(properties.getProperty("newCompanyName"));

        AssociateContactsWithCompany associateContactsWithCompany = companyInfoPage.addContactToCompany();

        associateContactsWithCompany
                .searchContactByName(properties.getProperty("newUserLastName"))
                .selectFindedClient(properties.getProperty("newUserFirstName"), properties.getProperty("newUserLastName"))
                .associateContact();

        refreshPage();

        String associatedClient = properties.getProperty("newUserFirstName") + " " + properties.getProperty("newUserLastName");

        Assert.assertEquals(associatedClient, companyInfoPage.getAssociatedContactName());
    }
}

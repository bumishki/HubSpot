package com.rr.hubspot.testcases;

import com.rr.hubspot.pages.CompaniesPage;
import com.rr.hubspot.pages.CompanyInfoPage;
import com.rr.hubspot.pages.LogInPage;
import org.junit.Assert;
import org.junit.Test;

public class AddNotesToCompany extends BaseTest {

    @Test
    public void changeContactEmailTest() throws InterruptedException {

        CompaniesPage companiesPage = new LogInPage(driver)
                .open()
                .logInAs(properties.getProperty("email"), properties.getProperty("password"))
                .openContactsMenu()
                .openCompaniesPage();

        CompanyInfoPage companyInfoPage = companiesPage.openCompanyByName(properties.getProperty("newCompanyName"));

        String testNote = "Test notes ...";
        companyInfoPage.addNewNote(testNote);

        Assert.assertEquals(testNote, companyInfoPage.getAddedNote());
    }
}

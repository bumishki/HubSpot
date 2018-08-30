package com.rr.hubspot.testcases;


import com.rr.hubspot.pages.ContactInfoPage;

import com.rr.hubspot.pages.LogInPage;
import org.junit.Assert;
import org.junit.Test;


public class ChangeContactEmail extends BaseTest {


    @Test
    public void changeContactEmailTest() throws InterruptedException {

        ContactInfoPage contactInfoPage = new LogInPage(driver).open()
                .logInAs(credentials.getProperty("email"), credentials.getProperty("password"))
                .openContactsMenu()
                .openContactsPage()
                .openContactByName(properties.getProperty("newUserFirstName"),properties.getProperty("newUserLastName"));

        String newUserEmail = "new" + contactInfoPage.getContactEmail();
        contactInfoPage.changeContactEmail(newUserEmail);

        Assert.assertEquals(newUserEmail, contactInfoPage.getContactEmail());
    }

}

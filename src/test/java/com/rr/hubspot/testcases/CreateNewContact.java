package com.rr.hubspot.testcases;

import com.rr.hubspot.pages.ContactInfoPage;
import com.rr.hubspot.pages.ContactsPage;
import com.rr.hubspot.pages.LogInPage;
import org.junit.Assert;
import org.junit.Test;

public class CreateNewContact extends BaseTest {

    @Test
    public void createNewContactTest() throws InterruptedException {

        ContactsPage contactsPage =
                new LogInPage(driver)
                .open()
                .logInAs(properties.getProperty("email"), properties.getProperty("password"))
                .openContactsMenu()
                .openContactsPage();

        ContactInfoPage contactInfoPage = contactsPage
                .addNewContact()
                .enterEmail(properties.getProperty("newUserEmail"))
                .enterFirstName(properties.getProperty("newUserFirstName"))
                .enterLastName(properties.getProperty("newUserLastName"))
                .enterJobTitle(properties.getProperty("newUserJobTitle"))
                .createContact();

        waitElement(contactInfoPage.contactName);
        String newUserName = properties.getProperty("newUserFirstName") + " " + properties.getProperty("newUserLastName");
        Assert.assertEquals(newUserName, contactInfoPage.getContactName());
    }
}

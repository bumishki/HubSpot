package com.rr.hubspot.testcases;

import com.rr.hubspot.pages.ContactInfoPage;
import com.rr.hubspot.pages.ContactsPage;
import com.rr.hubspot.pages.LogInPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoveNewContact extends BaseTest {

    @Test
    public void removeNewCreatedContactTest() throws InterruptedException {

        ContactInfoPage contactInfoPage = new LogInPage(driver).open()
                .logInAs(properties.getProperty("email"), properties.getProperty("password"))
                .openContactsMenu()
                .openContactsPage()
                .openContactByName(properties.getProperty("newUserFirstName"),properties.getProperty("newUserLastName"));

        ContactsPage contactsPage = contactInfoPage
                .openActionsMenu()
                .deleteCantact()
                .deleteCantact();

        waitPageTitle("Contacts");

        Assert.assertEquals("Contacts", contactsPage.getPageTitle());

    }
}

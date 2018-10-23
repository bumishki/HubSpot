package com.rr.hubspot.tests;

import com.rr.hubspot.pages.ContactInfoPage;
import com.rr.hubspot.pages.ContactsPage;
import com.rr.hubspot.pages.LogInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RemoveContactTest extends BaseTest {

    @Test(priority = 3)
    public void removeNewCreatedContact() throws InterruptedException {

        ContactInfoPage contactInfoPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openContactsPage()
                .openContactByName("Jim", "Morrison");

        ContactsPage contactsPage = contactInfoPage
                .openActionsMenu()
                .pressDelete()
                .confirmDeleteContact();

        assertEquals(contactsPage.getPageTitle(), "Contacts");
    }
}

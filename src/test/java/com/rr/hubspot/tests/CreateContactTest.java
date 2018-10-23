package com.rr.hubspot.tests;

import com.rr.hubspot.pages.ContactInfoPage;
import com.rr.hubspot.pages.ContactsPage;
import com.rr.hubspot.pages.LogInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateContactTest extends BaseTest {

    @Test(priority = 1)
    public void createNewContact() throws InterruptedException {

        ContactsPage contactsPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openContactsPage();

        ContactInfoPage contactInfoPage = contactsPage
                .addNewContact()
                .enterEmail("jim@mail.com")
                .enterFirstName("Jim")
                .enterLastName("Morrison")
                .enterJobTitle("Singer")
                .createContact();

        assertEquals(contactInfoPage.getContactName(), "Jim" + " " + "Morrison");
    }
}

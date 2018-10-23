package com.rr.hubspot.tests;

import com.rr.hubspot.pages.ContactInfoPage;
import com.rr.hubspot.pages.LogInPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ChangeContactEmailTest extends BaseTest {

    @Test(priority = 2)
    public void changeContactEmail() throws InterruptedException {

        ContactInfoPage contactInfoPage = new LogInPage()
                .logInAs(userEmail, userPassword)
                .openContactsMenu()
                .openContactsPage()
                .openContactByName("Jim", "Morrison");

        String newUserEmail = "new" + contactInfoPage.getContactEmail();
        contactInfoPage.changeContactEmail(newUserEmail);

        assertEquals(contactInfoPage.getContactEmail(), newUserEmail);
    }
}

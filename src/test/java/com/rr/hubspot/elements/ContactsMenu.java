package com.rr.hubspot.elements;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.pages.BasePage;
import com.rr.hubspot.pages.CompaniesPage;
import com.rr.hubspot.pages.ContactsPage;

import static com.codeborne.selenide.Selenide.$x;

public class ContactsMenu extends BasePage {

    SelenideElement contacts = $x("//a[@id='nav-secondary-contacts']");
    SelenideElement companies = $x("//a[@id='nav-secondary-companies']");
    SelenideElement activityFeed = $x("//a[@id='nav-secondary-activity']");

    public ContactsPage openContactsPage() {
        contacts.click();
        return new ContactsPage();
    }

    public CompaniesPage openCompaniesPage() {
        companies.click();
        return new CompaniesPage();
    }
}

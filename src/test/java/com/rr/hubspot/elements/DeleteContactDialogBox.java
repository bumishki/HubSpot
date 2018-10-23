package com.rr.hubspot.elements;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.pages.CompaniesPage;
import com.rr.hubspot.pages.ContactsPage;

import static com.codeborne.selenide.Selenide.$x;

public class DeleteContactDialogBox {

    SelenideElement deleteButton = $x("//button[@data-selenium-test='delete-dialog-confirm-button']");

    public CompaniesPage confirmDeleteCompanie() {
        deleteButton.click();
        return new CompaniesPage();
    }

    public ContactsPage confirmDeleteContact() {
        deleteButton.click();
        return new ContactsPage();
    }
}

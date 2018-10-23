package com.rr.hubspot.elements;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.pages.BasePage;
import com.rr.hubspot.pages.ContactInfoPage;
import static com.codeborne.selenide.Selenide.$x;

public class AssociateContactsWithCompany extends BasePage {

    SelenideElement searchContactTextBox = $x("//input[@class='form-control private-form__control private-search-control__input']");
    SelenideElement client(String clientFirstName, String clientLastName )  {
        SelenideElement element  = $x("//i18n-string[contains(.,'" + clientFirstName + " " + clientLastName + "')]");
        return element;
    }
    SelenideElement saveButton = $x("//button[@data-selenium-test='base-dialog-confirm-btn']");

    public AssociateContactsWithCompany searchContactByName(String name) throws InterruptedException {
        searchContactTextBox.setValue(name);
        return this;
    }

    public AssociateContactsWithCompany selectFindedClient(String firstName, String lastName) throws InterruptedException {
        client(firstName, lastName).click();
        return this;
    }

    public ContactInfoPage associateContact()  {
        saveButton.click();
        return new ContactInfoPage();
    }
}

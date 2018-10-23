package com.rr.hubspot.pages;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.elements.NavigationBar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class ContactsPage extends BasePage {

    public ContactsPage() {

    }

    SelenideElement createNewContactButton = $x("//button[@data-selenium-test='new-object-button']");
    SelenideElement emailTextBox = $x("//input[@data-selenium-test='property-input-email']");
    SelenideElement firstNameTextBox = $x("//input[@data-selenium-test='property-input-firstname']");
    SelenideElement lastNameTextBox = $x("//input[@data-selenium-test='property-input-lastname']");
    SelenideElement jobTitleTextBox = $x("//input[@data-selenium-test='property-input-jobtitle']");
    SelenideElement createContactButton = $x("//button[@data-selenium-test='base-dialog-confirm-btn']");
    SelenideElement deleteSelectionButton = $x("//span[text()='Delete']");

    public ContactsPage checkClientInListByName(String clientFirstName, String clientLastName) {
        SelenideElement clientInListCheckBox = $x("//a[text()='" + clientFirstName + " " + clientLastName + "']/ancestor::td/preceding-sibling::td//input");
        clientInListCheckBox.click();
        return this;
    }

    public SelenideElement clientName( String clientFirstName, String clientLastName) {
        SelenideElement clientName = $x("//a[text()='" + clientFirstName + " " + clientLastName + "']");

        return clientName;
    }


    public ContactsPage addNewContact() {
        createNewContactButton.waitUntil(visible, 5000).click();
        return this;
    }

    public ContactsPage enterEmail(String email) throws InterruptedException {
        emailTextBox.setValue(email);
        Thread.sleep(2000);
        return this;
    }

    public ContactsPage enterFirstName(String firstName) {
        firstNameTextBox.setValue(firstName);
        return this;
    }

    public ContactsPage enterLastName(String LastName) {
        lastNameTextBox.setValue(LastName);
        return this;
    }

    public ContactsPage enterJobTitle(String jobTitle) {
        jobTitleTextBox.setValue(jobTitle);
        return this;
    }

    public ContactInfoPage createContact() {
        createContactButton.click();
        return new ContactInfoPage();
    }

    public ContactInfoPage openContactByName(String clientFirstName, String clientLastName) {
        clientName(clientFirstName, clientLastName).click();
        return new ContactInfoPage();
    }


}

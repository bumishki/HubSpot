package com.rr.hubspot.pages;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.elements.ContactActionsMenu;
import com.rr.hubspot.elements.NavigationBar;

import static com.codeborne.selenide.Selenide.$x;

public class ContactInfoPage extends BasePage {

    public ContactInfoPage() {

    }

    SelenideElement backToContactsPage = $x("//span[@class='private-icon private-icon__low private-breadcrumbs__arrow private-breadcrumbs__arrow--back']");
    SelenideElement contactName = $x("//div[@data-selenium-component='ProfileHighlightContainer']//span[@class='private-truncated-string__inner']");
    SelenideElement actionsMenuButton = $x("//button[@data-selenium-test='profile-settings-actions-btn']");
    SelenideElement email = $x("//div[@data-profile-property='email']//div[@class='p-x-0 col-xs-12 ']/div");
    SelenideElement emailTextBox = $x("//*[text()='Email address']/../../../following-sibling::div//input");
    SelenideElement saveEmailButton = $x("//button[@class='uiButton private-button private-button--xs private-button--tertiary private-editable-control__save private-button--non-link']");
    SelenideElement exitEmailPopupButton  = $x("//div[@class='private-clickable private-close__button UICloseButton__CloseButton-bDPSxA hWgAUu UIDialogButton__DialogButton-jxlvsj private-modal__control gdqJVy']");

    public ContactsPage backToContactsPage() {
        backToContactsPage.click();
        return new ContactsPage();
    }

    public String getContactName() {
        return contactName.getText();
    }

    public String getContactEmail() {
        return email.getText();
    }

    public ContactInfoPage changeContactEmail(String newEmail) throws InterruptedException {
        email.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(newEmail);
        saveEmailButton.click();
        exitEmailPopupButton.click();
        Thread.sleep(1000);
        return this;
    }

    public ContactActionsMenu openActionsMenu() {
        actionsMenuButton.click();
        return new ContactActionsMenu();
    }

}
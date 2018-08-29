package com.rr.hubspot.pages;

import com.rr.hubspot.entities.ContactActionsMenu;
import com.rr.hubspot.entities.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends NavigationBar {

    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='private-icon private-icon__low private-breadcrumbs__arrow private-breadcrumbs__arrow--back']")
    public WebElement backToContactsPage;

    @FindBy(xpath = "//div[@data-selenium-component='ProfileHighlightContainer']//span[@class='private-truncated-string__inner']")
    public WebElement contactName;

    @FindBy(xpath = "//button[@data-selenium-test='profile-settings-actions-btn']")
    public WebElement actionsMenuButton;

    @FindBy(xpath = "//div[@data-profile-property='email']//div[@class='p-x-0 col-xs-12 ']/div")
    public WebElement email;

    @FindBy(xpath = "//*[text()='Email address']/../../../following-sibling::div//input")
    public WebElement emailTextBox;

    @FindBy(xpath = "//button[@class='uiButton private-button private-button--xs private-button--tertiary private-editable-control__save private-button--non-link']")
    public WebElement saveEmailButton;

    @FindBy(xpath = "//div[@class='private-clickable private-close__button UICloseButton__CloseButton-bDPSxA hWgAUu UIDialogButton__DialogButton-jxlvsj private-modal__control gdqJVy']")
    public WebElement exitEmailPopupButton;

    public ContactsPage backToContactsPage() {
        backToContactsPage.click();
        return new ContactsPage(driver);
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
        return new ContactActionsMenu(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
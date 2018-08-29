package com.rr.hubspot.pages;

import com.rr.hubspot.entities.AssociateContactsWithCompany;
import com.rr.hubspot.entities.ContactActionsMenu;
import com.rr.hubspot.entities.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyInfoPage extends NavigationBar {

    public CompanyInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='private-icon private-icon__low private-breadcrumbs__arrow private-breadcrumbs__arrow--back']")
    public WebElement backToCompaniesPage;

    @FindBy(xpath = "//div[@data-selenium-component='ProfileHighlightContainer']//span[@class='private-truncated-string__inner']")
    public WebElement companyName;

    @FindBy(xpath = "//button[@data-selenium-test='profile-settings-actions-btn']")
    public WebElement actionsMenuButton;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-city']")
    public WebElement cityTextBox;

    @FindBy(xpath = "//button/span[text()='Add contact']")
    public WebElement addContuctButton;

    @FindBy(xpath = "//div[@class='m-bottom-1 is--heading-7']")
    public WebElement contact;

    @FindBy(xpath = "//a[@data-onboarding='note-tab']")
    public WebElement newNoteButton;

    @FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
    public WebElement notesTextBox;

    @FindBy(xpath = "//button[@data-selenium-test='rich-text-editor-controls__save-btn']")
    public WebElement saveNoteButton;

    @FindBy(xpath = "//span[@data-selenium-test='body-content-note'][1]/div/div")
    public WebElement addedNote;

    @FindBy(xpath = "//*[@data-key='crm_components.UniversalSaveBar.save']")
    public WebElement saveChangesButton;

    public String getCompanyName() {
        return companyName.getText();
    }

    public String getCompanyCity() {
        return cityTextBox.getAttribute("value");
    }

    public CompanyInfoPage changeCompanyCity(String newCity) throws InterruptedException {
        cityTextBox.clear();
        cityTextBox.sendKeys(newCity);
        saveChangesButton.click();
        Thread.sleep(1000);
        return this;
    }

    public AssociateContactsWithCompany addContactToCompany() throws InterruptedException {
        addContuctButton.click();
        return new AssociateContactsWithCompany(driver);
    }

    public String getAssociatedContactName() {
        return contact.getText();
    }

    public CompanyInfoPage addNewNote(String note) throws InterruptedException {
        newNoteButton.click();
        notesTextBox.click();
        notesTextBox.sendKeys(note);
        saveNoteButton.click();
        return this;
    }

    public CompanyInfoPage getAddedNote() throws InterruptedException {
        addedNote.getText();
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

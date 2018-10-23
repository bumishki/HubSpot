package com.rr.hubspot.pages;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.elements.AssociateContactsWithCompany;
import com.rr.hubspot.elements.ContactActionsMenu;
import com.rr.hubspot.elements.NavigationBar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CompanyInfoPage extends BasePage {

    public CompanyInfoPage() {

    }

    SelenideElement backToCompaniesPage = $x("//span[@class='private-icon private-icon__low private-breadcrumbs__arrow private-breadcrumbs__arrow--back']");

    SelenideElement companyName = $x("//div[@data-selenium-component='ProfileHighlightContainer']//span[@class='private-truncated-string__inner']");

    SelenideElement actionsMenuButton = $x("//button[@data-selenium-test='profile-settings-actions-btn']");

    SelenideElement cityTextBox = $x("//input[@data-selenium-test='property-input-city']");

    SelenideElement addContuctButton = $x("//button/span[text()='Add contact']");

    SelenideElement contact = $x("//div[@class='m-bottom-1 is--heading-7']");

    SelenideElement newNoteButton = $x("//a[@data-onboarding='note-tab']");

    SelenideElement createTaskButton = $x("//a[@data-tab-id='task']");

    SelenideElement taskInputTextBox = $x("//input[@data-selenium-test='communicator__task-title-input']");

    SelenideElement saveTaskButton = $x("//button[@data-selenium-test='task-interaction__save-btn']");

    SelenideElement addedTask = $x("//span[@data-selenium-test='communicator__task-title-readonly']/span/span");

    SelenideElement saveChangesButton = $x("//*[@data-key='crm_components.UniversalSaveBar.save']");

    public String getCompanyName() {
        return companyName.waitUntil(visible, 5000).getText();
    }

    public String getCompanyCity() {
        return cityTextBox.getAttribute("value");
    }

    public CompanyInfoPage changeCompanyCity(String newCity) throws InterruptedException {
        cityTextBox.clear();
        cityTextBox.setValue(newCity);
        saveChangesButton.click();
        Thread.sleep(1000);
        return this;
    }

    public AssociateContactsWithCompany addContactToCompany() throws InterruptedException {
        addContuctButton.click();
        return new AssociateContactsWithCompany();
    }

    public String getAssociatedContactName() {
        return contact.getText();
    }

    public CompanyInfoPage addTask(String note) throws InterruptedException {
        createTaskButton.click();
        taskInputTextBox.setValue(note);
        saveTaskButton.click();
        return this;
    }

    public String getAddedTask() throws InterruptedException {
        return addedTask.getText();
    }

    public ContactActionsMenu openActionsMenu() {
        actionsMenuButton.click();
        return new ContactActionsMenu();
    }


}

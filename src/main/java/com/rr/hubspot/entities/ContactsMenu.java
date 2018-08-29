package com.rr.hubspot.entities;

import com.rr.hubspot.pages.BasePage;
import com.rr.hubspot.pages.CompaniesPage;
import com.rr.hubspot.pages.ContactsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsMenu extends BasePage {

    public ContactsMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='nav-secondary-contacts']")
    public WebElement contacts;

    @FindBy(xpath = "//a[@id='nav-secondary-companies']")
    public WebElement companies;

    @FindBy(xpath = "//a[@id='nav-secondary-activity']")
    public WebElement activityFeed;

    public ContactsPage openContactsPage() {
        contacts.click();
        return new ContactsPage(driver);
    }

    public CompaniesPage openCompaniesPage() {
        companies.click();
        return new CompaniesPage(driver);
    }

}

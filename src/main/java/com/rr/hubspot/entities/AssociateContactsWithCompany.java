package com.rr.hubspot.entities;

import com.rr.hubspot.pages.BasePage;
import com.rr.hubspot.pages.ContactInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssociateContactsWithCompany extends BasePage {

    public AssociateContactsWithCompany (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='form-control private-form__control private-search-control__input']")
    public WebElement searchContactTextBox;

    public WebElement client(WebDriver driver,String clientFirstName, String clientLastName )  {
        By clientNameLocator = By.xpath("//i18n-string[contains(.,'" + clientFirstName + " " + clientLastName + "')]");
        WebElement element = driver.findElement(clientNameLocator);
        return element;
    }

    @FindBy(xpath = "//button[@data-selenium-test='base-dialog-confirm-btn']")
    public WebElement saveButton;


    public AssociateContactsWithCompany searchContactByName(String name) throws InterruptedException {
        searchContactTextBox.sendKeys(name);
        return this;
    }

    public AssociateContactsWithCompany selectFindedClient(String firstName, String lastName) throws InterruptedException {
        client(driver, firstName, lastName).click();
        return this;
    }

    public ContactInfoPage associateContact()  {
        saveButton.click();
        return new ContactInfoPage(driver);
    }
}

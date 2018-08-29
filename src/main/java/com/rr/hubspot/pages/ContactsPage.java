package com.rr.hubspot.pages;

import com.rr.hubspot.entities.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends NavigationBar {

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-selenium-test='new-object-button']")
    public WebElement createNewContactButton;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-firstname']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-lastname']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-jobtitle']")
    public WebElement jobTitleTextBox;

    @FindBy(xpath = "//button[@data-selenium-test='base-dialog-confirm-btn']")
    public WebElement createContactButton;

    public ContactsPage checkClientInListByName(String clientFirstName, String clientLastName) {
        By clientInListCheckBoxLocator = By.xpath("//a[text()='" + clientFirstName + " " + clientLastName + "']/ancestor::td/preceding-sibling::td//input");
        driver.findElement(clientInListCheckBoxLocator).click();
        return this;
    }

    public WebElement clientName(WebDriver driver,String clientFirstName, String clientLastName )  {
        By clientNameLocator = By.xpath("//a[text()='" + clientFirstName + " " + clientLastName + "']");
        WebElement element = driver.findElement(clientNameLocator);
        return element;
    }

    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement deleteSelectionButton;

    public ContactsPage addNewContact()  {
        createNewContactButton.click();
        return this;
    }

    public ContactsPage enterEmail(String email) throws InterruptedException {
        emailTextBox.sendKeys(email);
        Thread.sleep(2000);
        return this;
    }

    public ContactsPage enterFirstName(String firstName)  {
        firstNameTextBox.sendKeys(firstName);
        return this;
    }

    public ContactsPage enterLastName(String LastName)  {
        lastNameTextBox.sendKeys(LastName);
        return this;
    }

    public ContactsPage enterJobTitle(String jobTitle) {
        jobTitleTextBox.sendKeys(jobTitle);
        return this;
    }

    public ContactInfoPage createContact()  {
        createContactButton.click();
        return new ContactInfoPage(driver);
    }

    public ContactInfoPage openContactByName(String clientFirstName, String clientLastName)  {
        clientName(driver,clientFirstName, clientLastName).click();
        return new ContactInfoPage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

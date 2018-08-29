package com.rr.hubspot.entities;

import com.rr.hubspot.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends Page {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='nav-primary-contacts-branch']")
    public WebElement contactsMenu;

    @FindBy(xpath = "//a[@id='nav-primary-conversations-branch']" )
    public WebElement conversationsMenu;

    @FindBy(xpath = "//a[@id='nav-primary-marketing-branch']")
    public WebElement marketingMenu;

    @FindBy(xpath = "//a[@id='nav-primary-sales-branch']")
    public WebElement salesMenu;

    @FindBy(xpath = "//a[@id='nav-primary-automation-branch']" )
    public WebElement automationMenu;

    @FindBy(xpath = "//a[@id='nav-primary-reports-branch']")
    public WebElement reportsMenu;

    @FindBy(xpath = "//input[@id='navSearch-input']" )
    public WebElement search;

    @FindBy(xpath = "//a[@id='navSetting']" )
    public WebElement settings;

    @FindBy(xpath = "//a[@id='navNotifications']" )
    public WebElement notifications ;

    @FindBy(xpath = "//a[@id='accountMenu']" )
    public WebElement accountMenu;

    @FindBy(xpath = "//span[@class='account-name ']" )
    public WebElement accountName;

    public ContactsMenu openContactsMenu() {
        contactsMenu.click();
        return new ContactsMenu(driver);
    }

    public AccountMenu openAccountMenu() {
        accountMenu.click();
        return new AccountMenu(driver);
    }

    public String getAccountName(){
        return accountName.getText();
    }



}

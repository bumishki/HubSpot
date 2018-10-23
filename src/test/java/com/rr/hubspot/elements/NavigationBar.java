package com.rr.hubspot.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class NavigationBar {

    SelenideElement contactsMenu = $x("//a[@id='nav-primary-contacts-branch']");
    SelenideElement conversationsMenu = $x("//a[@id='nav-primary-conversations-branch']");
    SelenideElement marketingMenu = $x("//a[@id='nav-primary-marketing-branch']");
    SelenideElement salesMenu = $x("//a[@id='nav-primary-sales-branch']");
    SelenideElement automationMenu = $x("//a[@id='nav-primary-automation-branch']");
    SelenideElement reportsMenu = $x("//a[@id='nav-primary-reports-branch']");
    SelenideElement search = $x("//input[@id='navSearch-input']");
    SelenideElement settings = $x("//a[@id='navSetting']");
    SelenideElement notifications = $x("//a[@id='navNotifications']");
    SelenideElement accountMenu = $x("//a[@id='account-menu']");
    SelenideElement accountName = $x("//span[@class='account-name ']");

    public ContactsMenu openContactsMenu() {
        contactsMenu.waitUntil(visible, 15000).click();
        return new ContactsMenu();
    }

    public AccountMenu openAccountMenu() {
        accountMenu.waitUntil(visible, 5000).click();
        return new AccountMenu();
    }

    public String getAccountName() {
        return accountName.waitUntil(visible, 5000).text();
    }
}

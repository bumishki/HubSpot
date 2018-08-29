package com.rr.hubspot.entities;

import com.rr.hubspot.pages.BasePage;
import com.rr.hubspot.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountMenu extends BasePage {

    public AccountMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='signout']")
    public WebElement signOut;

    public LogInPage clickSignOutButton() {
        signOut.click();
        return new LogInPage(driver);
    }

}

package com.rr.hubspot.entities;

import com.rr.hubspot.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactActionsMenu extends Page {

    public ContactActionsMenu (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-selenium-test='profile-settings-profileSettings.delete']")
    public WebElement deleteButton;

    public DeleteContactDialogBox deleteCantact() {
        deleteButton.click();
        return new DeleteContactDialogBox(driver);
    }



}

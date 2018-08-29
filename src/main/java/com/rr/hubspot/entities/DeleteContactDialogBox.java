package com.rr.hubspot.entities;

import com.rr.hubspot.pages.ContactsPage;
import com.rr.hubspot.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteContactDialogBox extends Page {

    public DeleteContactDialogBox(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-selenium-test='delete-dialog-confirm-button']")
    public WebElement deleteButton;

    public ContactsPage deleteCantact() {
        deleteButton.click();
        return new ContactsPage(driver);
    }

}

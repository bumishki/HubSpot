package com.rr.hubspot.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ContactActionsMenu {

    public ContactActionsMenu () {

    }

    SelenideElement deleteButton = $x("//button[@data-selenium-test='profile-settings-profileSettings.delete']");

    public DeleteContactDialogBox pressDelete() {
        deleteButton.click();
        return new DeleteContactDialogBox();
    }



}

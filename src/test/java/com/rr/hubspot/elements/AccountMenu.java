package com.rr.hubspot.elements;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.pages.BasePage;
import com.rr.hubspot.pages.LogInPage;
import static com.codeborne.selenide.Selenide.$x;

public class AccountMenu extends BasePage {

    SelenideElement signOut = $x("//a[@id='signout']");

    public LogInPage clickSignOutButton() {
        signOut.click();
        return new LogInPage();
    }
}

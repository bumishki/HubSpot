package com.rr.hubspot.pages;

import com.rr.hubspot.elements.NavigationBar;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.title;

public class BasePage extends NavigationBar {

    public String getPageTitle() {
        sleep(3000);
        return title();
    }

}

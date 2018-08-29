package com.rr.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}

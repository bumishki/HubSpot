package com.rr.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Page {

    public BasePage (WebDriver driver) {
        super(driver);
    }


    public void click(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    public void enterText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }


}

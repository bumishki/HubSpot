package com.rr.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailTextBox ;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='remember']")
    private WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[@id='loginBtn']")
    private WebElement logInButton;

    public LogInPage open()  {
        driver.get("https://app.hubspot.com/login");
        PageFactory.initElements(driver, this);
        return this;
    }

    public ReportsDashboardPage logInAs(String username, String password) throws InterruptedException {
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        logInButton.click();
        return new ReportsDashboardPage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}


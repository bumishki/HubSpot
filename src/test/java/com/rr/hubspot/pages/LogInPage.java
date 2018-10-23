package com.rr.hubspot.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class LogInPage extends BasePage {

    public LogInPage() {
        open("https://app.hubspot.com/login");
    }

    SelenideElement emailTextBox = $x("//input[@id='username']");
    SelenideElement passwordTextBox = $x("//input[@id='password']");
    SelenideElement logInButton = $x("//button[@id='loginBtn']");


    public ReportsDashboardPage logInAs(String username, String password) throws InterruptedException {
        emailTextBox.setValue(username);
        passwordTextBox.setValue(password);
        logInButton.click();
        sleep(1000);
        return new ReportsDashboardPage();
    }

}


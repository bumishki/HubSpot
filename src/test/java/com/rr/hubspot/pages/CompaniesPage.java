package com.rr.hubspot.pages;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.elements.NavigationBar;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CompaniesPage extends BasePage {

    SelenideElement createNewCompanyButton  = $x("//button[@data-selenium-test='new-object-button']");
    SelenideElement companyName(String companyName)  {
        SelenideElement company = $x("//a[text()='" + companyName + "']");
        return company;
    }
    SelenideElement companyDomainNameTextBox = $x("//input[@data-selenium-test='property-input-domain']");
    SelenideElement nameTextBox = $x("//input[@data-selenium-test='property-input-name']");
    SelenideElement createCompanyButton = $x("//button[@data-selenium-test='base-dialog-confirm-btn']");

    public CompaniesPage addNewCompany()  {
        createNewCompanyButton.click();
        return this;
    }

    public CompaniesPage enterCompanyDomainName(String companyDomainName) throws InterruptedException {
        companyDomainNameTextBox.setValue(companyDomainName);
        Thread.sleep(1000);
        return this;
    }

    public CompaniesPage enterName(String companyName)  {
        nameTextBox.clear();
        nameTextBox.setValue(companyName);
        return this;
    }

    public CompanyInfoPage createCompany()  {
        createCompanyButton.click();
        return new CompanyInfoPage();
    }

    public CompanyInfoPage openCompanyByName(String companyName)  {
        companyName(companyName).waitUntil(visible, 5000).click();
        return new CompanyInfoPage();
    }


}

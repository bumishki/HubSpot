package com.rr.hubspot.pages;

import com.rr.hubspot.entities.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompaniesPage extends NavigationBar {

    public CompaniesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-selenium-test='new-object-button']")
    public WebElement createNewCompanyButton;

    public WebElement companyName(WebDriver driver,String companyName)  {
        By companyNameLocator = By.xpath("//a[text()='" + companyName + "']");
        WebElement element = driver.findElement(companyNameLocator);
        return element;
    }

    @FindBy(xpath = "//input[@data-selenium-test='property-input-domain']")
    public WebElement companyDomainNameTextBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//button[@data-selenium-test='base-dialog-confirm-btn']")
    public WebElement createCompanyButton;

    public CompaniesPage addNewCompany()  {
        createNewCompanyButton.click();
        return this;
    }

    public CompaniesPage enterCompanyDomainName(String companyDomainName) throws InterruptedException {
        companyDomainNameTextBox.sendKeys(companyDomainName);
        Thread.sleep(1000);
        return this;
    }

    public CompaniesPage enterName(String companyName)  {
        nameTextBox.clear();
        nameTextBox.sendKeys(companyName);
        return this;
    }

    public CompanyInfoPage createCompany()  {
        createCompanyButton.click();
        return new CompanyInfoPage(driver);
    }

    public CompanyInfoPage openCompanyByName(String companyName)  {
        companyName(driver, companyName).click();
        return new CompanyInfoPage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}

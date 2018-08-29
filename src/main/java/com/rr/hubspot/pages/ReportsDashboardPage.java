package com.rr.hubspot.pages;

import com.rr.hubspot.entities.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsDashboardPage extends NavigationBar {

    public ReportsDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-owns='dropdown-1']")
    private WebElement dashboardsMenuButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement exportButton;

    @FindBy(xpath = "//button[@aria-owns='dropdown-2']")
    private WebElement shareButton;

    @FindBy(xpath = "//input[@id='add-report']")
    private WebElement addReportButton;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public ReportsDashboardPage openDashboardMenu() {
        dashboardsMenuButton.click();
        return this;
    }

    public ReportsDashboardPage clickEportButton() {
        exportButton.click();
        return this;
    }

    public ReportsDashboardPage clickShareButton() {
        shareButton.click();
        return this;
    }

    public ReportsDashboardPage clickAddReportButton() {
        addReportButton.click();
        return this;
    }

}

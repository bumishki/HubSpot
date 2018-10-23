package com.rr.hubspot.pages;

import com.codeborne.selenide.SelenideElement;
import com.rr.hubspot.elements.NavigationBar;
import static com.codeborne.selenide.Selenide.$x;

public class ReportsDashboardPage extends BasePage {

    SelenideElement dashboardsMenuButton = $x("//button[@aria-owns='dropdown-1']");
    SelenideElement exportButton = $x("//input[@id='password']");
    SelenideElement shareButton = $x("//button[@aria-owns='dropdown-2']");
    SelenideElement addReportButton = $x("//input[@id='add-report']");

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

package com.rr.hubspot.testcases;

import com.rr.hubspot.entities.NavigationBar;
import com.rr.hubspot.pages.LogInPage;
import com.rr.hubspot.pages.Page;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public Properties properties;
    public Page page;

    @Before

    public void openBrowser() throws InterruptedException {
        initProperties();

        System.setProperty("webdriver.chrome.driver", properties.getProperty("chromedriverUrl"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //driver.get(properties.getProperty("url"));

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    public void initProperties() {

        properties = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
        }

    }


    public WebDriver logIn() throws InterruptedException {
        LogInPage logInPage = PageFactory.initElements(driver,LogInPage.class);
        /*logInPage.emailTextBox.sendKeys(properties.getProperty("email"));
        logInPage.passwordTextBox.sendKeys(properties.getProperty("password"));
        logInPage.logInButton.click();*/

        NavigationBar navigationBar = PageFactory.initElements(driver,NavigationBar.class);;
        waitElement(navigationBar.accountName);

        page = new Page(driver);
        return driver;
    }

    public WebDriver logIn(String username, String password) throws InterruptedException {

        LogInPage logInPage = new LogInPage(driver);
        /*logInPage.emailTextBox.sendKeys(username);
        logInPage.passwordTextBox.sendKeys(password);
        logInPage.logInButton.click();*/

        NavigationBar navigationBar = PageFactory.initElements(driver,NavigationBar.class);;

        waitElement(navigationBar.accountName);
        page = new Page(driver);
        return driver;
    }

    public void waitPageTitle (String title) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitElement (By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void waitElement (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void refreshPage () throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
    }

}

package com.rr.hubspot.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {


    private Properties credentials;
    public String url = "url";
    public String userEmail = "email";
    public String userPassword = "pass";


    @BeforeClass
    public void setUp() throws InterruptedException {
        initCredentials();
    }

    @AfterClass
    public void tearDown() {
    }

    public void initCredentials() {

        credentials = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("credentials.properties");
        try {
            credentials.load(is);
        } catch (IOException e) {
        }
        url = credentials.getProperty("url");
        userEmail = credentials.getProperty("email");
        userPassword = credentials.getProperty("password");

    }
}

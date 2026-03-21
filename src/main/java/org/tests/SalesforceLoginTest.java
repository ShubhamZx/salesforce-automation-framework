package org.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.SalesforceLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class SalesforceLoginTest extends BaseTest {

    WebDriverWait wait;
    SalesforceLoginPage loginPage;
    Properties config = new Properties();

    @BeforeMethod
    public void setupSalesforce() throws Exception {
        config.load(new FileInputStream("config.properties"));
        driver.get("https://login.salesforce.com");
        loginPage = new SalesforceLoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void validSalesforceLogin() throws Exception {
        String username = config.getProperty("sf.username");
        String password = config.getProperty("sf.password");
        String baseUrl = config.getProperty("sf.url");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin(wait);

        // Navigate directly to home after login
        driver.get(baseUrl + "/lightning/page/home");

        wait.until(ExpectedConditions.titleContains("Home"));
        System.out.println("Page title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Home"));
        System.out.println("PASSED - Salesforce login successful");
    }
}
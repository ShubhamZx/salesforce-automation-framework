package org.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.SalesforceLeadPage;
import org.pages.SalesforceLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class SalesforceLeadTest extends BaseTest {

    WebDriverWait wait;
    SalesforceLoginPage loginPage;
    SalesforceLeadPage leadPage;
    Properties config = new Properties();

    @BeforeMethod
    public void setUpSalesforce() throws Exception {
        config.load(new FileInputStream("config.properties"));
        String baseUrl = config.getProperty("sf.url");

        driver.get("https://login.salesforce.com");
        loginPage = new SalesforceLoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        loginPage.enterUsername(config.getProperty("sf.username"));
        loginPage.enterPassword(config.getProperty("sf.password"));
        loginPage.clickLogin(wait);
        driver.get(baseUrl + "/lightning/page/home");
        wait.until(ExpectedConditions.titleContains("Home"));

        leadPage = new SalesforceLeadPage(driver, wait);
    }

    @Test
    public void createNewLead() throws InterruptedException {
        leadPage.openLeadsModule();
        leadPage.clickNew();
        leadPage.fillLeadForm("Shubham", "Sinha", "Accenture");
        leadPage.clickSave();

        wait.until(ExpectedConditions.titleContains("Shubham Sinha"));
        System.out.println("Page title: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Shubham Sinha"));
        System.out.println("PASSED - Lead created successfully");
    }

}



package org.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.SalesforceContactPage;
import org.pages.SalesforceLoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesforceContactTest extends BaseTest{
    WebDriverWait wait;
    SalesforceContactPage salesforceContactPage;
    SalesforceLoginPage salesforceLoginPage;

    @BeforeMethod
    public void setUp(){
        driver.get("https://dwu00000e2p792af-dev-ed.develop.my.salesforce.com/lightning/o/Contact/new");
        salesforceLoginPage = new SalesforceLoginPage(driver);
        salesforceContactPage = new SalesforceContactPage(driver, wait);
    }

    @Test
    public void requiredTest(){

    }
}

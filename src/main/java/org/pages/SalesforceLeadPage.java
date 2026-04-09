package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SalesforceLeadPage {
    WebDriver driver;
    WebDriverWait wait;

    public SalesforceLeadPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By appLauncher = By.xpath("//*[@title='App Launcher']");
    By searchBox = By.xpath("//input[@placeholder='Search apps and items...']");
    By salesApp = By.xpath("//a[@data-label='Sales']");
    By leadsTab = By.xpath("//*[@title='Leads']");
    By newButton = By.xpath("//button[text()='New']");
    By firstNameField = By.xpath("//input[@name='firstName']");
    By lastNameField = By.xpath("//input[@name='lastName']");
    By companyField = By.xpath("//input[@name='Company']");
    By saveButton = By.xpath("//button[@name='SaveEdit']");

    private void jsType(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
                element, value
        );
    }

    public void fillLeadForm(String firstName, String lastName, String company)
            throws InterruptedException {
        Thread.sleep(2000);
        jsType(firstNameField, firstName);
        jsType(lastNameField, lastName);
        jsType(companyField, company);
        System.out.println("Lead form filled");
    }

    private void jsClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void openLeadsModule() throws InterruptedException {
        driver.get("https://dwu00000e2p792af-dev-ed.develop.my.salesforce.com/lightning/o/Lead/list");
        Thread.sleep(4000);
        wait.until(ExpectedConditions.titleContains("Lead"));
        Thread.sleep(2000);
    }

    public void clickNew() throws InterruptedException {
        driver.get("https://dwu00000e2p792af-dev-ed.develop.my.salesforce.com/lightning/o/Lead/new");
        Thread.sleep(3000);
    }

    public void clickSave() throws InterruptedException {
        Thread.sleep(1000);
        jsClick(saveButton);
        Thread.sleep(3000);
    }

    public boolean isLeadPresentInListView(String leadName) throws InterruptedException{
        openLeadsModule();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.titleContains("Lead"));
        Boolean isLeadNamePresent = driver.getPageSource().contains(leadName);
        return isLeadNamePresent;
    }
}


package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceLoginPage {
    WebDriver driver;

    public SalesforceLoginPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("Login");
    By appLauncherTitle = By.xpath("//*[contains(@class,'appName')]");

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}

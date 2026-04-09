package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceContactPage {
    WebDriver driver;
    WebDriverWait wait;

    public SalesforceContactPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By locator = By.xpath("");

    public  void methodName(){

    }
}

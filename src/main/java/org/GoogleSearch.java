package org;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Salesforce careers");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        System.out.println("Page title after search: " + driver.getTitle());

        driver.quit();
    }
}

package org;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("Salesforce jobs");
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        System.out.println("Page title: " + driver.getTitle());

    }
}

package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Thread.sleep(2000);

        System.out.println("Page title after login: " + driver.getTitle());

        String message = driver.findElement(By.id("flash")).getText();
        System.out.println("Message: " + message);

        Assert.assertTrue(message.contains("You logged into a secure area!"));
        System.out.println("TEST PASSED - Login successful");

        driver.quit();

        invalidLoginTest();
    }

    public static void invalidLoginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("wrong password!");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Thread.sleep(2000);

        System.out.println("Page title after login: " + driver.getTitle());

        String message = driver.findElement(By.id("flash")).getText();
        System.out.println("Message: " + message);

        Assert.assertTrue(message.contains("Your password is invalid!"));
        System.out.println("TEST PASSED - Invalid login handled correctly");

        driver.quit();
    }
}

package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestNG {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/login");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void validLoginTest() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Thread.sleep(2000);

        System.out.println("Page title after login: " + driver.getTitle());

        String message = driver.findElement(By.id("flash")).getText();
        System.out.println("Message: " + message);

        Assert.assertTrue(message.contains("You logged into a secure area!"));
        System.out.println("PASSED - Valid login");

    }

    @Test
    public void invalidLoginTest() throws InterruptedException{
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("wrong password!");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Thread.sleep(2000);

        System.out.println("Page title after login: " + driver.getTitle());

        String message = driver.findElement(By.id("flash")).getText();
        System.out.println("Message: " + message);

        Assert.assertTrue(message.contains("Your password is invalid!"));
        System.out.println("PASSED - Invalid login");
    }
}

package org;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void jsAlertTest(){
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
        String resultMessage = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultMessage.contains("You successfully clicked an alert"));
    }

    @Test
    public void jsConfirmTest(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert  = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.dismiss();
        String resultMessage = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultMessage.contains("You clicked: Cancel"));
    }

    @Test
    public void jsPromptTest(){
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.sendKeys("Shubham");
        alert.accept();
        String alertResult = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(alertResult.contains("You entered: Shubham"));
    }
}

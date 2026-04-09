package org;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.tests.BaseTest;

import java.time.Duration;

public class FrameTest extends BaseTest {

    @BeforeMethod
    public void navigateToFrame(){
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iFrameTest() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript(
                "tinymce.get('mce_0').setContent('Shubham learns Selenium');"
        );
        Thread.sleep(1000);
        driver.switchTo().frame("mce_0_ifr");
        String iFrameText = driver.findElement(By.id("tinymce")).getText();
        System.out.println("Text: " + iFrameText);
        Assert.assertTrue(iFrameText.contains("Shubham learns Selenium"));
        driver.switchTo().defaultContent();
        System.out.println("PASSED - iframe test");
    }
}

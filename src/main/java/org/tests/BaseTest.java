package org.tests;

import org.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/Users/shubhamzx/selenium-chrome-profile");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void  tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }
        driver.quit();
    }
}

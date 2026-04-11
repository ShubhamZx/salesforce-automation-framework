package org.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;
    public static ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void setUpReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/TestReport.html");
        spark.config().setReportName("Salesforce Automation Report");
        spark.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Shubham Sinha");
        extent.setSystemInfo("Environment", "QA");
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/Users/shubhamzx/selenium-chrome-profile");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test passed");
        } else {
            test.log(Status.SKIP, "Test skipped");
        }
        driver.quit();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
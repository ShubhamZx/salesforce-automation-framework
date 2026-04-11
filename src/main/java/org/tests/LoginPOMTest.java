package org.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.Duration;

public class LoginPOMTest extends BaseTest{

    LoginPage loginPage;

    @BeforeMethod
    public void navigateToLogin(Method method){
        test = extent.createTest(method.getName());
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginValidTest() throws InterruptedException {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword(("SuperSecretPassword!"));
        loginPage.clickLogin();
        Thread.sleep(2000);
        String messsage = loginPage.getFlashMessage();

        Assert.assertTrue(messsage.contains("You logged into a secure area!"));
        System.out.println("PASSED - Valid login with POM");

    }

    @Test
    public void loginInvalidTest() throws InterruptedException {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        Thread.sleep(2000);
        String message = loginPage.getFlashMessage();

        Assert.assertTrue(message.contains("Your password is invalid"));
        System.out.println("PASSED - Invalid login with POM");
    }
}

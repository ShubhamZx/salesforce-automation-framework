package org.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPOMTest {

    WebDriver driver;
    LoginPage loginpage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginpage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginValidTest() throws InterruptedException {
        loginpage.enterUsername("tomsmith");
        loginpage.enterPassword(("SuperSecretPassword!"));
        loginpage.clickLogin();
        Thread.sleep(2000);
        String messsage = loginpage.getFlashMessage();

        Assert.assertTrue(messsage.contains("You logged into a secure area!"));
        System.out.println("PASSED - Valid login with POM");

    }

    @Test
    public void loginInvalidTest() throws InterruptedException {
        loginpage.enterUsername("tomsmith");
        loginpage.enterPassword("wrongpassword");
        loginpage.clickLogin();
        Thread.sleep(2000);
        String message = loginpage.getFlashMessage();

        Assert.assertTrue(message.contains("Your password is invalid"));
        System.out.println("PASSED - Inalid login with POM");
    }
}

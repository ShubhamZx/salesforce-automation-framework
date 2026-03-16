package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void verifyCheckboxStatus(){
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        System.out.println("Checkbox 1 is selected: " + checkbox1.isSelected());
        System.out.println("Checkbox 2 is selected: " + checkbox2.isSelected());

        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());

        System.out.println("PASSED - Checkbox status verified.");

    }
    @Test
    public void clickAndVerifyCheckbox(){
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected());
        System.out.println("PASSED - Checkbox1 is selected!");

    }

}

package org;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.tests.BaseTest;

import java.util.Set;

public class MultipleWindowsTest extends BaseTest {

    @BeforeMethod
    public void navigateToFrame() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    //@Test
    public void windowsTest() {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }

        }
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
        driver.switchTo().window(mainWindow);
        System.out.println("PASSED-Multiple Windows");
    }

    @Test
    public void scrollTest() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/large");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("PASSED- Scrolled to bottom");
    }
}


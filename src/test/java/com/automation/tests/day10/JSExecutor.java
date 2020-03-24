package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();

        driver = new ChromeDriver();
    }

    @Test
    public void scrollTest(){

        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        // !!!!!!!!!! You don't have to do the below code if you build your driver out of RemoteWebDriver class instead of just WebDriver class
        JavascriptExecutor js = (JavascriptExecutor) driver; // Ok, THis looks really weird but its not, You are just CASTING driver into JavascriptExecutor class object.
                                                                // It only LOOKS WEIRD
        for (int i = 0; i < 10 ; i++) {
            driver.executeScript("window.scrollBy(0,250)");
            BrowserUtils.wait(1);
        }
    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}

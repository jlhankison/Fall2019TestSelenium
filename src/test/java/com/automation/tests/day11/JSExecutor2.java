package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void verifyTitle(){

        String expected = "Practice";

        String actual = js.executeScript("return document.title").toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));

        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginbtn);

        BrowserUtils.wait(2);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        System.out.println(expected);
        String actual = (String) js.executeScript("return document.getElementsByClassName('subheader')[0].textContent");
        System.out.println(actual);
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void scrollToElement(){

    }


    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}

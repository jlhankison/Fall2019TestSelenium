package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class PracticeTests {

    private WebDriver driver;

    @Test
    public void lofinTest() {
        BrowserUtils.wait(5);
        driver.findElement(By.linkText("Form Authentication")).click();

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        Assert.assertEquals(expected, actual, "Sub-header message is not matching!");


    }

    /**
     * given user is on the practice landing page
     * when user navigates to "forgot password" page
     * Then user enters his email
     * and clicks "retrieve password" button
     * then user verifies that message "your e-mail's been sent!" is displayed
     * */
    @Test
    public void forgotPasswordTest(){

        driver.findElement(By.linkText("Forgot Password")).click();

        driver.findElement(By.name("email")).sendKeys("throwaway104013@gmail.com", Keys.ENTER);

        String expected = "Your e-mail's been sent!";

        String actual = driver.findElement(By.name("confirmation_message")).getText();

        Assert.assertEquals(expected,actual);

    }

    /**
     * Given user is on the practice landing page
     * when user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     **/
    @Test
    public void checkboxTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkBoxes = driver.findElements(By.id("checkboxes"));

        checkBoxes.get(0).click();
        Assert.assertTrue(checkBoxes.get(0).isEnabled());
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

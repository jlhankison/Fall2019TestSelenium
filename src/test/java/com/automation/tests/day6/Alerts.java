package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

//      Test 1

        buttons.get(0).click();  // Clicking on the first button
        BrowserUtils.wait(2);

        String popupMessage = driver.switchTo().alert().getText();
        System.out.println("popupMessage = " + popupMessage);
        driver.switchTo().alert().accept(); // accepts alert message

        String expectedText = "You successfully clicked an alert";
        String actualText = driver.findElement(By.id("result")).getText();

        if(expectedText.equals(actualText)){
            System.out.println("ALERT TEST 1 PASSED!");
        }else {
            System.out.println("ALERT TEST 1 FAILED!");
            System.out.println("expectedText = " + expectedText);
            System.out.println("actualText = " + actualText);
        }
        System.out.println("=======================================");

//======================================================================
//        Test 2

        buttons.get(1).click(); // to click on the second button
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss();

        expectedText = "You clicked: Cancel";
        actualText = driver.findElement(By.id("result")).getText();

        if(expectedText.equals(actualText)){
            System.out.println("ALERT TEST 2 PASSED!");
        }else {
            System.out.println("ALERT TEST 2 FAILED!");
            System.out.println("expectedText = " + expectedText);
            System.out.println("actualText = " + actualText);
        }
        System.out.println("=======================================");

//====================================================================
//        Test 3

        buttons.get(2).click(); // to click on the third button
        BrowserUtils.wait(2);

        String inputText = "Hello World!";
        driver.switchTo().alert().sendKeys(inputText); // Inputs text into popup alert
        driver.switchTo().alert().accept();

        expectedText = "You entered: " + inputText;
        actualText = driver.findElement(By.id("result")).getText();

        if(expectedText.equals(actualText)){
            System.out.println("ALERT TEST 3 PASSED!");
        }else {
            System.out.println("ALERT TEST 3 FAILED!");
            System.out.println("expectedText = " + expectedText);
            System.out.println("actualText = " + actualText);
        }


        BrowserUtils.wait(2);

        driver.quit();
    }
}

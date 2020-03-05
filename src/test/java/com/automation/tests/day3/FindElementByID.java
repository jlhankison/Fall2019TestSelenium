package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindElementByID {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        Sleep.s(3);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        Sleep.s(3);

        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        String actual = driver.findElement(By.tagName("h4")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }

        Sleep.s(4);

        System.out.println(driver.findElement(By.partialLinkText("Logout")).getAttribute("href"));

        driver.findElement(By.partialLinkText("Logout")).click();

        Sleep.s(4);

        driver.close();
    }
}

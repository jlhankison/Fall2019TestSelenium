package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        BrowserUtils.wait(2);

        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick=\"button3()\"]"));

        btn1.click();

        System.out.println(driver.findElement(By.xpath("//p[@style=\"color:green\"]")).getText());


        BrowserUtils.wait(2);

        driver.quit();
    }
}

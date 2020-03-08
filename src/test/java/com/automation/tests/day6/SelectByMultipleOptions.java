package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByMultipleOptions {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));

        // isMultiple method just spits out a boolean of whether this Select allows you to choose multiple answers.
        boolean isMultiple = languagesSelect.isMultiple();

        System.out.println(isMultiple);

        List<WebElement> languagesList = languagesSelect.getOptions();

        for (WebElement language: languagesList) {

            language.click();
            BrowserUtils.wait(1);


        }

        driver.close();

    }
}

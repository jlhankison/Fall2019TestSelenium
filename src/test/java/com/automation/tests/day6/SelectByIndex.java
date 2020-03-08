package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select selectState = new Select(driver.findElement(By.id("state")));

        int lastIndex = selectState.getOptions().size()-1;

        for (int i = 0; i < lastIndex; i++) {
            selectState.selectByIndex(i);
            BrowserUtils.wait(1);
        }
    }
}

package com.automation.utilities;

import org.openqa.selenium.WebDriver;

public class DriverCreationTemplate {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        BrowserUtils.wait(2);




        BrowserUtils.wait(2);

        driver.quit();
    }
}

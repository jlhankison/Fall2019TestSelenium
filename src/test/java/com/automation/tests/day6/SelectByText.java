package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));

        Select selectSimpleDropdown = new Select(simpleDropdown);

        selectSimpleDropdown.selectByVisibleText("Option 2");

        BrowserUtils.wait(2);

        selectSimpleDropdown.selectByVisibleText("Option 2");


        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        BrowserUtils.wait(1);
        selectYear.selectByVisibleText("1991");
        BrowserUtils.wait(1);

        selectMonth.selectByVisibleText("July");
        BrowserUtils.wait(1);

        selectDay.selectByVisibleText("30");

        List<WebElement> months = selectMonth.getOptions();

        for (WebElement month : months) {
            String monthName = month.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);

        }



        driver.close();
    }

}

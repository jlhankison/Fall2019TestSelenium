package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        BrowserUtils.wait(3);
    }

    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name","First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement each : columnNames) {
            System.out.println(each.getText());
        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);
    }

    @Test
    public void deleteEmailRow(){

        driver.findElement(By.xpath("//td[text()='jsmith@gmail.com']/following-sibling::td//a[@class='cell']")).click();
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        BrowserUtils.wait(3);
        Assert.assertEquals(rowCount, 3);

        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

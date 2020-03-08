package com.automation.tests.day6;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {

    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByVisibleText("District Of Columbia");

        String selected = stateSelect.getFirstSelectedOption().getText();

        if(selected.equals("District Of Columbia")){
            System.out.println("Test Passed!");
        }else{

            System.out.println("Test Failed!");
        }

        driver.close();
    }
}

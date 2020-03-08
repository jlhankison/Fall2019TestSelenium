package com.automation.tests.day5;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");



        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton : radioButtons) {

            String id = radioButton.getAttribute("id");

            // returns true if the button has already been clicked
            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected :: " + isSelected );

            if(radioButton.isEnabled() && !isSelected){
                radioButton.click();
                System.out.println("Clicked on :: " + id);

            }else if(!radioButton.isEnabled()){
                System.out.println("Button disabled :: " + id);
            }

            System.out.println();
        }

        driver.close();
    }
}

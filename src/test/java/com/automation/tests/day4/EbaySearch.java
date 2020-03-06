package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbaySearch{

    public static void main(String[] args) {

        System.out.println(numberResults("chrome", "tv"));

    }

    public static int numberResults (String browserType, String searchTerm){

        WebDriver driver = DriverFactory.createADriver(browserType);

        // go to ebay.com
        driver.get("http://ebay.com");

        // enter searchTerm into the search bar in ebay
        driver.findElement(By.id("gh-ac")).sendKeys(searchTerm);

        // click the search button
        driver.findElement(By.id("gh-btn")).click();

        // find and save the number of results string to String str
        String str = driver.findElement(By.className("srp-controls__count-heading")).getText();

        // Close the browser because we don't need it anymore
        driver.close();

        //removing excess parts of string to get just the number
        str = str.replace(str.substring(str.indexOf(" results")), "");

        // removing the comma from the number
        str = str.replace(",", "");

        // parsing the remaining number into an int
        int x = Integer.parseInt(str);


        // returning that number
        return x;


    }
}

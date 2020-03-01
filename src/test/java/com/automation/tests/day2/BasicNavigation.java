package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {
        // to start selenium script we need:
            // set up webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();


        // driver is the object that will take the commands to interact with chrome internet browser
        WebDriver driver = new ChromeDriver();

        //in selenium, everything starts from the WebDriver interface

        driver.get("http://google.com"); // opens website
        driver.manage().window().maximize(); // to maximize browser



        driver.navigate().to("http://Amazon.com"); // navigates the browser to a new web address
        driver.navigate().back(); // goes back to previous webpage


        Thread.sleep(3000); // for demonstation of effect of code, wait 3 seconds (you must add an Exception throw to use this code)

        String title = driver.getTitle(); //returns <title> some title </title> text

        String expectedTitle = "Google";

        verifyEquals(driver.getTitle(), expectedTitle);

        driver.navigate().forward(); // moves forward back to amazon.com

        verifyEquals(driver.getTitle().toLowerCase(), "amazon"); // calls my verifyEquals method to check if the amazon title (when lowercase) contains or is equal to "amazon"

        verifyEquals(driver.getCurrentUrl(), "https://www.amazon.com");

        driver.close(); // closes opened websites MUST BE AT THE END!

    }


    public static void verifyEquals(String arg1, String arg2){

        if (arg1.equals(arg2)){
            System.out.println("test passed " + arg1 + " equals " + arg2);
        }else if (arg1.contains(arg2)){
            System.out.println("Problem! \"" + arg1 + "\" does not equal \"" + arg2 + "\" but \"" + arg1 + "\" contains \"" + arg2 + "\"");
        }else{
            System.out.println(arg1 + " does not equal " + arg2);
        }
    }


}

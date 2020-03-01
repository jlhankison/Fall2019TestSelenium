package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        String windowHandle1 = driver.getWindowHandle();
        System.out.println("windowHandle1 = " + windowHandle1);

        Thread.sleep(5000);

        // every window has some id, this id is called window handle
        // based on window handle, we can switch between windows

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles = " + windowHandles);



        for (String each : windowHandles) {
            if (!each.equals(windowHandle1)){
                driver.switchTo().window(each);
                break;
            }
        }

        driver.close();



    }

    public static void switchToWindowBasedOnTitle (String pageTitle, WebDriver driver){

        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {
            if(driver.getTitle().equals(pageTitle)){
                driver.switchTo().window(window);
            }

        }
    }
}

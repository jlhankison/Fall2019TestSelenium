package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseMethods {

    public static void main(String[] args) throws Exception{

        // close() method will only close one tab (window) opened by the web driver quit() method will close ALL the tabs (windows) opened by web driver

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(4000);


        driver.close();



    }
}

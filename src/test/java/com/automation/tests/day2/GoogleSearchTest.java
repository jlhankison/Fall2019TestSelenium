package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(2000);

        WebElement search = driver.findElement(By.name("q"));

        String input = "butts";
        for (int i = 0; i < input.length(); i++) {
            search.sendKeys(Character.toString(input.charAt(i)));
            Thread.sleep(100);
        }

        Thread.sleep(2000);

        search.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        driver.quit();


    }
}

package com.automation.tests.day4;

import com.automation.utilities.Sleep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws Exception {


        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");

        Sleep.s(3);

        List<WebElement> links =  driver.findElements(By.tagName("a"));

        for (WebElement each : links) {
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
            System.out.println();
        }

        for (int i = 1; i < links.size(); i++) {
            links.get(i).click();


            driver.navigate().back();

            links =  driver.findElements(By.tagName("a"));

        }

        driver.quit();
    }
}

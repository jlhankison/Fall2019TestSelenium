package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("https://google.com");

        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            System.out.println(searchItem.getText());

            String var = searchItem.getText();


            // if there is text, print it!
            if(!var.isEmpty()){
                System.out.println(var);
                //Verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }
    /**
    * Given User is on the amazon.com page
    * when user enters "java" as the search item
    * Then the user clicks on the first search item
    * And the user verifies that the title of the search item contains "java"
    * */
    @Test(description = "Search for Java book on Amazon")
    public void amazonSearchTest(){
        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

        driver.findElement(By.tagName("h2")).click();

        BrowserUtils.wait(2);

        String actual = driver.findElement(By.id("title")).getText().toLowerCase();

        Assert.assertTrue(actual.contains("java"));

    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}


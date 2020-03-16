package com.automation.tests.vytrack.fleet;

import com.automation.tests.vytrack.login.LoginPageTests;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class VehiclesPageTests{

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetDropdownBy = By.cssSelector("[class='dropdown dropdown-level-1']");
    private By vehiclesDropdownBy = By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span");
    private By pageNumberBy = By.cssSelector("input[type='number']");
    private Actions builder;

    @Test
    public void verifyPageSubTitle(){

        String expected = "All Cars";
        String actual = driver.findElement(By.cssSelector("[class='oro-subtitle']")).getText();
        assertEquals(expected,actual);

    }

    @Test
    public void verifyPageNumber(){


        String expected = "1";
        String actual = (driver.findElement(pageNumberBy).getAttribute("value"));

        assertEquals(expected,actual);
    }

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        builder = new Actions(driver);

        BrowserUtils.wait(5);
        WebElement element = driver.findElement(fleetDropdownBy);
        builder.moveToElement(element).perform();
        BrowserUtils.wait(5);
        driver.findElement(vehiclesDropdownBy).click();
        BrowserUtils.wait(3);

    }

    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}

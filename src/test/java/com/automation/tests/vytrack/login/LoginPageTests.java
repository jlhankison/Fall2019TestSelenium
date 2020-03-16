package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class LoginPageTests {

    private WebDriver driver;
    //https is a secured version of http protocol
    //http is a hypertext transfer protocol that every single website uses now
    //https data is encripted, no chance for hackers to retrieve info
    //http data is plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");


    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUserName(){
        driver.findElement(usernameBy).sendKeys("invalidUsername");
        driver.findElement(passwordBy).sendKeys("invalidPassword", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

    }

    @Test(description = "Login as store manager and verify that title equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(expected, actual);

    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}

package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class CallsPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By activitesBy = By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]");
    private By logCallBy = By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]");
    private By calendarButtonBy = By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]");
    private By callsBy = By.xpath("//span[contains(text(),'Calls')]");
    private By calendarBy = By.xpath("//span[contains(text(),'Calendar Events')]");
    private By titleTextBy = By.id("oro_calendar_event_form_title-uid-5e716dca14850");
    private By expectedUserBy = By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Pearl Wuckert')]");
    private By actualUserBy = By.xpath("//span[@class='select2-chosen']");
    private Actions builder;

    @Test
    public void verifyCallDisplayed(){
        driver.findElement(callsBy).click();
        BrowserUtils.wait(5);
        WebElement logCallButton = driver.findElement(logCallBy);
        assertTrue(logCallButton.isDisplayed());
    }

    @Test
    public void verifyCreateCalendarDis (){

        driver.findElement(calendarBy).click();
        BrowserUtils.wait(5);

        WebElement createCalendarButton = driver.findElement(calendarButtonBy);
        assertTrue((createCalendarButton.isDisplayed()));
    }
    /**
     * Test Case: Defaout Options
     * Login as sales manager
     * got to activites --> calendar events
     * click on calendar events
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current tim
     * */
    @Test
    public void verifyValues(){
        driver.findElement(calendarBy).click();
        BrowserUtils.wait(3);
        driver.findElement(calendarButtonBy).click();
        BrowserUtils.wait(4);
        String expectedUser = driver.findElement(expectedUserBy).getText();
        String actualUser = driver.findElement(actualUserBy).getText();
        assertTrue(expectedUser.contains(actualUser));
        assertSame("", driver.findElement(titleTextBy).getText());

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

        WebElement activitiesButton = driver.findElement(activitesBy);
        builder.moveToElement(activitiesButton).build().perform();

    }

    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}

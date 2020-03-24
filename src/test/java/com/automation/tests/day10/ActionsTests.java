package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createADriver("chrome");
        actions = new Actions(driver);
    }

    @Test
    public void hoverTest(){

        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


        actions.moveToElement(img1)
                .pause(1000)
                .moveToElement(img2)
                .pause(1000)
                .moveToElement(img3)
                .pause(1000)
                .build()
                .perform();

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
        actions.moveToElement(img3).perform();
        WebElement imgText3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(imgText3.isDisplayed());

    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");

        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enabled).pause(1000).moveToElement(downloads).pause(1000).moveToElement(pdf).click().build().perform();

        BrowserUtils.wait(5);
    }

    @Test
    public void dragAndDropTest(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);
        WebElement dropTarget = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, dropTarget).perform();
        BrowserUtils.wait(3);

        Assert.assertEquals("You did great!", dropTarget.getText());
    }

    @AfterMethod
    public void teardown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}

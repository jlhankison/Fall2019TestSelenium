package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * This class will be extended by page Classes
 * common webelemnts/locators can be stored here
 * since navigation menu doesn't belong to particular page
 * we cannot really create a dedicated page class to store
 * elements from that menu
 */
public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();

    public AbstractPageBase(){
        //PageFactory allows us to use @FindBy annotations and other useful things
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * @param tabName, based on the tabs at the top of the page (like vehicle or sales)
     * @param moduleName, based on the elements under each tab, (such as Table under Dashboards tab, or Calls under Activities Tab)
     * */
    public void navigateTo(String tabName, String moduleName){

        String tabNameXpath ="//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(),'"+moduleName+"')]";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtils.wait(3);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();
    }


}

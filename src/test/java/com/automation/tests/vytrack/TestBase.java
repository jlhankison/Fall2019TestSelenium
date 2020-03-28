package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
        //This is protected because this is an abstract class, we want this to be visible to all child classes but not anywhere else
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}

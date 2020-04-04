package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    @Test
    public void verifyPageTitle(){
        // test --> ExtentTest Object
        // we must add to every test at the beginning
        //test = report.createTest("test name");
        test = report.createTest("verify page title");
        LoginPage loginpage = new LoginPage();

        loginpage.login();
        test.info("Login as store Manager");

        String expected = "Dashboar";
        String actual = Driver.getDriver().getTitle();

        Assert.assertEquals(expected, actual);
        test.pass("Page title Dashboard was verified");
    }

    /**
     * Enter Wrong credentials and verify warning message
     */
    @Test
    public void verifyWarningMessage(){
        test = report.createTest("verify warning message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        //take a screenshot
        BrowserUtils.getScreenshot("loginPage");
        test.pass("Warning message is displayed");
    }

    @Test(dataProvider = "credentials")
    public void loginWithDDT(String username, String password){

        test = report.createTest("verify page title");
        LoginPage loginpage = new LoginPage();

        loginpage.login(username, password);
        test.info("Login as " + username);
        BrowserUtils.waitForPageToLoad(10);

        String expected = "Dashboard";
        String actual = Driver.getDriver().getTitle();

        Assert.assertEquals(actual,expected);
        test.pass("Page title Dashboard was verified");

    }
//    Object[][] or Object[] or Iterator<Object[]>
//    Object[] = 1 column with data
//    Object[][] = 2+ columns with data
    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{
                {"storemanager85","UserUser123"},
                {"salesmanager110","UserUser123"},
                {"user16", "UserUser123"},
        };
    }
}

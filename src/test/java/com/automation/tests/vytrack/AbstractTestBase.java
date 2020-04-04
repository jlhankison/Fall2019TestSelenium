package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public abstract class AbstractTestBase {
        //This is protected because this is an abstract class, we want this to be visible to all child classes but not anywhere else
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    public void setupTest(){
        report = new ExtentReports();
        String reportPath = "";
        //Location of report file
        if(System.getProperty("os.name").contains("win")){
            reportPath = System.getProperty("user.dir")+"\\test-output\\report.html";
        }else{
            reportPath = System.getProperty("user.dir")+"/test-output/report.html";
        }
        //is a html report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
    public void teardownTest(){
        report.flush(); // to release a report
    }

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
//        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());


    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult Class describes the result of the test.
        //if the test failed, take a screenshot
        if(iTestResult.getStatus() == ITestResult.FAILURE){
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName());//attach test name that failed
            BrowserUtils.wait(4);
            test.addScreenCaptureFromPath(screenshotPath); //attach screenshot
            test.fail((iTestResult.getThrowable()));// attach console output
        }
        Driver.closeDriver();
    }
}

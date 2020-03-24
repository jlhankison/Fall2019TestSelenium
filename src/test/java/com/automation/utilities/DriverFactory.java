package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {

    public static WebDriver createADriver(String browserName) {

        switch (browserName.toLowerCase()) {
            case ("chrome"):
                WebDriverManager.chromedriver().version("79").setup();
                return new ChromeDriver();
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case ("edge"):
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case ("ie"):
                WebDriverManager.iedriver().setup();
                return new EdgeDriver();
            case("opera"):
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            default:
                System.out.println("input does not match any browser type, we created a chrome driver as default");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

        }
    }
}



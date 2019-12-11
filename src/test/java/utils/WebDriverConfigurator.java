package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverConfigurator {
    private static WebDriverConfigurator instance = null;
    private static WebDriver driver;

    private WebDriverConfigurator() {
        driver = new ChromeDriver();
    }

    public static WebDriverConfigurator getInstance() {
        if (instance == null) {
            return new WebDriverConfigurator();
        } else {
            return instance;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}


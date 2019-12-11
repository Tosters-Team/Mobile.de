package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import methods.Action;
import org.openqa.selenium.WebDriver;
import utils.WebDriverConfigurator;

public class Hooks {
    public static WebDriver driver;


    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = WebDriverConfigurator.getInstance().getDriver();
        driver.get("https://www.mobile.de/");
        driver.manage().window().maximize();
    }

    @After
    public void after(){
        driver.manage().deleteAllCookies();
        Action.quitDriver();
    }
}

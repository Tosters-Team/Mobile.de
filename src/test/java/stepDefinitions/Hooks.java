package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import methods.Action;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import static utils.PropertyConfigurator.getProperty;


public class Hooks {
    public static WebDriver driver;


    @Before
    public void before() {

        driver = DriverFactory.getInstance(getProperty("BROWSER")).getDriver();
        driver.get(getProperty("URL"));
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.manage().deleteAllCookies();
        Action.quitDriver();
    }
}

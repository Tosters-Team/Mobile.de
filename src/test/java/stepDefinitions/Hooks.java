package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.driverFactory.DriverFactory;
import utils.driverFactory.DriverManager;

import static utils.PropertyConfigurator.*;


public class Hooks {
    public static WebDriver driver;
    DriverManager driverManager;


    @Before
    public void before() {
        driverManager = DriverFactory.getManager(getProperty("BROWSER"));
        driver = driverManager.getDriver();
        driver.get(getProperty("URL"));
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.manage().deleteAllCookies();
        driverManager.quitDriver();
    }
}

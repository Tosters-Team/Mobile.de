package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import utils.Log;
import utils.driverFactory.DriverFactory;
import utils.driverFactory.DriverManager;

import static utils.PropertyConfigurator.getProperty;


public class Hooks {
    public static WebDriver driver;
    private DriverManager driverManager;
    public static Scenario currentScenario;


    @Before
    public void before(Scenario scenario) {
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Testing started");
        currentScenario = scenario;
        driverManager = DriverFactory.getManager(getProperty("BROWSER"));
        driver = driverManager.getDriver();
        Log.info("New driver instantiated");
        driver.get(getProperty("URL"));
        Log.info("Web application launched");
        driver.manage().window().maximize();
        Log.info("Window maximized");
        Log.info("Starting scenario: " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        currentScenario = scenario;
        Log.info("Finished scenario: " + scenario.getName());
        driver.manage().deleteAllCookies();
        Log.info("Deleting Cookies");
        driverManager.quitDriver();
        Log.info("Driver closed");
    }
}
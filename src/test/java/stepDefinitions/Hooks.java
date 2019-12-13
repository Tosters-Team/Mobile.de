package stepDefinitions;
import java.util.Properties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import methods.Action;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {
    public static WebDriver driver;



    @Before
    public void before() {
        Properties properties = new Properties();
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");
        driver = DriverFactory.getInstance("Chrome").getDriver();
        driver.get("https://www.mobile.de/");
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.manage().deleteAllCookies();
        Action.quitDriver();
    }
}

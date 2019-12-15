package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    private static DriverFactory instance = null;
    private static WebDriver driver;

    private DriverFactory(String driverName) {

        switch (driverName) {

            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "IExplorer":
                System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

                ieCapabilities.setCapability("nativeEvents", false);
                ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
                ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
                ieCapabilities.setCapability("disable-popup-blocking", true);
                ieCapabilities.setCapability("enablePersistentHover", true);
                ieCapabilities.setCapability("ignoreZoomSetting", true);

                driver = new InternetExplorerDriver(ieCapabilities);
//                System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
//                driver = new InternetExplorerDriver();
                break;
        }

    }

    public static DriverFactory getInstance(String driverName) {
        if (instance == null) {
            return new DriverFactory(driverName);
        } else {
            return instance;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}

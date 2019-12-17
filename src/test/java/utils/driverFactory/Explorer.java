package utils.driverFactory;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Explorer extends DriverManager {

    private InternetExplorerDriverService iEService;

    @Override
    public void startService() {
        if (null == iEService) {
            try {
                iEService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(new File("src/test/testResources/drivers/IEDriverServer.exe"))
                        .usingAnyFreePort()
                        .build();
                iEService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != iEService && iEService.isRunning())
            iEService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        System.setProperty("webdriver.ie.driver", "src/test/testResources/drivers/IEDriverServer.exe");
        ieCapabilities.setCapability("nativeEvents", false);
        ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
        ieCapabilities.setCapability("disable-popup-blocking", true);
        ieCapabilities.setCapability("enablePersistentHover", true);
        ieCapabilities.setCapability("ignoreZoomSetting", true);
        driver = new InternetExplorerDriver(ieCapabilities);
    }
}

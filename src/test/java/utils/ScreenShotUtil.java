package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import stepDefinitions.Hooks;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.PropertyConfigurator.getProperty;

public class ScreenShotUtil {

    public static void takeScreenShot(String fileName) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) Hooks.driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(
                getProperty("PATH.TO.SCREENSHOTS.FOLDER")
                        +
                        fileName
                        + " " +
                        new SimpleDateFormat(getProperty("DATE.FORMAT")
                                +
                                getProperty("FORMAT.OF.SCREENSHOT")).format(new Date()));
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
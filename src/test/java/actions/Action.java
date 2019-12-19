package actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static stepDefinitions.Hooks.driver;

public class Action {

    private static final Wait waiter = new FluentWait<>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(2, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

    public static void clickOnWebElement(WebElement webElement) {
        webElement.click();
    }

    public static void sendKeys(WebElement field, String inputData) {
        field.sendKeys(inputData);
    }

    public static void sendKeys2(WebElement field, String inputData) {
        field.clear();
        field.sendKeys(inputData);
    }


    public static void waitUntilVisible(WebElement webElement) {
//        waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilClickable(WebElement webElement) {
//        waiter.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static boolean webElementContainsText(String text, WebElement webElement) {
        return webElement.getText().contains(text);
    }

    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }


}

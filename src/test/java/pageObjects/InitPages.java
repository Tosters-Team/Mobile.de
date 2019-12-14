package pageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static stepDefinitions.Hooks.driver;

public abstract class InitPages {
    private WebDriver webDriver;
    private WebElement webElement;

    public InitPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.webDriver = driver;

    }

    public WebElement getWebElementByName(String pageName) {
        return webElement;
    }

    private static final Wait waiter = new FluentWait<>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(2, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

    public static void clickOnWebElement(WebElement webElement) {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
        waiter.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void sendKeys(WebElement field, String inputData) {
        waiter.until(ExpectedConditions.visibilityOf(field));
        waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(inputData);
    }

    public static void waitUntilVisible(WebElement webElement) {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static boolean webElementContainsText(String text, WebElement webElement) {
        return webElement.getText().contains(text);
    }

    public static void clickOnAllFromList(List<WebElement> listOfWebElements) {
        for (int i = 0; i < listOfWebElements.size(); i++) {
            waiter.until(ExpectedConditions.visibilityOf(listOfWebElements.get(i)));
            waiter.until(ExpectedConditions.elementToBeClickable(listOfWebElements.get(i)));
            listOfWebElements.get(i).click();
        }

    }
}

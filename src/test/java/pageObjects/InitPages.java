package pageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

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

    public static void sendKeysWithOutClearField(WebElement field, String inputData){
        waiter.until(ExpectedConditions.visibilityOf(field));
        waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.sendKeys(inputData);
    }

    public static void waitUntilVisible(WebElement webElement) {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static boolean webElementContainsText(String text, WebElement webElement) {
        return webElement.getText().contains(text);
    }

    public static void clickOnAllFromList(List<WebElement> listOfWebElements) {
        InitPages.waitUntilVisible(listOfWebElements.get(listOfWebElements.size()-1));
        for (int i = listOfWebElements.size() - 1; i >= 0; i--) {
            clickOnWebElement(listOfWebElements.get(i));
        }
    }

    public static int getPriceForComparison(String price) {
        int priceInt = Integer.parseInt(price);
        return priceInt;
    }

    public static int getYearForComparison(String year) {
        int yearInt = Integer.parseInt(year);
        return yearInt;
    }

    public static int getMileageForComparisson(String mileage) {
        System.out.println("V init pageah problema");
        int mileageInt = Integer.parseInt(mileage);
        return mileageInt;
    }
}

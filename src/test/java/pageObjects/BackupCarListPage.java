package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Random;

public class BackupCarListPage extends InitPages{

    public BackupCarListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"so-sb\"]")
    private WebElement sortingDropDown;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[1]/h1")
    private WebElement headerMessage;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]")
    private List<WebElement> carResults;

    @FindBy(xpath = "//*[@id=\"saveSearchLink\"]")
    private WebElement saveSearchButton;

    @FindBy(xpath = "//*[@id=\"saveSearchForm\"]/div/div[2]/div/input")
    private WebElement emailNotificationCheckBox;

    @FindBy(xpath = "//*[@id=\"saveSearchBtn\"]")
    private WebElement saveSearchOnPopUp;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[2]/div[*]")
    private List<WebElement> savedSearchFilters;

    public WebElement getHeaderMessage() {
        return headerMessage;
    }

    public WebElement getSortingDropDown() {
        return sortingDropDown;
    }

    public WebElement getRandomCar() {
        Random random = new Random();
        int randomCar = random.nextInt((carResults.size()-1) - 1) + 1;
        return carResults.get(randomCar);
    }

    public WebElement getFirstCarOnPage() {
        return carResults.get(1);
    }

    public WebElement getLastCarOnPage() {
        return carResults.get(23);
    }

    public WebElement getSaveSearchButton() {
        return saveSearchButton;
    }

    public WebElement getEmailNotificationCheckBox() {
        return emailNotificationCheckBox;
    }

    public WebElement getSaveSearchOnPopUp() {
        return saveSearchOnPopUp;
    }

    public WebElement getSavedSearchFilter(int filterIndex) {
        return savedSearchFilters.get(filterIndex);
    }
}

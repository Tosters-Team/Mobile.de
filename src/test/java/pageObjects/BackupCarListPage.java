package pageObjects;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

import java.util.List;
import java.util.Random;

@Getter @Setter
@PageName(name = "Backup Car List Page")
public class BackupCarListPage extends Page {

    public BackupCarListPage() {
        super();
    }

    @WebElementName(name = "Sorting options drop-down")
    @FindBy(xpath = "//*[@id=\"so-sb\"]")
    private WebElement sortingDropDown;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[1]/h1")
    private WebElement headerMessage;

    @WebElementName(name = "Car results")
    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]")
    private List<WebElement> carResults;

    @WebElementName(name = "Save search button")
    @FindBy(xpath = "//*[@id=\"saveSearchLink\"]")
    private WebElement saveSearchButton;

    @FindBy(xpath = "//*[@id=\"saveSearchForm\"]/div/div[2]/div/input")
    private WebElement emailNotificationCheckBox;

    @WebElementName(name = "Save search button on pop-up")
    @FindBy(xpath = "//*[@id=\"saveSearchBtn\"]")
    private WebElement saveSearchOnPopUp;

    @WebElementName(name = "Saved search filters")
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

    public WebElement getSavedSearchFilter(int filterIndex) {
        return savedSearchFilters.get(filterIndex);
    }
}

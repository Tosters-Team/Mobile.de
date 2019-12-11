package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickTruckSearch {

    public QuickTruckSearch(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"rbt-VUT75-link\"]/i")
    private WebElement vansNtRucksUpTo7p5t;

    @FindBy(xpath = "//*[@id=\"rbt-TO75-link\"]/i")
    private WebElement trucksOver7p5t;

    @FindBy(xpath = "//*[@id=\"rbt-STT-link\"]/i")
    private WebElement semiTrailerTruck;

    @FindBy(xpath = "//*[@id=\"rbt-T-link\"]/i")
    private WebElement trailersCategory;

    @FindBy(xpath = "//*[@id=\"rbt-ST-link\"]/i")
    private WebElement semiTrailers;

    @FindBy(xpath = "//*[@id=\"rbt-CM-link\"]/i")
    private WebElement constructionMachines;

    @FindBy(xpath = "//*[@id=\"rbt-B-link\"]/i")
    private WebElement busesCategory;

    @FindBy(xpath = "//*[@id=\"rbt-AV-link\"]/i")
    private WebElement agriculturalVehicles;

    @FindBy(xpath = "//*[@id=\"rbt-FT-link\"]/i")
    private WebElement forkliftTrucks;

    @FindBy(xpath = "//*[@id=\"form-dsp\"]/div[1]/div/article/section/div/div[1]/h1")
    private WebElement generalTrucksCategoryHeader;

    public WebElement getVansNtRucksUpTo7p5t() {
        return vansNtRucksUpTo7p5t;
    }

    public WebElement getTrucksOver7p5t() {
        return trucksOver7p5t;
    }

    public WebElement getSemiTrailerTruck() {
        return semiTrailerTruck;
    }

    public WebElement getTrailersCategory() {
        return trailersCategory;
    }

    public WebElement getSemiTrailers() {
        return semiTrailers;
    }

    public WebElement getConstructionMachines() {
        return constructionMachines;
    }

    public WebElement getBusesCategory() {
        return busesCategory;
    }

    public WebElement getAgriculturalVehicles() {
        return agriculturalVehicles;
    }

    public WebElement getForkliftTrucks() {
        return forkliftTrucks;
    }

    public WebElement getGeneralTrucksCategoryHeader() {
        return generalTrucksCategoryHeader;
    }
}

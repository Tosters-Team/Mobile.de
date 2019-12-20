package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@PageName(name = "Quick Truck Search page")
public class QuickTruckSearch extends Page {


    public QuickTruckSearch() {
        super();
    }

    @WebElementName(name = "Vans/Trucks up to 7.5 t")
    @FindBy(xpath = "//*[@id=\"rbt-VUT75-link\"]/i")
    private WebElement vansNtRucksUpTo7p5t;

    @WebElementName(name = "Trucks over 7.5 t")
    @FindBy(xpath = "//*[@id=\"rbt-TO75-link\"]/i")
    private WebElement trucksOver7p5t;

    @WebElementName(name = "Semi-trailer truck")
    @FindBy(xpath = "//*[@id=\"rbt-STT-link\"]/i")
    private WebElement semiTrailerTruck;

    @WebElementName(name = "Trailers")
    @FindBy(xpath = "//*[@id=\"rbt-T-link\"]/i")
    private WebElement trailersCategory;

    @WebElementName(name = "Semi-Trailers")
    @FindBy(xpath = "//*[@id=\"rbt-ST-link\"]/i")
    private WebElement semiTrailers;

    @WebElementName(name = "Construction Machines")
    @FindBy(xpath = "//*[@id=\"rbt-CM-link\"]/i")
    private WebElement constructionMachines;

    @WebElementName(name = "Buses")
    @FindBy(xpath = "//*[@id=\"rbt-B-link\"]/i")
    private WebElement busesCategory;

    @WebElementName(name = "Agricultural Vehicles")
    @FindBy(xpath = "//*[@id=\"rbt-AV-link\"]/i")
    private WebElement agriculturalVehicles;

    @WebElementName(name = "Forklift Trucks")
    @FindBy(xpath = "//*[@id=\"rbt-FT-link\"]/i")
    private WebElement forkliftTrucks;

    @WebElementName(name = "Truck page header")
    @FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div/div/div/ol/li[3]")
    private WebElement generalTrucksCategoryHeader;

    @WebElementName(name = "Quick Truck Search")
    @FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div/h3")
    private WebElement quickTruckPageHeader;


    public WebElement getQuickTruckPageHeader() {
        return quickTruckPageHeader;
    }

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

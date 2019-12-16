package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuickTruckSearch extends InitPages {


    public QuickTruckSearch() {
        super();
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

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div/div/div/ol/li[3]")
    private WebElement generalTrucksCategoryHeader;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div/h3")
    private WebElement quickTruckPageHeader;

    public WebElement getQuickTruckPageHeader() {
        return quickTruckPageHeader;
    }

    @Override
    public WebElement getWebElementByName(String pageName) {
        super.getWebElementByName(pageName);
        switch (pageName) {
            case "Vans and Trucks up to 7.5 t":
                return getVansNtRucksUpTo7p5t();
            case "Trucks over 7.5 t":
                return getTrucksOver7p5t();
            case "Semi-Trailer Trucks":
                return getSemiTrailerTruck();
            case "Trailers":
                return getTrailersCategory();
            case "Semi-Trailers":
                return getSemiTrailers();
            case "Construction Machines":
                return getConstructionMachines();
            case "Buses":
                return getBusesCategory();
            case "Agricultural Vehicles":
                return getAgriculturalVehicles();
            case "Forklift Trucks":
                return getForkliftTrucks();
            default:
                return null;
        }
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

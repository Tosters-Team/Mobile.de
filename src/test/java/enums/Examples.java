package enums;

import org.openqa.selenium.WebElement;
import pageObjects.HomePageQuickSearch;
import pageObjects.QuickTruckSearch;

import static stepDefinitions.Hooks.driver;


public enum Examples {
    BMW("BMW", new HomePageQuickSearch(driver).getMakeBmw()),
    MERCEDES("Mercedes-Benz", new HomePageQuickSearch(driver).getMakeMercedes()),
    AUDI("Audi", new HomePageQuickSearch(driver).getMakeVolkswagen()),

    MODEL_A6("A6", new HomePageQuickSearch(driver).getModelGolf()),
    MODEL_FIVESERIES("5", new HomePageQuickSearch(driver).getModelFiveSeriesBmw()),
    MODEL_ECLASS("E", new HomePageQuickSearch(driver).getModelEClassMercedes()),

    VANSANDTRUCKUNDER7AND5T("Vans and Trucks up to 7.5 t", new QuickTruckSearch(driver).getVansNtRucksUpTo7p5t()),
    TRUCKSOVER7AND5T("Trucks over 7.5 t", new QuickTruckSearch(driver).getTrucksOver7p5t()),
    SEMITRUCKSTRAILERS("Semi-Trailer Trucks", new QuickTruckSearch(driver).getSemiTrailerTruck()),
    TRAILERS("Trailers", new QuickTruckSearch(driver).getTrailersCategory()),
    SEMITRAILERS("Semi-Trailers", new QuickTruckSearch(driver).getSemiTrailers()),
    CONSTRUCTIONMACHINES("Construction Machines", new QuickTruckSearch(driver).getConstructionMachines()),
    BUSES("Buses", new QuickTruckSearch(driver).getBusesCategory()),
    AGRICULTURALVEHICLES("Agricultural Vehicles", new QuickTruckSearch(driver).getAgriculturalVehicles()),
    FORKLIFTTRUCKS("Forklift Trucks", new QuickTruckSearch(driver).getForkliftTrucks());


    private String toCall;
    private WebElement webElement;

    public String getToCall() {
        return toCall;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    Examples(String toCall, WebElement webElement) {
        this.toCall = toCall;
        this.webElement = webElement;
    }
}


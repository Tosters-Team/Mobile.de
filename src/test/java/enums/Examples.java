package enums;

import org.openqa.selenium.WebElement;
import pageObjects.HomePageQuickSearch;
import pageObjects.QuickTruckSearch;


public enum Examples {
    BMW("BMW", new HomePageQuickSearch().getMakeBmw()),
    MERCEDES("Mercedes-Benz", new HomePageQuickSearch().getMakeMercedes()),
    AUDI("Audi", new HomePageQuickSearch().getMakeVolkswagen()),

    MODEL_A6("A6", new HomePageQuickSearch().getModelGolf()),
    MODEL_FIVESERIES("5", new HomePageQuickSearch().getModelFiveSeriesBmw()),
    MODEL_ECLASS("E", new HomePageQuickSearch().getModelEClassMercedes()),

    VANSANDTRUCKUNDER7AND5T("Vans and Trucks up to 7.5 t", new QuickTruckSearch().getVansNtRucksUpTo7p5t()),
    TRUCKSOVER7AND5T("Trucks over 7.5 t", new QuickTruckSearch().getTrucksOver7p5t()),
    SEMITRUCKSTRAILERS("Semi-Trailer Trucks", new QuickTruckSearch().getSemiTrailerTruck()),
    TRAILERS("Trailers", new QuickTruckSearch().getTrailersCategory()),
    SEMITRAILERS("Semi-Trailers", new QuickTruckSearch().getSemiTrailers()),
    CONSTRUCTIONMACHINES("Construction Machines", new QuickTruckSearch().getConstructionMachines()),
    BUSES("Buses", new QuickTruckSearch().getBusesCategory()),
    AGRICULTURALVEHICLES("Agricultural Vehicles", new QuickTruckSearch().getAgriculturalVehicles()),
    FORKLIFTTRUCKS("Forklift Trucks", new QuickTruckSearch().getForkliftTrucks());


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


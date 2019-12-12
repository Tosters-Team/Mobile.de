package enums;

import org.openqa.selenium.WebElement;
import pageObjects.HomePageQuickSearch;

import static stepDefinitions.Hooks.driver;

public enum MakesAndModels {
    BMW("BMW", new HomePageQuickSearch(driver).getMakeBmw()),
    MERCEDES("Mercedes-Benz", new HomePageQuickSearch(driver).getMakeMercedes()),
    AUDI("Audi", new HomePageQuickSearch(driver).getMakeAudi()),

    MODEL_A6("A6", new HomePageQuickSearch(driver).getModelA6Audi()),
    MODEL_FIVESERIES("5", new HomePageQuickSearch(driver).getModelFiveSeriesBmw()),
    MODEL_ECLASS("E", new HomePageQuickSearch(driver).getModelEClassMercedes());

    private String toCall;
    private WebElement webElement;

    public String getToCall() {
        return toCall;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    MakesAndModels(String toCall, WebElement webElement) {
        this.toCall = toCall;
        this.webElement = webElement;
    }
}


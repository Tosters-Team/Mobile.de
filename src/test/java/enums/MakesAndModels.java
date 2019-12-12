package enums;

import org.openqa.selenium.WebElement;

import static pageObjects.InitPages.*;

public enum MakesAndModels {
    BMW("BMW", homePageQuickSearch.getMakeBmw()),
    MERCEDES("Mercedes-Benz", homePageQuickSearch.getMakeMercedes()),
    AUDI("Audi", homePageQuickSearch.getMakeAudi()),

    MODEL_A6("A6", homePageQuickSearch.getModelA6Audi()),
    MODEL_FIVESERIES("5", homePageQuickSearch.getModelFiveSeriesBmw()),
    MODEL_ECLASS("E", homePageQuickSearch.getModelEClassMercedes());

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


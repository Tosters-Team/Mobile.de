package enums;

import org.openqa.selenium.WebElement;
import stepDefinitions.StepsArtur;

public enum MakesAndModels {
    BMW("BMW", StepsArtur.homePageQuickSearch.getMakeBmw()),
    MERCEDES("Mercedes-Benz", StepsArtur.homePageQuickSearch.getMakeMercedes()),
    AUDI("Audi", StepsArtur.homePageQuickSearch.getMakeAudi()),

    MODEL_A6("A6", StepsArtur.homePageQuickSearch.getModelA6Audi()),
    MODEL_FIVESERIES("5", StepsArtur.homePageQuickSearch.getModelFiveSeriesBmw()),
    MODEL_ECLASS("E", StepsArtur.homePageQuickSearch.getModelEClassMercedes());

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


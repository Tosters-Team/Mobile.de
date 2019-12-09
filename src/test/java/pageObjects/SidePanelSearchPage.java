package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelSearchPage {

    @FindBy(xpath = "//*[@id=\"sio-opener-condition\"]/div[2]/div[2]/span")
    private WebElement vehicleConditionChange;

    @FindBy(xpath = "//*[@id=\"usage-USED-ds\"]")
    private WebElement vehicleConditionUsed;

    @FindBy(xpath = "//*[@id=\"sio-condition-search-btn\"]")
    private WebElement showOffersOnConditionButton;

    @FindBy(xpath = "//*[@id=\"sio-opener-make-model-variant\"]/div[2]/div[2]/span")
    private WebElement makeModelChange;

    @FindBy(xpath = "//*[@id=\"selectMake1-ds\"]")
    private WebElement make;

    @FindBy(xpath = "//*[@id=\"selectModel1-ds\"]")
    private WebElement model;

    @FindBy(xpath = "//*[@id=\"sio-makeModelVariant-search-btn\"]")
    private WebElement showOffersOnMakeModelButton;

    @FindBy(xpath = "//*[@id=\"minPrice\"]")
    private WebElement priceFrom;

    @FindBy(xpath = "//*[@id=\"maxPrice\"]")
    private WebElement priceTo;

    @FindBy(xpath = "//*[@id=\"minFirstRegistrationDate\"]")
    private WebElement firstRegistrationFrom;

    @FindBy(xpath = "//*[@id=\"maxFirstRegistrationDate\"]")
    private WebElement firstRegistrationTo;

    @FindBy(xpath = "//*[@id=\"minMileage\"]")
    private WebElement kilometerFrom;

    @FindBy(xpath = "//*[@id=\"maxMileage\"]")
    private WebElement kilometerTo;

    @FindBy(xpath = "//*[@id=\"minisearch-search-btn\"]")
    private WebElement showOffersGeneralButton;

    public WebElement getVehicleConditionChange() {
        return vehicleConditionChange;
    }

    public WebElement getVehicleConditionUsed() {
        return vehicleConditionUsed;
    }

    public WebElement getShowOffersOnConditionButton() {
        return showOffersOnConditionButton;
    }

    public WebElement getMakeModelChange() {
        return makeModelChange;
    }

    public WebElement getMake() {
        return make;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getShowOffersOnMakeModelButton() {
        return showOffersOnMakeModelButton;
    }

    public WebElement getPriceFrom() {
        return priceFrom;
    }

    public WebElement getPriceTo() {
        return priceTo;
    }

    public WebElement getFirstRegistrationFrom() {
        return firstRegistrationFrom;
    }

    public WebElement getFirstRegistrationTo() {
        return firstRegistrationTo;
    }

    public WebElement getKilometerFrom() {
        return kilometerFrom;
    }

    public WebElement getKilometerTo() {
        return kilometerTo;
    }

    public WebElement getShowOffersGeneralButton() {
        return showOffersGeneralButton;
    }
}

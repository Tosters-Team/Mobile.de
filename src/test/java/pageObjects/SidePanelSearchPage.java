package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@PageName(name = "Side Panel Search Page")
public class SidePanelSearchPage extends Page {

    public SidePanelSearchPage() {
        super();
    }

    @FindBy(xpath = "[id^='sio-'][id$='-search-btn']")
    private WebElement showOffersOnPopup;


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

    @WebElementName(name = "Price_from")
    @FindBy(xpath = "//*[@id=\"minPrice\"]")
    private WebElement priceFrom;

    @WebElementName(name = "Price_to")
    @FindBy(xpath = "//*[@id=\"maxPrice\"]")
    private WebElement priceTo;

    @WebElementName(name = "Registration_from")
    @FindBy(xpath = "//*[@id=\"minFirstRegistrationDate\"]")
    private WebElement firstRegistrationFrom;

    @WebElementName(name = "Registration_to")
    @FindBy(xpath = "//*[@id=\"maxFirstRegistrationDate\"]")
    private WebElement firstRegistrationTo;

    @WebElementName(name = "Kilometer_from")
    @FindBy(xpath = "//*[@id=\"minMileage\"]")
    private WebElement kilometerFrom;

    @WebElementName(name = "Kilometer_to")
    @FindBy(xpath = "//*[@id=\"maxMileage\"]")
    private WebElement kilometerTo;

    @WebElementName(name = "Show offers")
    @FindBy(xpath = "//*[@id=\"minisearch-search-btn\"]")
    private WebElement showOffersGeneralButton;

    @WebElementName(name = "Displayed option")
    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[2]/div")
    private WebElement displayedOption;

    @WebElementName(name = "Close displayed option")
    @FindBy(xpath = "/html/body/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[2]/div/a/i")
    private WebElement closeDisplayedOption;

    public WebElement getOptionType(String optionType) {
        switch (optionType){
            case "Price_from"        : return priceFrom;
            case "Price_to"          : return priceTo;
            case "Registration_from" : return firstRegistrationFrom;
            case "Registration_to"   : return firstRegistrationTo;
            case "Kilometer_from"    : return kilometerFrom;
            case "Kilometer_to"      : return kilometerTo;
            default: return  null;
        }
    }


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

    public WebElement getDisplayedOption() {
        return displayedOption;
    }

    public WebElement getCloseDisplayedOption() {
        return closeDisplayedOption;
    }
}

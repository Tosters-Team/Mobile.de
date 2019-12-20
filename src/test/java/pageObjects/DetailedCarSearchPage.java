package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

@PageName(name = "Detailed Car Search Page")
public class DetailedCarSearchPage extends Page {

    public DetailedCarSearchPage() {
        super();
    }


    @FindBy(xpath = "//*[@id=\"form-dsp\"]/div[1]/div/article/section/div/div[1]/h1")
    private WebElement pageHeader;

    @WebElementName(name = "NEW")
    @FindBy(xpath = "//*[@id=\"usage-NEW-ds\"]")
    private WebElement conditionNew;

    @WebElementName(name = "USED")
    @FindBy(xpath = "//*[@id=\"usage-USED-ds\"]")
    private WebElement conditionUsed;

    @WebElementName(name = "Make field")
    @FindBy(xpath = "//*[@id=\"selectMake1-ds\"]")
    private WebElement make;

    @WebElementName(name = "Model field")
    @FindBy(xpath = "//*[@id=\"selectModel1-ds\"]")
    private WebElement model;

    @FindBy(xpath = "//*[@id=\"categories-Cabrio-ds\"]")
    private WebElement vehicleTypeCabriolet;

    @WebElementName(name = "ESTATE")
    @FindBy(xpath = "//*[@id=\"categories-EstateCar-ds\"]")
    private WebElement vehicleTypeEstate;

    @WebElementName(name = "SALOON")
    @FindBy(xpath = "//*[@id=\"categories-Limousine-ds\"]")
    private WebElement vehicleTypeSaloon;

    @FindBy(xpath = "//*[@id=\"categories-SmallCar-ds\"]")
    private WebElement vehicleTypeSmallCar;

    @FindBy(xpath = "//*[@id=\"categories-SportsCar-ds\"]")
    private WebElement vehicleTypeCoupe;

    @FindBy(xpath = "//*[@id=\"categories-OffRoad-ds\"]")
    private WebElement vehicleTypeSuv;

    @FindBy(xpath = "//*[@id=\"categories-Van-ds\"]")
    private WebElement veicleTypeVan;

    @WebElementName(name = "Min price field")
    @FindBy(xpath = "//*[@id=\"minPrice\"]")
    private WebElement priceFrom;

    @WebElementName(name = "Max price field")
    @FindBy(xpath = "//*[@id=\"maxPrice\"]")
    private WebElement priceTo;

    @WebElementName(name = "Min year field")
    @FindBy(xpath = "//*[@id=\"minFirstRegistrationDate\"]")
    private WebElement firstRegistrationFrom;

    @WebElementName(name = "Max year field")
    @FindBy(xpath = "//*[@id=\"maxFirstRegistrationDate\"]")
    private WebElement firstRegistrationTo;

    @WebElementName(name = "Min mileage field")
    @FindBy(xpath = "//*[@id=\"minMileage\"]")
    private WebElement kilometerFrom;

    @WebElementName(name = "Max mileage field")
    @FindBy(xpath = "//*[@id=\"maxMileage\"]")
    private WebElement kilometerTo;

    @FindBy(xpath = "//*[@id=\"minPowerAsArray\"]")
    private WebElement powerFrom;

    @FindBy(xpath = "//*[@id=\"maxPowerAsArray\"]")
    private WebElement powerTo;

    @WebElementName(name = "PETROL")
    @FindBy(xpath = "//*[@id=\"fuels-PETROL-ds\"]")
    private WebElement fuelTypePetrol;

    @WebElementName(name = "DIESEL")
    @FindBy(xpath = "//*[@id=\"fuels-DIESEL-ds\"]")
    private WebElement fuelTypeDiesel;

    @WebElementName(name = "MANUAL")
    @FindBy(xpath = "//*[@id=\"transmissions-MANUAL_GEAR-ds\"]")
    private WebElement transmissionTypeManual;

    @WebElementName(name = "AUTOMATIC")
    @FindBy(xpath = "//*[@id=\"transmissions-SEMIAUTOMATIC_GEAR-ds\"]")
    private WebElement transmissionTypeSemiAuto;

    @FindBy(xpath = "//*[@id=\"transmissions-AUTOMATIC_GEAR-ds\"]")
    private WebElement transmissionTypeAuto;

    @FindBy(xpath = "//*[@id=\"minCubicCapacity\"]")
    private WebElement cubicCapacityFrom;

    @FindBy(xpath = "//*[@id=\"maxCubicCapacity\"]")
    private WebElement cubicCapacityTo;

    @WebElementName(name = "Show offers button")
    @FindBy(xpath = "//*[@id=\"dsp-upper-search-btn\"]")
    private WebElement showOffersButton;

    public WebElement getCondition(String condition) {
        if (condition.equals("NEW")) return conditionNew;
        if (condition.equals("USED")) return conditionUsed;
        else return null;
    }


    public WebElement getMake() {
        return make;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getVehicleType(String type) {
        switch (type) {
            case "CABRIOLET":
                return vehicleTypeCabriolet;
            case "ESTATE":
                return vehicleTypeEstate;
            case "SALOON":
                return vehicleTypeSaloon;
            case "SMALLCAR":
                return vehicleTypeSmallCar;
            case "COUPE":
                return vehicleTypeCoupe;
            case "SUV":
                return vehicleTypeSuv;
            case "VAN":
                return veicleTypeVan;
            default:
                return null;
        }
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

    public WebElement getPowerFrom() {
        return powerFrom;
    }

    public WebElement getPowerTo() {
        return powerTo;
    }

    public WebElement getFuelType(String fuelType) {
        if (fuelType.equals("PETROL")) return fuelTypePetrol;
        if (fuelType.equals("DIESEL")) return fuelTypeDiesel;
        else return null;
    }

    public WebElement getTranmissionType(String transmission) {
        switch (transmission) {
            case "MANUAL":
                return transmissionTypeManual;
            case "SEMIAUTO":
                return transmissionTypeSemiAuto;
            case "AUTOMATIC":
                return transmissionTypeAuto;
            default:
                return null;
        }
    }

    public WebElement getCubicCapacityFrom() {
        return cubicCapacityFrom;
    }

    public WebElement getCubicCapacityTo() {
        return cubicCapacityTo;
    }

    public WebElement getShowOffersButton() {
        return showOffersButton;
    }

    public WebElement getPageHeader() {
        return pageHeader;
    }
}

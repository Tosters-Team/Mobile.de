package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailedCarSearchPage {

    public DetailedCarSearchPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"usage-NEW-ds\"]")
    private WebElement conditionNew;

    @FindBy(xpath = "//*[@id=\"usage-USED-ds\"]")
    private WebElement conditionUsed;

    @FindBy(xpath = "//*[@id=\"selectMake1-ds\"]")
    private WebElement make;

    @FindBy(xpath = "//*[@id=\"selectModel1-ds\"]")
    private WebElement model;

    @FindBy(xpath = "//*[@id=\"categories-Cabrio-ds\"]")
    private WebElement vehicleTypeCabriolet;

    @FindBy(xpath = "//*[@id=\"categories-EstateCar-ds\"]")
    private WebElement vehicleTypeEstate;

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

    @FindBy(xpath = "//*[@id=\"minPowerAsArray\"]")
    private WebElement powerFrom;

    @FindBy(xpath = "//*[@id=\"maxPowerAsArray\"]")
    private WebElement powerTo;

    @FindBy(xpath = "//*[@id=\"fuels-PETROL-ds\"]")
    private WebElement fuelTypePetrol;

    @FindBy(xpath = "//*[@id=\"fuels-DIESEL-ds\"]")
    private WebElement fuelTypeDiesel;

    @FindBy(xpath = "//*[@id=\"transmissions-MANUAL_GEAR-ds\"]")
    private WebElement transmissionTypeManual;

    @FindBy(xpath = "//*[@id=\"transmissions-SEMIAUTOMATIC_GEAR-ds\"]")
    private WebElement transmissionTypeSemiAuto;

    @FindBy(xpath = "//*[@id=\"transmissions-AUTOMATIC_GEAR-ds\"]")
    private WebElement transmissionTypeAuto;

    @FindBy(xpath = "//*[@id=\"minCubicCapacity\"]")
    private WebElement cubicCapacityFrom;

    @FindBy(xpath = "//*[@id=\"maxCubicCapacity\"]")
    private WebElement cubicCapacityTo;

    @FindBy(xpath = "//*[@id=\"dsp-upper-search-btn\"]")
    private WebElement showOffersButton;

    public WebElement getConditionNew() {
        return conditionNew;
    }

    public WebElement getConditionUsed() {
        return conditionUsed;
    }

    public WebElement getMake() {
        return make;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getVehicleTypeCabriolet() {
        return vehicleTypeCabriolet;
    }

    public WebElement getVehicleTypeEstate() {
        return vehicleTypeEstate;
    }

    public WebElement getVehicleTypeSaloon() {
        return vehicleTypeSaloon;
    }

    public WebElement getVehicleTypeSmallCar() {
        return vehicleTypeSmallCar;
    }

    public WebElement getVehicleTypeCoupe() {
        return vehicleTypeCoupe;
    }

    public WebElement getVehicleTypeSuv() {
        return vehicleTypeSuv;
    }

    public WebElement getVeicleTypeVan() {
        return veicleTypeVan;
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

    public WebElement getFuelTypePetrol() {
        return fuelTypePetrol;
    }

    public WebElement getFuelTypeDiesel() {
        return fuelTypeDiesel;
    }

    public WebElement getTransmissionTypeManual() {
        return transmissionTypeManual;
    }

    public WebElement getTransmissionTypeSemiAuto() {
        return transmissionTypeSemiAuto;
    }

    public WebElement getTransmissionTypeAuto() {
        return transmissionTypeAuto;
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
}

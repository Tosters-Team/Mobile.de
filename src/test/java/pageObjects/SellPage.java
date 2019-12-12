package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellPage extends InitPages{

    public SellPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"select-make\"]")
    private WebElement brand;

    @FindBy(xpath = "//*[@id=\"select-model\"]")
    private WebElement model;

    @FindBy(xpath = "//*[@id=\"select-year\"]")
    private WebElement firstRegistrationYear;

    @FindBy(xpath = "//*[@id=\"select-month\"]")
    private WebElement getFirstRegistrationMonth;

    @FindBy(xpath = "//*[@id=\"enter-mileage\"]")
    private WebElement mileage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[2]/div[5]/div/div/div/div[1]/label")
    private WebElement fuelTypeDiesel;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[2]/div[5]/div/div/div/div[2]/label")
    private WebElement getFuelTypePetrol;

    @FindBy(xpath = "//*[@id=\"select-modelname\"]")
    private WebElement modelDescription;

    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[1]/div[1]/div/label/svg/path[1]")
    private WebElement equipmentLevelOption1;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[3]/div[3]/div[4]/div/div/div/div[3]/label")
    private WebElement whenToSellOption3;

    @FindBy(xpath = "//*[@id=\"enter-zipcode\"]")
    private WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/div[3]/section/div/div/div[2]/div/div/div/button/span")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/section[1]/div/h1")
    private WebElement sellYourVehicleText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/section[2]/div/div[1]/span")
    private WebElement price;

    public WebElement getBrand() {
        return brand;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getFirstRegistrationYear() {
        return firstRegistrationYear;
    }

    public WebElement getGetFirstRegistrationMonth() {
        return getFirstRegistrationMonth;
    }

    public WebElement getMileage() {
        return mileage;
    }

    public WebElement getFuelTypeDiesel() {
        return fuelTypeDiesel;
    }

    public WebElement getGetFuelTypePetrol() {
        return getFuelTypePetrol;
    }

    public WebElement getModelDescription() {
        return modelDescription;
    }

    public WebElement getEquipmentLevelOption1() {
        return equipmentLevelOption1;
    }

    public WebElement getWhenToSellOption3() {
        return whenToSellOption3;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getSellYourVehicleText() {
        return sellYourVehicleText;
    }

    public WebElement getPrice() {
        return price;
    }
}

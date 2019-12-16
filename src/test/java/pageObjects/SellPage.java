package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellPage extends InitPages{

    public SellPage() {
        super();
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
    private WebElement modelDescriptionDropDown;

    @FindBy(xpath = "//*[@id=\"select-modelname\"]/option[1]")
    private WebElement modelDescription1;

    @FindBy(xpath = "//*[@id=\"select-modelname\"]/option[2]")
    private WebElement modelDescription2;

    @FindBy(xpath = "//*[@id=\"select-modelname\"]/option[3]")
    private WebElement modelDescription3;

    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[1]/div[2]")
    private WebElement equipmentLevelOption1;

    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[2]/div[2]")
    private WebElement equipmentLevelOption2;

    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[3]/div[2]")
    private WebElement equipmentLevelOption3;

    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[4]/div[2]")
    private WebElement equipmentLevelOption4;

    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[5]/div[2]")
    private WebElement equipmentLevelOption5;

    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[6]/div[2]")
    private WebElement equipmentLevelOption6;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[3]/div[3]/div[4]/div/div/div/div[1]/label")
    private WebElement whenToSellOption1;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[3]/div[3]/div[4]/div/div/div/div[2]/label")
    private WebElement whenToSellOption2;

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

    public WebElement getFuelType(String fuelType) {
        if(fuelType.equals("PETROL")) return getFuelTypePetrol;
        if(fuelType.equals("DIESEL")) return fuelTypeDiesel;
        else return null;
    }

    public WebElement getModelDescriptionDropDown() {
        return modelDescriptionDropDown;
    }

    public WebElement getModelDescriptionOption(String option) {
        switch (option) {
            case "1": return modelDescription1;
            case "2": return modelDescription2;
            case "3": return modelDescription3;
            default: return null;
        }
    }

    public WebElement getEquipmentLevelOption(String trim) {
        switch (trim) {
            case "1": return equipmentLevelOption1;
            case "2": return equipmentLevelOption2;
            case "3": return equipmentLevelOption3;
            case "4": return equipmentLevelOption4;
            case "5": return equipmentLevelOption5;
            case "6": return equipmentLevelOption6;
            default: return null;
        }
    }

    public WebElement getWhenToSellOption(String sellOption) {
        switch (sellOption) {
            case "1": return whenToSellOption1;
            case "2": return whenToSellOption2;
            case "3": return whenToSellOption3;
            default: return null;
        }
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

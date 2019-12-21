package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

@PageName(name = "Sell Page")
public class SellPage extends Page {

    public SellPage() {
        super();
    }

    @WebElementName(name = "Make field")
    @FindBy(xpath = "//*[@id=\"select-make\"]")
    private WebElement brand;

    @WebElementName(name = "Model field")
    @FindBy(xpath = "//*[@id=\"select-model\"]")
    private WebElement model;

    @WebElementName(name = "Year")
    @FindBy(xpath = "//*[@id=\"select-year\"]")
    private WebElement firstRegistrationYear;

    @WebElementName(name = "Month")
    @FindBy(xpath = "//*[@id=\"select-month\"]")
    private WebElement getFirstRegistrationMonth;

    @WebElementName(name = "Mileage")
    @FindBy(xpath = "//*[@id=\"enter-mileage\"]")
    private WebElement mileage;

    @WebElementName(name = "DIESEL")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[2]/div[5]/div/div/div/div[1]/label")
    private WebElement fuelTypeDiesel;

    @WebElementName(name = "PETROL")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[2]/div[5]/div/div/div/div[2]/label")
    private WebElement getFuelTypePetrol;

    @WebElementName(name = "description")
    @FindBy(xpath = "//*[@id=\"select-modelname\"]")
    private WebElement modelDescriptionDropDown;

    @WebElementName(name = "Model 1")
    @FindBy(xpath = "//*[@id=\"select-modelname\"]/option[1]")
    private WebElement modelDescription1;

    @WebElementName(name = "Model 2")
    @FindBy(xpath = "//*[@id=\"select-modelname\"]/option[2]")
    private WebElement modelDescription2;

    @WebElementName(name = "Model 3")
    @FindBy(xpath = "//*[@id=\"select-modelname\"]/option[3]")
    private WebElement modelDescription3;

    @WebElementName(name = "Equipment 1")
    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[1]/div[2]")
    private WebElement equipmentLevelOption1;

    @WebElementName(name = "Equipment 2")
    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[2]/div[2]")
    private WebElement equipmentLevelOption2;

    @WebElementName(name = "Equipment 3")
    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[3]/div[2]")
    private WebElement equipmentLevelOption3;

    @WebElementName(name = "Equipment 4")
    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[4]/div[2]")
    private WebElement equipmentLevelOption4;

    @WebElementName(name = "Equipment 5")
    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[5]/div[2]")
    private WebElement equipmentLevelOption5;

    @WebElementName(name = "Equipment 6")
    @FindBy(xpath = "//*[@id=\"select-modelvariant-div\"]/div[2]/div/div[6]/div[2]")
    private WebElement equipmentLevelOption6;

    @WebElementName(name = "Sell option 1")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[3]/div[3]/div[4]/div/div/div/div[1]/label")
    private WebElement whenToSellOption1;

    @WebElementName(name = "Sell option 2")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[3]/div[3]/div[4]/div/div/div/div[2]/label")
    private WebElement whenToSellOption2;

    @WebElementName(name = "Sell option 3")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/section[2]/div/div/div/div/form/div[3]/div[3]/div[4]/div/div/div/div[3]/label")
    private WebElement whenToSellOption3;

    @WebElementName(name = "Zip code field")
    @FindBy(xpath = "//*[@id=\"enter-zipcode\"]")
    private WebElement zipCode;

    @WebElementName(name = "Continue button")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/div/div[3]/section/div/div/div[2]/div/div/div/button/span")
    private WebElement continueButton;

    @WebElementName(name = "Sell your vehicle text")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/section[1]/div/h1")
    private WebElement sellYourVehicleText;

    @WebElementName(name = "Your car price")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/article/section[2]/div/div[1]/span")
    private WebElement price;
}

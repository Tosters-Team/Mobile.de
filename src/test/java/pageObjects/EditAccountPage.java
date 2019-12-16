package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends InitPages {

    public EditAccountPage() {
        super();
    }


    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/form/div/div[*]/div[2]/button/span")
    private WebElement saveChanging;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"street\"]")
    private WebElement streetField;

    @FindBy(xpath = "//*[@id=\"houseNumber\"]")
    private WebElement houseNumber;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[*]/div/div[3]/span")
    private WebElement changedMessage;

    @FindBy(xpath = "//*[@id=\"zipCode\"]")
    private WebElement zipCodeField;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id=\"app\"]//div[2]/div[1]/div/div[2]/a/span")
    private WebElement changeName;

    @FindBy(xpath = "//*[@id=\"app\"]//div[2]/div[2]/div/div[2]/a/span")
    private WebElement changeAddress;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]")
    private WebElement editedSection;

    public WebElement getEditedSection() {
        return editedSection;
    }

    public WebElement getChangeName() {
        return changeName;
    }

    public WebElement getChangeAddress() {
        return changeAddress;
    }

    public WebElement getStreetField() {
        return streetField;
    }

    public WebElement getHouseNumber() {
        return houseNumber;
    }

    public WebElement getChangedMessage() {
        return changedMessage;
    }

    public WebElement getSaveChanging() {
        return saveChanging;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

}

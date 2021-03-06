package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

@PageName(name = "Edit Account Page")
public class EditAccountPage extends Page {

    public EditAccountPage() {
        super();
    }

    @WebElementName(name = "Save button")
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/form/div/div[*]/div[2]/button/span")
    private WebElement saveChanging;

    @WebElementName(name = "First Name field")
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;

    @WebElementName(name = "Last Name field")
    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement lastNameField;

    @WebElementName(name = "Street field")
    @FindBy(xpath = "//*[@id=\"street\"]")
    private WebElement streetField;


    @WebElementName(name = "House Number field")
    @FindBy(xpath = "//*[@id=\"houseNumber\"]")
    private WebElement houseNumber;

    @WebElementName(name = "Changed")
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div[*]/div/div[3]/span")
    private WebElement changedMessage;

    @WebElementName(name = "ZipCode field")
    @FindBy(xpath = "//*[@id=\"zipCode\"]")
    private WebElement zipCodeField;

    @WebElementName(name = "City field")
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityField;

    @WebElementName(name = "Change name button")
    @FindBy(xpath = "//*[@id=\"app\"]//div[2]/div[1]/div/div[2]/a/span")
    private WebElement changeName;

    @WebElementName(name = "Change address button")
    @FindBy(xpath = "//*[@id=\"app\"]//div[2]/div[2]/div/div[2]/a/span")
    private WebElement changeAddress;
}

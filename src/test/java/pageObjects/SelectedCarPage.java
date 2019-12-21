package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

@PageName(name = "Selected Car Page")
public class SelectedCarPage extends Page {
    public SelectedCarPage() {
        super();
    }

    @WebElementName(name = "Brand model")
    @FindBy(xpath = "//*[@id=\"rbt-ad-title\"]")
    private WebElement brandModel;

    @WebElementName(name = "Car body type")
    @FindBy(xpath = "//*[@id=\"rbt-category-v\"]")
    private WebElement carType;

    @WebElementName(name = "Price")
    @FindBy(xpath = "//*[@id=\"rbt-pt-v\"]/span[1]")
    private WebElement price;

    @WebElementName(name = "Mileage")
    @FindBy(xpath = "//*[@id=\"rbt-mileage-v\"]")
    private WebElement mileage;

    @WebElementName(name = "Registration date")
    @FindBy(xpath = "//*[@id=\"rbt-firstRegistration-v\"]")
    private WebElement firstRegistration;

    @WebElementName(name = "Fuel type")
    @FindBy(xpath = "//*[@id=\"rbt-fuel-v\"]")
    private WebElement fuel;

    @WebElementName(name = "Transmission type")
    @FindBy(xpath = "//*[@id=\"rbt-transmission-v\"]")
    private WebElement transmission;
}

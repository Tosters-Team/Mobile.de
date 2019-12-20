package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@PageName(name = "Selected Car Page")
public class SelectedCarPage extends Page {
    public SelectedCarPage() {
        super();
    }

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

    public int getActualPrice() {
        int priceInt = Integer.parseInt(price.getText().substring(1).replaceAll(",", ""));
        return priceInt;
    }

    public int getActualMileage() {
        int mileageInt = Integer.parseInt(mileage.getText().replaceAll("[^\\d.]", "").replace(".", ""));
        System.out.println(mileage.getText());
        System.out.println(mileageInt);
        return mileageInt;
    }

    public int getActualDate() {
        int dateInt;
        String dateString = firstRegistration.getText();
        String[] separatedDate = dateString.split("/");
        StringBuilder unifiedDate = new StringBuilder();
        unifiedDate.append(separatedDate[1]);
        unifiedDate.append(separatedDate[0]);
        dateInt = Integer.parseInt(unifiedDate.toString());
        System.out.println(dateInt);
        return dateInt;
    }

    public int getActualYear() {
        int yearInt;
        String dateString = firstRegistration.getText();
        String[] separatedDate = dateString.split("/");
        StringBuilder unifiedDate = new StringBuilder();
        unifiedDate.append(separatedDate[1]);
        yearInt = Integer.parseInt(unifiedDate.toString());
        System.out.println(yearInt);
        return yearInt;

    }

    public WebElement getBrandModel() {
        return brandModel;
    }

    public WebElement getTransmission() {
        return transmission;
    }

    public WebElement getFuel() {
        return fuel;
    }


}

package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

@PageName(name = "Side Panel Search Page")
public class SidePanelSearchPage extends Page {

    public SidePanelSearchPage() {
        super();
    }

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
}

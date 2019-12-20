package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@PageName(name = "Home Page")
public class HomePageQuickSearch extends Page {

    public HomePageQuickSearch() {
        super();
    }

    @WebElementName(name = "Sell tab")
    @FindBy(xpath = "//*[@id=\"quicksearch__SellTab\"]")
    private WebElement sellTab;

    @WebElementName(name = "Search button")
    @FindBy(xpath = "//*[@id=\"qssub\"]")
    private WebElement searchButton;

    @WebElementName(name = "Detailed search link")
    @FindBy(xpath = "//*[@id=\"qsdet\"]")
    private WebElement detailedSearch;

    @WebElementName(name = "Truck Tab")
    @FindBy(xpath = "//*[@id=\"qs-categories__TrucksTab\"]/i")
    private WebElement truckTab;

    @WebElementName(name = "BMW")
    @FindBy(xpath = "//*[@id=\"qsmakeBuy\"]/option[20]")
    private WebElement makeBmw;

    @WebElementName(name = "Mercedes-Benz")
    @FindBy(xpath = "//*[@id=\"qsmakeBuy\"]/option[77]")
    private WebElement makeMercedes;

    @WebElementName(name = "Volkswagen")
    @FindBy(xpath = "//*[@id=\"qsmakeBuy\"]/option[3]")
    private WebElement makeVolkswagen;

    @WebElementName(name = "5")
    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[65]")
    private WebElement modelFiveSeriesBmw;

    @WebElementName(name = "Golf")
    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[16]")
    private WebElement modelGolf;

    @WebElementName(name = "E")
    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[142]")
    private WebElement modelEClassMercedes;

    @WebElementName(name = "Price field")
    @FindBy(xpath = "//*[@id=\"qsprc\"]")
    private WebElement priceUpTo;



    public WebElement getSellTab() {
        return sellTab;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getDetailedSearch() {
        return detailedSearch;
    }

    public WebElement getTruckTab() {
        return truckTab;
    }

    public WebElement getMakeBmw() {
        return makeBmw;
    }

    public WebElement getMakeMercedes() {
        return makeMercedes;
    }

    public WebElement getMakeVolkswagen() {
        return makeVolkswagen;
    }

    public WebElement getModelFiveSeriesBmw() {
        return modelFiveSeriesBmw;
    }

    public WebElement getModelGolf() {
        return modelGolf;
    }

    public WebElement getModelEClassMercedes() {
        return modelEClassMercedes;
    }

    public WebElement getPriceUpTo() {
        return priceUpTo;
    }
}

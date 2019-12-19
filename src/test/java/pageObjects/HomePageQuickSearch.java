package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@PageName(name = "Home Page Quick Search")
public class HomePageQuickSearch extends Page {

    public HomePageQuickSearch() {
        super();
    }

    @Override
    public WebElement getWebElementByName(String pageName) {
        super.getWebElementByName(pageName);
        switch (pageName) {
            case "BMW":
                return getMakeBmw();
            case "Mercedes-Benz":
                return getMakeMercedes();
            case "Volkswagen":
                return getMakeVolkswagen();
            case "Golf":
                return getModelGolf();
            case "5":
                return getModelFiveSeriesBmw();
            case "E":
                return getModelEClassMercedes();
            default:
                return null;
        }
    }


    @FindBy(xpath = "//*[@id=\"quicksearch__SellTab\"]")
    private WebElement sellTab;

    @WebElementName(name = "Search Button")
    @FindBy(xpath = "//*[@id=\"qssub\"]")
    private WebElement searchButton;

    @WebElementName(name = "Detailed Search link")
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

    @WebElementName(name = "5 Series")
    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[65]")
    private WebElement modelFiveSeriesBmw;

    @WebElementName(name = "Golf")
    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[16]")
    private WebElement modelGolf;

    @WebElementName(name = "E Class")
    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[142]")
    private WebElement modelEClassMercedes;

    @FindBy(xpath = "//*[@id=\"qsprc\"]")
    private WebElement priceUpTo;

    @WebElementName(name = "test")
    @FindBy(xpath = "//*[@id=\"quicksearch__SellTab\"]")
    private WebElement test;

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

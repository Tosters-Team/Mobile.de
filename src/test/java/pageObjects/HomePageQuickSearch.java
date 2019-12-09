package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageQuickSearch {
    @FindBy(xpath = "//*[@id=\"quicksearch__SellTab\"]")
    private WebElement sellTab;

    @FindBy(xpath = "//*[@id=\"qssub\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"qsdet\"]")
    private WebElement detailedSearch;

    @FindBy(xpath = "//*[@id=\"qs-categories__TrucksTab\"]/i")
    private WebElement truckTab;

    @FindBy(xpath = "//*[@id=\"qsmakeBuy\"]/option[20]")
    private WebElement makeBmw;

    @FindBy(xpath = "//*[@id=\"qsmakeBuy\"]/option[77]")
    private WebElement makeMercedes;

    @FindBy(xpath = "//*[@id=\"qsmakeBuy\"]/option[16]")
    private WebElement makeAudi;

    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[65]")
    private WebElement modelFiveSeriesBmw;

    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[13]")
    private WebElement modelA6Audi;

    @FindBy(xpath = "//*[@id=\"qsmodelBuy\"]/option[142]")
    private WebElement modelEClassMercedes;

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

    public WebElement getMakeAudi() {
        return makeAudi;
    }

    public WebElement getModelFiveSeriesBmw() {
        return modelFiveSeriesBmw;
    }

    public WebElement getModelA6Audi() {
        return modelA6Audi;
    }

    public WebElement getModelEClassMercedes() {
        return modelEClassMercedes;
    }

    public WebElement getPriceUpTo() {
        return priceUpTo;
    }
}

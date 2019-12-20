package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@PageName(name = "My Searches Page")
public class MySearchesPage extends Page {

    public MySearchesPage() {
        super();
    }

    @WebElementName(name = "Delete stored search")
    @FindBy(xpath = "//*[@id=\"mySavedSearch\"]/div[2]/div/div[1]/div/div[2]/p[2]")
    private WebElement deleteSearch;

    @WebElementName(name = "Stored search")
    @FindBy(xpath = "//*[@id=\"mySavedSearch\"]/div[2]/div/div[1]/div/div[1]/a/h4")
    private WebElement storedSearch;

    @WebElementName(name = "Empty search")
    @FindBy(xpath = "//*[@id=\"mySavedSearch\"]/div[2]/div/div/b")
    private WebElement emptySearch;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/a/i")
    private WebElement mobileDeLogo;

    @FindBy(xpath = "//*[@id=\"mySavedSearch\"]/div[2]/div/div[1]/div/div[1]/a")
    private WebElement showSavedSearch;

    public WebElement getDeleteSearch() {
        return deleteSearch;
    }

    public WebElement getEmptySearch() {
        return emptySearch;
    }

    public WebElement getShowSavedSearch() {
        return showSavedSearch;
    }
}

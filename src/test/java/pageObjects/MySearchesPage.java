package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@PageName(name = "My Searches Page")
public class MySearchesPage extends InitPages{

    public MySearchesPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"mySavedSearch\"]/div[2]/div/div[1]/div/div[2]/p[2]")
    private WebElement deleteSearch;

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

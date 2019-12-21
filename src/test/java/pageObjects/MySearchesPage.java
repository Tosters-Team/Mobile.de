package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

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
}

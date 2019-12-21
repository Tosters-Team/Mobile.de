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
    @FindBy(xpath = "//p[@class='search-delete']")
    private WebElement deleteSearch;

    @WebElementName(name = "Stored search")
    @FindBy(xpath = "//a[@class='link link--hidden u-text-decoration-none u-block search-execute']")
    private WebElement storedSearch;

    @WebElementName(name = "Empty search")
    @FindBy(xpath = "//b[contains(text(),'You have not saved any search requests.')]")
    private WebElement emptySearch;
}

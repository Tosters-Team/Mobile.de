package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;

@PageName(name = "Comparison Page")
public class ComparisonPage extends Page {


    public ComparisonPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/h1")
    private WebElement comparisonPageHeader;

    public WebElement getComparisonPageHeader() {
        return comparisonPageHeader;
    }
}

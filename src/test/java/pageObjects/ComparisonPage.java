package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparisonPage extends InitPages{


    public ComparisonPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/h1")
    private WebElement comparisonPageHeader;

    public WebElement getComparisonPageHeader() {
        return comparisonPageHeader;
    }
}

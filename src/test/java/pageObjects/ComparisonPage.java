package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparisonPage extends InitPages{


    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/h1")
    private WebElement comparisonPageHeader;

    public WebElement getComparisonPageHeader() {
        return comparisonPageHeader;
    }
}

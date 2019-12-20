package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;
@Getter

@PageName(name = "Comparison Page")
public class ComparisonPage extends Page {


    public ComparisonPage() {
        super();
    }

    @WebElementName(name = "Comparison header")
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/h1")
    private WebElement comparisonPageHeader;

    @WebElementName(name = "Comparison table")
    @FindBy(xpath = "//html/body/div[1]/div/div[2]/div/div/div[1]/div/div[4]")
    private WebElement comparisonTable;

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ComparisonPage {

    public ComparisonPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }
}

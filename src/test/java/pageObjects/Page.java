package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import static stepDefinitions.Hooks.driver;
public abstract class Page {

    private WebElement webElement;

    public Page() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getWebElementByName(String pageName) {
        return webElement;
    }




}

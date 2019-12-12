package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class InitPages {
    private WebDriver webDriver;
    private WebElement webElement;
    public InitPages(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.webDriver = driver;

    }

    public WebElement getWebElementByName(String pageName){
        return webElement;
    }


}

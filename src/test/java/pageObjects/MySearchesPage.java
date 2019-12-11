package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MySearchesPage {

    public MySearchesPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }
}

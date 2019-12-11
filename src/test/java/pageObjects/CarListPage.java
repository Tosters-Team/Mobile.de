package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarListPage {

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[4]/a/div[2]/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkFirstCarButton;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[1]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkSecondCarButton;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[2]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkThirdCarButton;

    public WebElement getParkFirstCarButton() {
        return parkFirstCarButton;
    }

    public WebElement getParkSecondCarButton() {
        return parkSecondCarButton;
    }

    public WebElement getParkThirdCarButton() {
        return parkThirdCarButton;
    }
}

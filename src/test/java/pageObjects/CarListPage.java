package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarListPage {

    public CarListPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[4]/a/div[2]/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkFirstCarButton;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[1]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkSecondCarButton;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[2]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkThirdCarButton;

    @FindBy(xpath = "/html/body/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[1]/a/div/div[2]/div[1]/div[1]/div/span") //temporary
    private WebElement firstHeaderAnnouncement;

    @FindBy(xpath = "/html/body/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[2]/a/div/div[2]/div[1]/div[1]/div/span") //temporary
    private WebElement secondHeaderAnnouncement;

    @FindBy(xpath = "/html/body/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[3]/a/div/div[2]/div[1]/div[1]/div/span") //temporary
    private WebElement thirdHeaderAnnouncement;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[1]/a/div/div[2]/div[1]/div[2]/div[1]/span")
    private WebElement firstPriceTag;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[2]/a/div/div[2]/div[1]/div[2]/div[1]/span")
    private WebElement secondPriceTag;
    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[3]/a/div/div[2]/div[1]/div[2]/div[1]/span")
    private WebElement thirdPriceTag;


    public WebElement getFirstHeaderAnnouncement() {
        return firstHeaderAnnouncement;
    }

    public WebElement getSecondHeaderAnnouncement() {
        return secondHeaderAnnouncement;
    }

    public WebElement getThirdHeaderAnnouncement() {
        return thirdHeaderAnnouncement;
    }

    public WebElement getFirstPriceTag() {
        return firstPriceTag;
    }

    public WebElement getSecondPriceTag() {
        return secondPriceTag;
    }

    public WebElement getThirdPriceTag() {
        return thirdPriceTag;
    }


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

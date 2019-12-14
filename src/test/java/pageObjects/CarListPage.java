package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarListPage extends InitPages{

    public CarListPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[1]/div[4]/a/div[2]/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkFirstCarButton;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[1]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkSecondCarButton;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[2]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private WebElement parkThirdCarButton;



    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[1]/div[2]/div[1]/span[1]")
    private List<WebElement> listPrices;
    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[1]/div[1]/div")
    private List<WebElement> listAnnouncement;


    public List<WebElement> getListAnnouncement() {
        return listAnnouncement;
    }

    public List<WebElement> getListPrices() {
        return listPrices;
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

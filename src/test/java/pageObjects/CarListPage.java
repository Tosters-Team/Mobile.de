package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

import java.util.List;
@Getter

@PageName(name = "Car List Page")
public class CarListPage extends Page {

    public CarListPage() {
        super();
    }

    @WebElementName(name = "Park button")
    @FindBy(xpath = "/html/body/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[3]/div/div[2]/div/div[1]/span[2]")
    private List<WebElement> parkButtons;

    @WebElementName(name = "Parked status")
    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private List<WebElement> statusParked;

    @WebElementName(name = "List of prices")
    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[1]/div[2]/div[1]/span[1]")
    private List<WebElement> listPrices;

    @WebElementName(name = "List of announcements")
    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[1]/div[1]/div")
    private List<WebElement> listAnnouncement;



}

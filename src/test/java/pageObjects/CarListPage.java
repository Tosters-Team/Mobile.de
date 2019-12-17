package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@PageName(name = "Car List Page")
public class CarListPage extends InitPages {

    public CarListPage() {
        super();
    }

    @WebElementName(name = "Park button")
    @FindBy(xpath = "/html/body/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[3]/div/div[2]/div/div[1]/span[2]")
    private List<WebElement> parkButtons;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private List<WebElement> statusParked;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[1]/div[2]/div[1]/span[1]")
    private List<WebElement> listPrices;

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[1]/div[1]/div")
    private List<WebElement> listAnnouncement;

    public List<WebElement> getParkButtons() {
        return parkButtons;
    }

    public List<WebElement> getStatusParked() {
        return statusParked;
    }

    public List<WebElement> getListAnnouncement() {
        return listAnnouncement;
    }

    public List<WebElement> getListPrices() {
        return listPrices;
    }

}

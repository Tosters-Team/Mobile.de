package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarListPage extends InitPages {

    public CarListPage() {
        super();
    }


    @FindBy(xpath = "/html/body/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[3]/div/div[2]/div/div[1]/span[2]")
    private List<WebElement> parkingButtons;


    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]/a/div/div[2]/div[3]/div/div[2]/div/div[1]")
    private List<WebElement> statusParked;

    public List<WebElement> getParkingButtons() {
        return parkingButtons;
    }

    public List<WebElement> getStatusParked() {
        return statusParked;
    }

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

}

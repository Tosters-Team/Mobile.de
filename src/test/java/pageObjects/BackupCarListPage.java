package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Random;

public class BackupCarListPage extends InitPages{

    public BackupCarListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"z1234\"]/div[3]/div/div[3]/div[4]/div[2]/div[3]/div[*]")
    private List<WebElement> carResults;

    @FindBy(xpath = "//*[@id=\"rbt-ad-title\"]")
    private WebElement brandModel;

    @FindBy(xpath = "//*[@id=\"rbt-category-v\"]")
    private WebElement carType;

    @FindBy(xpath = "//*[@id=\"rbt-pt-v\"]/span")
    private WebElement price;

    @FindBy(xpath = "//*[@id=\"rbt-firstRegistration-v\"]")
    private WebElement firstRegistration;

    @FindBy(xpath = "//*[@id=\"rbt-mileage-v\"]")
    private WebElement mileage;

    @FindBy(xpath = "//*[@id=\"rbt-fuel-v\"]")
    private WebElement fuel;

    @FindBy(xpath = "//*[@id=\"rbt-transmission-v\"]")
    private WebElement transmission;




    public WebElement getRandomCar() {
        Random random = new Random();
        int randomCar = random.nextInt((carResults.size()-1) - 1) + 1;
        return carResults.get(randomCar);
    }

}

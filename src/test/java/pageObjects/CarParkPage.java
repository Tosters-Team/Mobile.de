package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarParkPage extends InitPages {


    public CarParkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/div[1]/div")
    private List<WebElement> compareCheckBoxes;

    public List<WebElement> getCompareCheckBoxes() {
        return compareCheckBoxes;
    }

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/div[2]/div/div[3]")
    private WebElement runComparisonButton;


    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li/div/div/div/button[1]/span")
    private WebElement firstNoteButton;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li/div/div/div[2]/textarea")
    private WebElement firstAddNoteField;

    public WebElement getFirstAddNoteField() {
        return firstAddNoteField;
    }

    public WebElement getFirstNoteButton() {
        return firstNoteButton;
    }

    public WebElement getRunComparisonButton() {
        return runComparisonButton;
    }


}

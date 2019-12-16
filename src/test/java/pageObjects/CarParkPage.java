package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarParkPage extends InitPages {


    public CarParkPage() {
        super();
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

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/button[2]/span")
    private List<WebElement> removeCarButtons;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/div[1]/button/span")
    private List<WebElement> undoCarButtons;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/h1/span[2]")
    private WebElement amountOfCars;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/h2/span")
    private WebElement informativeMessage;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/div[3]/button")
    private List<WebElement> deleteCarButtons;

    public List<WebElement> getDeleteCarButtons() {
        return deleteCarButtons;
    }

    public WebElement getInformativeMessage() {
        return informativeMessage;
    }

    public WebElement getAmountOfCars() {
        return amountOfCars;
    }

    public List<WebElement> getUndoCarButtons() {
        return undoCarButtons;
    }

    public List<WebElement> getRemoveCarButtons() {
        return removeCarButtons;
    }

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

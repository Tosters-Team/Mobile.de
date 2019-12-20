package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

import java.util.List;
@Getter

@PageName(name = "Car Park Page")
public class CarParkPage extends Page {

    public CarParkPage() {
        super();
    }

    @WebElementName(name = "Compare checkboxes")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/div[1]/div")
    private List<WebElement> compareCheckBoxes;

    @WebElementName(name = "Run comparison button")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/div[2]/div/div[3]")
    private WebElement runComparisonButton;

    @WebElementName(name = "Note button")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li/div/div/div/button[1]/span")
    private WebElement firstNoteButton;

    @WebElementName(name = "Note field")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li/div/div/div[2]/textarea")
    private WebElement firstAddNoteField;

    @WebElementName(name = "Remove buttons")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/button[2]/span")
    private List<WebElement> removeCarButtons;

    @WebElementName(name = "Undo buttons")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/div[1]/button/span")
    private List<WebElement> undoCarButtons;

    @WebElementName(name = "Amount of cars")
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/h1/span[2]")
    private WebElement amountOfCars;

    @WebElementName(name = "You have no vehicles in your car park yet")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/h2/span")
    private WebElement informativeMessage;

    @WebElementName(name = "X buttons")
    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[*]/div/div/div/div[3]/button")
    private List<WebElement> deleteCarButtons;

}

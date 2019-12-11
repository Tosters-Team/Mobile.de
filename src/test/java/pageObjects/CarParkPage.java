package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarParkPage {

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[1]/div/div/div/div[1]")
    private WebElement firstCompareCheckBox;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[2]/div/div/div/div[1]")
    private WebElement secondCompareCheckBox;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[1]/div/div/div/button[1]/span")
    private WebElement firstAddNoteButton;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[1]/div/div/div[2]/textarea")
    private WebElement firstAddNoteField;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/div[2]/div/div[3]")
    private WebElement runComparisonButton;

    @FindBy(xpath = "//*[@id=\"parkingsListContainer\"]/div/div/ul/li[3]/div/div/div/button[2]/span")
    private WebElement deleteThirdCarButton;

    public WebElement getFirstCompareCheckBox() {
        return firstCompareCheckBox;
    }

    public WebElement getSecondCompareCheckBox() {
        return secondCompareCheckBox;
    }

    public WebElement getFirstAddNoteButton() {
        return firstAddNoteButton;
    }

    public WebElement getFirstAddNoteField() {
        return firstAddNoteField;
    }

    public WebElement getRunComparisonButton() {
        return runComparisonButton;
    }

    public WebElement getDeleteThirdCarButton() {
        return deleteThirdCarButton;
    }
}

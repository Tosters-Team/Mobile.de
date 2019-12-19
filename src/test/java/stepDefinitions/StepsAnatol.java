package stepDefinitions;

import actions.CommonActions;
import actions.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.annotations.WebElementName;
import scenarion_context.ScenarioContext;
import utils.Reflection;

import java.util.List;

public class StepsAnatol {

    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @When("User clicks on {int} random {string}")
    public void userClicksOnRandomButtons(int amountOfClicks, String nameOfWebElement) {

        List<WebElement> carParkButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), nameOfWebElement);

        List<WebElement> parkedStatus = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Parked status");

        Helper.getParkRandomCars(carParkButtons, parkedStatus, amountOfClicks);
    }


    @And("Cars are displayed")
    public void addedCarsAreDisplayed() {
        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        CommonActions.waitUntilVisible(amountOfCars);
        Assert.assertTrue(amountOfCars.isDisplayed());

        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
        }
    }

    @Then("the same (.*) is displayed")
    public void theSameTextIsDisplayed(String text) {
        WebElement textField = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Note field");
        Assert.assertTrue(textField.getText().equals(text));
    }

    @And("{string} is displayed")
    public void comparisonListIsDisplayed(String webElement) {
        WebElement comparisonList = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), webElement);

        WebElement comparisonHeader = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Comparison header");

        CommonActions.waitUntilVisible(comparisonHeader);
        Assert.assertTrue(comparisonList.isDisplayed());
        Assert.assertTrue(comparisonHeader.isDisplayed());

        scenarioContext.setCurrentPage(Reflection.getPageByName("Header"));

        CommonActions.clickOnWebElement(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "My car park button"));

        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        CommonActions.waitUntilVisible(amountOfCars);
        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
        }
    }
}


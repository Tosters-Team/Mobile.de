package stepDefinitions;

import actions.CommonActions;
import actions.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.Page;
import scenarion_context.ScenarioContext;
import utils.Reflection;

import java.util.List;

import static utils.PropertyConfigurator.getProperty;

public class AnatolAnatol {
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();


    @Then("User is on {string}")
    public void userIsOnPage(String pageName) {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName(pageName));

    }


    @When("User provides '(.*)' in '(.*)'")
    public void userProvidesIn(String inputData, String nameField) {
        Page currentPage = ScenarioContext.getInstance().getCurrentPage();

        CommonActions.sendKeys
                (Reflection.getWebElementByName
                        (currentPage, nameField), inputData);
    }

    @Then("{string} message is displayed")
    public void thenMessageIsDisplayed(String message) {
        CommonActions.waitUntilVisible
                (Reflection.getWebElementByName(scenarioContext.getCurrentPage(), message));
    }


    @Given("User clicks on {string} on {string}")
    public void userClicksOnDropDownLanguageOnHeader(String element, String pageName) {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName(pageName));

        CommonActions.clickOnWebElement
                (Reflection.getWebElementByName(scenarioContext.getCurrentPage(),
                        element));
    }

    @Given("User clicks on {string}")
    public void userClicksOn(String webElementName) {

        CommonActions.clickOnWebElement
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                webElementName));
    }

    @Given("User is logged in Mobile de")
    public void userIsLoggedInMobileDe() {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName("Header"));

        CommonActions.clickOnWebElement
                (Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "Login button"));

        scenarioContext.setCurrentPage
                (Reflection.getPageByName("Login Page"));

        CommonActions.sendKeys(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(), "Email field"),
                getProperty("EMAIL"));

        CommonActions.sendKeys(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(),
                        "Password field"), getProperty("PASSWORD"));

        CommonActions.clickOnWebElement(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "LogIn button"));

        scenarioContext.setCurrentPage(Reflection.getPageByName("Header"));

        Assert.assertTrue(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Logo").isDisplayed());
    }

    @When("User clicks on all {string}")
    public void userClicksOnAll(String nameOfButtons) {
        List<WebElement> buttons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), nameOfButtons);
        CommonActions.clickOnAllFromList(buttons);
    }

    @When("User selects (.*) in Make drop-down")
    public void userProvidesIn(String make) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), make));
    }

    @And("selects (.*) in Model drop-down")
    public void selectsModelInModelDropDown(String model) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), model));
    }

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
        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        WebElement textField = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Note field");
        Assert.assertTrue(textField.getText().equals(text));
        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
        }
    }

    @And("{string} is displayed")
    public void comparisonListIsDisplayed(String webElement) {
        WebElement comparisonTable = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), webElement);

        WebElement comparisonHeader = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Comparison header");

        CommonActions.waitUntilVisible(comparisonHeader);
        Assert.assertTrue(comparisonTable.isDisplayed());
        Assert.assertTrue(comparisonHeader.isDisplayed());

        scenarioContext.setCurrentPage(Reflection.getPageByName("Header"));

        CommonActions.clickOnWebElement(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "My car park button"));

        scenarioContext.setCurrentPage(Reflection.getPageByName("Car Park Page"));

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

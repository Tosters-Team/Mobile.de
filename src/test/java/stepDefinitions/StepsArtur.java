package stepDefinitions;

import actions.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import actions.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.*;
import scenarion_context.ScenarioContext;
import utils.Reflection;
import utils.ScreenShotUtil;


import java.text.ParseException;
import java.util.List;

import static utils.PropertyConfigurator.getProperty;

public class StepsArtur {
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @And("selects (.*) in Model drop-down")
    public void selectsModelInModelDropDown(String model) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), model));
    }


    @When("User selects (.*) in Make drop-down")
    public void userSelectsMakeInMakeDropDown(String make) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(
                ScenarioContext.getInstance().getCurrentPage(), make
        ));
    }

    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws ParseException {
        List<WebElement> listOfAnnouncements = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "List of announcements");
        List<WebElement> listOfPrices = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "List of prices");
        Assert.assertTrue(CommonActions.webElementContainsText(make,Helper.getRandomCar(listOfAnnouncements)));
        Assert.assertTrue(CommonActions.webElementContainsText(model,Helper.getRandomCar(listOfAnnouncements)));
        Assert.assertTrue(Helper.returnsIntFromParsedString(Helper.getRandomCar(listOfPrices).getText())
                <= Helper.returnsIntFromParsedString(price));
    }

    @And("selects price up to (.*) in Price field")
    public void selectsPriceUpToPriceInPriceField(String price) {
        CommonActions.sendKeys(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "Price field"), price);
    }

    @When("User selects (.*) category on Quick Truck Search")
    public void userSelectsCategoryCategoryOnQuickTruckSearch(String category) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), category));
    }

    @Then("detailed search of that (.*) is displayed")
    public void detailedSearchOfThatCategoryIsDisplayed(String category) {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(
                scenarioContext.getCurrentPage(), "Truck page header"));
        Assert.assertTrue(Reflection.getWebElementByName(
                scenarioContext.getCurrentPage(), "Truck page header")
                .getText().contains(category));
    }


    @Given("User clicks on {string} on {string}")
    public void userClicksOnLanguageSelectorDropDownOnHeader(String element, String pageName) {
        scenarioContext.setCurrentPage(Reflection.getPageByName(pageName));
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), element));
    }


    @Then("User is on {string}")
    public void userIsOnPage(String pageName) {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName(pageName));
    }

    @Given("User clicks on {string}")
    public void userClicksOn(String webElementName) {
        CommonActions.clickOnWebElement(
                Reflection.getWebElementByName(
                        scenarioContext.getCurrentPage(),
                        webElementName));
    }


    @When("User provides '(.*)' in '(.*)'")
    public void userProvidesIn(String inputData, String nameField) {
        CommonActions.sendKeys
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                nameField), inputData);
    }

    @Then("{string} message is displayed")
    public void thenMessageIsDisplayed(String message) {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), message));
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



}

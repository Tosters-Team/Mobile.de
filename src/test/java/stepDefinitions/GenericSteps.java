package stepDefinitions;

import actions.CommonActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.EditAccountPage;
import pageObjects.HeaderGeneral;
import pageObjects.*;
import pageObjects.Page;
import scenarion_context.ScenarioContext;
import utils.Reflection;

import static utils.PropertyConfigurator.getProperty;

public class GenericSteps {
    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Then("User is on {string}")
    public void userIsOnPage(String pageName) {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName(pageName));

        Page currentPage = scenarioContext.getCurrentPage();

//        WebElement assertWebElement = Reflection.getWebElementByName(currentPage, "Logo");
//
//        CommonActions.waitUntilVisible(assertWebElement);
//
//        Assert.assertTrue(assertWebElement.isDisplayed());
    }

    @Given("User clicks on {string}")
    public void userClicksOn(String webElementName) {
        Page currentPage = scenarioContext.getCurrentPage();

        CommonActions.clickOnWebElement
                (Reflection.getWebElementByName
                        (currentPage,
                                webElementName));
    }

    @When("User provides {string} in {string}")
    public void userProvidesIn(String inputData, String nameField) {
        Page currentPage = ScenarioContext.getInstance().getCurrentPage();

        CommonActions.sendKeys
                (Reflection.getWebElementByName
                        (currentPage, nameField), inputData);
    }

    @Given("User is logged in Mobile de")
    public void userIsLoggedInMobileDe() {
        Page currentPage = ScenarioContext.getInstance().getCurrentPage();

        ScenarioContext.getInstance().setCurrentPage
                (Reflection.getPageByName("Login Page"));

        Page loginPage = ScenarioContext.getInstance().getCurrentPage();

        WebElement emailField = Reflection.getWebElementByName(loginPage,
                "Email field");
        WebElement passWordField = Reflection.getWebElementByName(loginPage,
                "Password field");

//        CommonActions.clickOnWebElement(currentPage.getLoginButton());
        CommonActions.sendKeys(emailField, getProperty("EMAIL"));
        CommonActions.sendKeys(passWordField, getProperty("PASSWORD"));

    }
    @Then("{string} message is displayed")
    public void thenMessageIsDisplayed(String message) {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), message));
//        Assert.assertTrue(ScenarioContext.getInstance().getCurrentPage().getLoginButton().isDisplayed());
    }

    @Given("User clicks on (.*) on (.*)")
    public void userClicksOnDropDownLanguageOnHeader(String element, String pageName) {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName(pageName));

        Page currentPage = scenarioContext.getCurrentPage();

        WebElement assertWebElement = Reflection.getWebElementByName(currentPage, "Login button");

        CommonActions.waitUntilVisible(assertWebElement);

        Assert.assertTrue(assertWebElement.isDisplayed());
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(currentPage,element));

    }
}



package stepDefinitions;

import actions.CommonActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.EditAccountPage;
import pageObjects.HeaderGeneral;
import pageObjects.LoginPage;
import pageObjects.Page;
import scenarion_context.ScenarioContext;
import utils.Reflection;

import static utils.PropertyConfigurator.getProperty;

public class GenericSteps {
    @Then("User is on {string}")
    public void userIsOnPage(String pageName) {
        ScenarioContext.getInstance().setCurrentPage
                (Reflection.getPageByName(pageName));

        Page currentPage = ScenarioContext.getInstance().getCurrentPage();

        WebElement assertWebElement = Reflection.getWebElementByName(currentPage, "assertForPage");

        CommonActions.waitUntilVisible(assertWebElement);

        Assert.assertTrue(assertWebElement.isDisplayed());
    }

    @Given("User clicks on {string}")
    public void userClicksOn(String webElementName) {
        Page currentPage = ScenarioContext.getInstance().getCurrentPage();

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

        CommonActions.clickOnWebElement(currentPage.getLoginButton());
        CommonActions.sendKeys(emailField, getProperty("EMAIL"));
        CommonActions.sendKeys(passWordField, getProperty("PASSWORD"));

    }
}



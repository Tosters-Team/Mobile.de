package stepDefinitions;

import actions.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import scenarion_context.ScenarioContext;
import utils.Log;
import utils.Reflection;
import utils.ScreenShotUtil;

import java.util.List;

import static utils.PropertyConfigurator.getProperty;

public class GenericSteps {

    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Given("User clicks on {string} on {string}")
    public void userClicksOnWebElementOnPageObject(String element, String pageName) throws Exception {
        scenarioContext.setCurrentPage(Reflection.getPageByName(pageName));
        Log.info(pageName + " page is accessed successfully");
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), element));
        Log.info(element + " Web Element clicked successfully");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Given("User clicks on {string}")
    public void userClicksOn(String webElementName) throws Exception {
        CommonActions.clickOnWebElement
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                webElementName));
        Log.info(webElementName + " Web Element clicked successfully");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Given("User is logged in Mobile de")
    public void userIsLoggedInMobileDe() throws Exception {
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
        Log.info("Logged in successfully");
    }

    @And("User is on {string}")
    public void userIsOnPage(String pageName) throws Exception {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName(pageName));
        Log.info(pageName + "  page is accessed successfully");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @When("User clicks on all {string}")
    public void userClicksOnAll(String nameOfButtons) throws Exception {
        List<WebElement> buttons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), nameOfButtons);
        CommonActions.clickOnAllFromList(buttons);
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
        Log.info("Successfully clicked on all " + nameOfButtons);
    }

    @Then("{string} message is displayed")
    public void thenMessageIsDisplayed(String message) throws Exception {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), message));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
        Log.info(message + " is displayed");

    }

    @When("User provides '(.*)' in '(.*)'")
    public void userProvidesIn(String inputData, String nameField) throws Exception {
        CommonActions.sendKeys
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                nameField), inputData);
        Log.info("User entered " + inputData + " value in " + nameField + " field successfully");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @When("User inserts value '(.*)' in '(.*)'")
    public void userInsertsValue(String option, String optionType) throws Exception {
        CommonActions.sendKeysWithOutClearField(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), optionType), option);
        Log.info("User entered " + option + " value in " + optionType + " field successfully");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("User selects specific '(.*)'")
    public void userSelectsSpecificFuelType(String webElementName) {
        CommonActions.clickOnWebElement
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                webElementName));
        Log.info(webElementName + " Web Element clicked successfully");
    }
}
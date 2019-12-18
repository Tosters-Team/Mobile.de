package stepDefinitions;

import actions.CommonActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.EditAccountPage;
import pageObjects.HeaderGeneral;
import pageObjects.LoginPage;
import scenarion_context.ScenarioContext;
import utils.Reflection;

public class GenericSteps {
    HeaderGeneral headerGeneral = new HeaderGeneral();
    EditAccountPage editAccountPage = new EditAccountPage();
    LoginPage loginPage = new LoginPage();

    @Given("User clicks on {string}")
    public void userClicksOn(String name) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(headerGeneral,name));
    }

    @When("User provides {string} in {string}")
    public void userProvidesIn(String text, String field) {
        CommonActions.sendKeys(Reflection.getWebElementByName(loginPage,field),text);
    }

    @Then("User is on {string}")
    public void userIsOnPage(String page) {
        ScenarioContext.getInstance().
                setCurrentPage(Reflection.getPageByName(page));
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(
                ScenarioContext.getInstance().
                        getCurrentPage(),page));
    }

    @Then("{string} message is displayed")
    public void thenMessageIsDisplayed(String message) {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(loginPage,message));
    }
}



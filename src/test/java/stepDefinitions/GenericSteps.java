package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.EditAccountPage;
import pageObjects.HeaderGeneral;
import pageObjects.InitPages;
import pageObjects.LoginPage;
import utils.Reflection;

public class GenericSteps {
    HeaderGeneral headerGeneral = new HeaderGeneral();
    EditAccountPage editAccountPage = new EditAccountPage();
    LoginPage loginPage = new LoginPage();

    @Given("User clicks on {string}")
    public void userClicksOn(String name) {
        InitPages.clickOnWebElement(Reflection.getWebElementByName(headerGeneral,name));
    }

    @When("User provides {string} in {string}")
    public void userProvidesIn(String text, String field) {
        InitPages.sendKeys(Reflection.getWebElementByName(loginPage,field),text);
    }

    @Then("User is on {string}")
    public void userIsOnPage(String page) {
        InitPages.waitUntilVisible(Reflection.getWebElementByName(loginPage,page));
    }

    @Then("{string} message is displayed")
    public void thenMessageIsDisplayed(String message) {
        InitPages.waitUntilVisible(Reflection.getWebElementByName(loginPage,message));
    }
}



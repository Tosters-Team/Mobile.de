package stepDefinitions;

import actions.CommonActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.HeaderGeneral;
import scenarion_context.ScenarioContext;
import utils.Reflection;

public class GenericSteps {
    private HeaderGeneral headerGeneral = new HeaderGeneral();
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Given("User clicks on {string}")
    public void userClicksOn(String name) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), name));
    }

    @When("User provides {string} in {string}")
    public void userProvidesIn(String text, String field) {
        CommonActions.sendKeys(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), field), text);
    }

    @Then("User is on {string}")
    public void userIsOnPage(String page) {
        ScenarioContext.getInstance().setCurrentPage(Reflection.getPageByName(page));
    }

    @Then("{string} message is displayed")
    public void thenMessageIsDisplayed(String message) {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), message));
        Assert.assertTrue(ScenarioContext.getInstance().getCurrentPage().getLoginButton().isDisplayed());
    }

    @Given("Mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglishArturStock() {
        CommonActions.clickOnWebElement(headerGeneral.getGermanLanguage());
        CommonActions.clickOnWebElement(headerGeneral.getEnglishLanguage());
        CommonActions.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}



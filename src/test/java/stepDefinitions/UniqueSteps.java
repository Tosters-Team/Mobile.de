package stepDefinitions;

import actions.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import scenarion_context.ScenarioContext;
import utils.Reflection;

public class UniqueSteps {

    @When("User selects (.*) in Make drop-down")
    public void userProvidesIn(String make){
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), make));
    }

    @And("selects (.*) in Model drop-down")
    public void selectsModelInModelDropDown(String model) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), model));
    }
}

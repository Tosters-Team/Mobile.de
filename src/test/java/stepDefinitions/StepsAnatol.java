package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Helper;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import pageObjects.*;
import scenarion_context.ScenarioContext;

public class StepsAnatol {

    private HeaderGeneral headerGeneral = new HeaderGeneral();
    private LoginPage loginPage = new LoginPage();
    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch();
    private CarListPage carListPage = new CarListPage();
    private CarParkPage carParkPage = new CarParkPage();
    private ComparisonPage comparisonPage = new ComparisonPage();


    @Given("user is logged in Mobile de and search button was clicked")
    public void loginAndClickOnSearchButton() {
        ScenarioContext.getInstance().setCurrentPage(headerGeneral);
        ScenarioContext.getInstance().getCurrentPage();
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
        ScenarioContext.getInstance().setCurrentPage(loginPage);
        ScenarioContext.getInstance().getCurrentPage();
        InitPages.sendKeys(loginPage.getEMailField(), "leecooper_leecooper@mail.ru");
        InitPages.sendKeys(loginPage.getPasswordField(), "HappyTest123");
        InitPages.clickOnWebElement(loginPage.getLoginButton());
        ScenarioContext.getInstance().setCurrentPage(homePageQuickSearch);
        ScenarioContext.getInstance().getCurrentPage();
        InitPages.clickOnWebElement(homePageQuickSearch.getSearchButton());
    }

    @When("{int} random car from list was parked")
    public void randomCarFromListWasParked(int amount) {
        Helper.getParkRandomCars(carListPage.getParkingButtons(), carListPage.getStatusParked(), amount);
    }

    @Then("car is displayed on car park page")
    public void carsAreDisplayed() {
        Assert.assertTrue("car is displayed",
                InitPages.webElementContainsText("1", carParkPage.getAmountOfCars()));
        if (carParkPage.getAmountOfCars().isDisplayed()) {
            InitPages.clickOnAllFromList(carParkPage.getRemoveCarButtons());
        }
    }

    @When("click on compare checkboxes under cars and click on run comparison button")
    public void clickOnCompareCheckboxUnderFirstAndSecondCar() {
        InitPages.clickOnAllFromList(carParkPage.getCompareCheckBoxes());
        InitPages.clickOnWebElement(carParkPage.getRunComparisonButton());
    }

    @Then("comparison page with cars is displayed")
    public void comparisonPageWithCarsIsDisplayed() {
        Assert.assertTrue("Comparison page is displayed",
                comparisonPage.getComparisonPageHeader().isDisplayed());
        Assert.assertTrue("Comparison page is displayed",
                InitPages.webElementContainsText("Vehicle Comparison ",
                        comparisonPage.getComparisonPageHeader()));
        InitPages.clickOnWebElement(headerGeneral.getMyCarParkButton());
        if (carParkPage.getAmountOfCars().isDisplayed()) {
            InitPages.clickOnAllFromList(carParkPage.getRemoveCarButtons());
        }
    }

    @Then("the same (.*) is displayed")
    public void theSameTextIsDisplayed(String noteText) {
        MatcherAssert.assertThat("The same text is displayed",
                carParkPage.getFirstAddNoteField().
                        getText().equals(noteText));
        if (carParkPage.getAmountOfCars().isDisplayed()) {
            InitPages.clickOnAllFromList(carParkPage.getRemoveCarButtons());
        }
    }

    @And("car park button was clicked")
    public void clickOnCarParkButton() {
        InitPages.clickOnWebElement(headerGeneral.getMyCarParkButton());
    }

    @When("click on add note button under car and enter (.*) in field")
    public void clickOnAddNoteButtonUnderFirstCarAndEnterTextInField(String noteText) {
        InitPages.clickOnWebElement(carParkPage.getFirstNoteButton());
        InitPages.sendKeys(carParkPage.getFirstAddNoteField(), noteText);
    }

    @And("click on hide note button and click show note button")
    public void clickOnHideNoteButtonAndClickShowNoteButton() {
        InitPages.clickOnWebElement(carParkPage.getFirstNoteButton());
        InitPages.clickOnWebElement(carParkPage.getFirstNoteButton());
    }

    @When("user clicks on remove button")
    public void userClicksOnDeleteButton() {
        InitPages.clickOnAllFromList(carParkPage.getRemoveCarButtons());
        InitPages.waitUntilVisible(carParkPage.getUndoCarButtons().get(0));
    }

    @Then("removed car disappears and undo button is displayed")
    public void removedCarDisappearsAndUndoButtonIsDisplayed() {
        MatcherAssert.assertThat("Undo button is displayed",
                carParkPage.getUndoCarButtons().get(0).isDisplayed());
    }

    @When("user clicks on undo button")
    public void userClicksOnUndoButton() {
        InitPages.clickOnWebElement(carParkPage.getUndoCarButtons().get(0));
    }

    @Then("removed car is restored")
    public void removedCarIsRestored() {
        InitPages.waitUntilVisible(carParkPage.getAmountOfCars());
        MatcherAssert.assertThat("car is restored",
                InitPages.webElementContainsText("1",
                        carParkPage.getAmountOfCars()));
        MatcherAssert.assertThat("delete button is displayed",
                carParkPage.getRemoveCarButtons().
                        get(0).isDisplayed());
        InitPages.clickOnWebElement(headerGeneral.getMyCarParkButton());
        if (carParkPage.getAmountOfCars().isDisplayed()) {
            InitPages.clickOnAllFromList(carParkPage.getRemoveCarButtons());
        }
    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String informativeMessage) {
        Assert.assertTrue("Car Park is empty",
                InitPages.webElementContainsText(informativeMessage,
                        carParkPage.getInformativeMessage()));
    }

    @And("user click on delete button")
    public void userClickOnDeleteButton() {
        InitPages.clickOnWebElement(carParkPage.getDeleteCarButtons().get(0));
    }
}


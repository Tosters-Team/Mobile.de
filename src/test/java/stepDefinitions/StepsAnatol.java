//package stepDefinitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import actions.Helper;
//import org.hamcrest.MatcherAssert;
//import org.junit.Assert;
//import pageObjects.*;
//
//public class StepsAnatol {
//
//    private HeaderGeneral headerGeneral = new HeaderGeneral();
//    private LoginPage loginPage = new LoginPage();
//    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch();
//    private CarListPage carListPage = new CarListPage();
//    private CarParkPage carParkPage = new CarParkPage();
//    private ComparisonPage comparisonPage = new ComparisonPage();
//
//
//    @Given("user is logged in Mobile de and search button was clicked")
//    public void loginAndClickOnSearchButton() {
//        Page.clickOnWebElement(headerGeneral.getLoginButton());
//        Page.sendKeys(loginPage.getEMailField(), "leecooper_leecooper@mail.ru");
//        Page.sendKeys(loginPage.getPasswordField(), "HappyTest123");
//        Page.clickOnWebElement(loginPage.getLoginButton());
//        Page.clickOnWebElement(homePageQuickSearch.getSearchButton());
//    }
//
//    @When("{int} random car from list was parked")
//    public void randomCarFromListWasParked(int amount) {
//        Helper.getParkRandomCars(carListPage.getParkButtons(), carListPage.getStatusParked(), amount);
//    }
//
//    @Then("car is displayed on car park page")
//    public void carsAreDisplayed() {
//        Assert.assertTrue("car is displayed",
//                Page.webElementContainsText("1", carParkPage.getAmountOfCars()));
//        if (carParkPage.getAmountOfCars().isDisplayed()) {
//            Page.clickOnAllFromList(carParkPage.getRemoveCarButtons());
//        }
//    }
//
//    @When("click on compare checkboxes under cars and click on run comparison button")
//    public void clickOnCompareCheckboxUnderFirstAndSecondCar() {
//        Page.clickOnAllFromList(carParkPage.getCompareCheckBoxes());
//        Page.clickOnWebElement(carParkPage.getRunComparisonButton());
//    }
//
//    @Then("comparison page with cars is displayed")
//    public void comparisonPageWithCarsIsDisplayed() {
//        Assert.assertTrue("Comparison page is displayed",
//                comparisonPage.getComparisonPageHeader().isDisplayed());
//        Assert.assertTrue("Comparison page is displayed",
//                Page.webElementContainsText("Vehicle Comparison ",
//                        comparisonPage.getComparisonPageHeader()));
//        Page.clickOnWebElement(headerGeneral.getMyCarParkButton());
//        if (carParkPage.getAmountOfCars().isDisplayed()) {
//            Page.clickOnAllFromList(carParkPage.getRemoveCarButtons());
//        }
//    }
//
//    @Then("the same (.*) is displayed")
//    public void theSameTextIsDisplayed(String noteText) {
//        MatcherAssert.assertThat("The same text is displayed",
//                carParkPage.getFirstAddNoteField().
//                        getText().equals(noteText));
//        if (carParkPage.getAmountOfCars().isDisplayed()) {
//            Page.clickOnAllFromList(carParkPage.getRemoveCarButtons());
//        }
//    }
//
//    @And("car park button was clicked")
//    public void clickOnCarParkButton() {
//        Page.clickOnWebElement(headerGeneral.getMyCarParkButton());
//    }
//
//    @When("click on add note button under car and enter (.*) in field")
//    public void clickOnAddNoteButtonUnderFirstCarAndEnterTextInField(String noteText) {
//        Page.clickOnWebElement(carParkPage.getFirstNoteButton());
//        Page.sendKeys(carParkPage.getFirstAddNoteField(), noteText);
//    }
//
//    @And("click on hide note button and click show note button")
//    public void clickOnHideNoteButtonAndClickShowNoteButton() {
//        Page.clickOnWebElement(carParkPage.getFirstNoteButton());
//        Page.clickOnWebElement(carParkPage.getFirstNoteButton());
//    }
//
//    @When("user clicks on remove button")
//    public void userClicksOnDeleteButton() {
//        Page.clickOnAllFromList(carParkPage.getRemoveCarButtons());
//        Page.waitUntilVisible(carParkPage.getUndoCarButtons().get(0));
//    }
//
//    @Then("removed car disappears and undo button is displayed")
//    public void removedCarDisappearsAndUndoButtonIsDisplayed() {
//        MatcherAssert.assertThat("Undo button is displayed",
//                carParkPage.getUndoCarButtons().get(0).isDisplayed());
//    }
//
//    @When("user clicks on undo button")
//    public void userClicksOnUndoButton() {
//        Page.clickOnWebElement(carParkPage.getUndoCarButtons().get(0));
//    }
//
//    @Then("removed car is restored")
//    public void removedCarIsRestored() {
//        Page.waitUntilVisible(carParkPage.getAmountOfCars());
//        MatcherAssert.assertThat("car is restored",
//                Page.webElementContainsText("1",
//                        carParkPage.getAmountOfCars()));
//        MatcherAssert.assertThat("delete button is displayed",
//                carParkPage.getRemoveCarButtons().
//                        get(0).isDisplayed());
//        Page.clickOnWebElement(headerGeneral.getMyCarParkButton());
//        if (carParkPage.getAmountOfCars().isDisplayed()) {
//            Page.clickOnAllFromList(carParkPage.getRemoveCarButtons());
//        }
//    }
//
//    @Then("message {string} is displayed")
//    public void messageIsDisplayed(String informativeMessage) {
//        Assert.assertTrue("Car Park is empty",
//                Page.webElementContainsText(informativeMessage,
//                        carParkPage.getInformativeMessage()));
//    }
//
//    @And("user click on delete button")
//    public void userClickOnDeleteButton() {
//        Page.clickOnWebElement(carParkPage.getDeleteCarButtons().get(0));
//    }
//}
//

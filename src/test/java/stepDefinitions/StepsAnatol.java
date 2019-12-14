package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Helper;
import org.junit.Assert;
import pageObjects.*;

import static stepDefinitions.Hooks.driver;

public class StepsAnatol {

    private HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch(driver);
    private CarListPage carListPage = new CarListPage(driver);
    private CarParkPage carParkPage = new CarParkPage(driver);
    private ComparisonPage comparisonPage = new ComparisonPage(driver);

    @Given("mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglish() {
        InitPages.clickOnWebElement(headerGeneral.getGermanLanguage());
        InitPages.clickOnWebElement((headerGeneral.getEnglishLanguage()));
        InitPages.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @Given("user is logged in Mobile de and search button was clicked")
    public void loginAndClickOnSearchButton() {
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
        InitPages.sendKeys(loginPage.getEMailField(), "leecooper_leecooper@mail.ru");
        InitPages.sendKeys(loginPage.getPasswordField(), "HappyTest123");
        InitPages.clickOnWebElement(loginPage.getLoginButton());
        InitPages.clickOnWebElement(homePageQuickSearch.getSearchButton());
    }

    @When("{int} random car from list was parked")
    public void randomCarFromListWasParked(int amount) {
        Helper.getParkRandomCars(carListPage.getParkingButtons(), carListPage.getStatusParked(), amount);
    }

    @Then("car is displayed on car park page")
    public void carsAreDisplayed() {
        InitPages.clickOnWebElement(headerGeneral.getMyCarParkButton());
        Assert.assertTrue(headerGeneral.getMyCarParkButton().
                getText().
                contains("1"));

    }

    @When("click on compare checkboxes under cars")
    public void clickOnCompareCheckboxUnderFirstAndSecondCar() {
        InitPages.clickOnAllFromList(carParkPage.getCompareCheckBoxes());
        InitPages.clickOnWebElement(carParkPage.getRunComparisonButton());
    }

    @And("click on run comparison button")
    public void clickOnRunComparisonButton() {
        InitPages.clickOnWebElement(carParkPage.getRunComparisonButton());
    }

    @Then("comparison page with cars is displayed")
    public void comparisonPageWithCarsIsDisplayed() {
    }


    @Then("the same (.*) is displayed")
    public void theSameTextIsDisplayed(String noteText) {
        Assert.assertTrue(carParkPage.getFirstAddNoteField().
                getText().
                contains(noteText));
    }

    @And("click on car park button")
    public void clickOnCarParkButton() {
        InitPages.clickOnWebElement(headerGeneral.getMyCarParkButton());
    }


    @Given("login to Mobile de and click on car park button")
    public void loginToMobileDeAndClickOnCarParkButton() {
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
        InitPages.sendKeys(loginPage.getEMailField(), "leecooper_leecooper@mail.ru");
        InitPages.sendKeys(loginPage.getPasswordField(), "HappyTest123");
        InitPages.clickOnWebElement(loginPage.getLoginButton());
        InitPages.clickOnWebElement(headerGeneral.getMyCarParkButton());
    }

    @When("click on add note button under  car and enter (.*) in field")
    public void clickOnAddNoteButtonUnderFirstCarAndEnterTextInField(String noteText) {
        InitPages.clickOnWebElement(carParkPage.getFirstNoteButton());
        InitPages.sendKeys(carParkPage.getFirstAddNoteField(), noteText);
    }

    @And("click on hide note button and click show note button")
    public void clickOnHideNoteButtonAndClickShowNoteButton() {
        InitPages.clickOnWebElement(carParkPage.getFirstNoteButton());
        InitPages.clickOnWebElement(carParkPage.getFirstNoteButton());
    }
}


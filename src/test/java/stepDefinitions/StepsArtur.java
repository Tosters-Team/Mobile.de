package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Action;
import methods.Helper;
import pageObjects.*;

import java.text.ParseException;

import static stepDefinitions.Hooks.driver;

public class StepsArtur {


    private HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private QuickTruckSearch quickTruckSearch = new QuickTruckSearch(driver);
    private EditAccountPage editAccountPage = new EditAccountPage(driver);
    Helper helper = new Helper();

    @Given("Mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglish() {
        Action.clickOnWebElement(headerGeneral.getGermanLanguage());
        Action.clickOnWebElement((headerGeneral.getEnglishLanguage()));
        Action.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @When("User select (.*) in Make drop-down")
    public void UserSelectMakeInMakeDropDown(String make) {
        Action.clickOnWebElement(homePageQuickSearch.getWebElementByName(make));
        Action.waitUntilVisible(homePageQuickSearch.getWebElementByName(make));
    }

    @And("select (.*) in Model drop-down")
    public void selectModelInModelDropDown(String model) {
        Action.clickOnWebElement(homePageQuickSearch.getWebElementByName(model));
        Action.waitUntilVisible(homePageQuickSearch.getWebElementByName(model));
    }

    @And("select price up to (.*)")
    public void selectPriceUpToPrice(String price) {
        Action.sendKeys(homePageQuickSearch.getPriceUpTo(), price);
    }

    @And("click on Search button")
    public void clickOnSearchButton() {
        Action.clickOnWebElement(homePageQuickSearch.getSearchButton());
    }

    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws ParseException {
        helper.assert_is_make_model_underPrice_ListTest(make, model, price);
    }

    @Given("Login page is opened")
    public void loginPageIsOpened() {
        Action.clickOnWebElement(headerGeneral.getLoginButton());
        Action.waitUntilVisible(loginPage.getLoginButton());
    }

    @When("User provide valid credentials Email and Password")
    public void UserProvideValidCredentialsEmailPassword() {
        Action.sendKeys(loginPage.getEMailField(), "vangartur@gmail.com");
        Action.sendKeys(loginPage.getPasswordField(), "Artiq!23");
    }

    @And("click on Log in Button")
    public void clickOnLogInButton() {
        Action.clickOnWebElement(loginPage.getLoginButton());
    }

    @Then("User was successfully logged in")
    public void UserWasSuccessfullyLoggedIn() {
        Action.webElementContainsText("MyMobile.de", headerGeneral.getMyMobileDeDropDown());
    }

    @Then("pop-up message about invalid credentials is displayed")
    public void popUpMessageAboutInvalidCredentialsIsDisplayed() {
        Action.waitUntilVisible(loginPage.getNotValidCredentials());

    }

    @When("User provides invalid credentials Email and Password")
    public void userProvidesInvalidCredentialsEmailAndPassword() {
        Action.sendKeys(loginPage.getEMailField(), "sdfsdfs@sadas.dsad");
        Action.sendKeys(loginPage.getPasswordField(), "asdadad");
    }

    @When("User selects Truck category")
    public void userSelectsCategory() {
        Action.clickOnWebElement(homePageQuickSearch.getTruckTab());
    }

    @Then("Truck category page is displayed")
    public void truckCategoryPageIsDisplayed() {
        Action.waitUntilVisible(quickTruckSearch.getQuickTruckPageHeader());
    }

    @When("user selects (.*) category")
    public void userSelectsCategoryCategory(String category) {
        Action.clickOnWebElement(quickTruckSearch.getWebElementByName(category));
    }

    @Then("detailed search of that (.*) is displayed")
    public void detailedSearchOfThatCategoryIsDisplayed(String category) {
        Action.waitUntilVisible(quickTruckSearch.getGeneralTrucksCategoryHeader());
        Action.webElementContainsText(category, quickTruckSearch.getGeneralTrucksCategoryHeader());
    }

    @Given("User is logged in with valid credentials")
    public void userIsLoggedInWithValidCredentials() {
        Action.clickOnWebElement(headerGeneral.getLoginButton());
        Action.waitUntilVisible(loginPage.getLoginButton());
        Action.sendKeys2(loginPage.getEMailField(), "vangartur@gmail.com");
        Action.sendKeys2(loginPage.getPasswordField(), "Artiq!23");
        Action.clickOnWebElement(loginPage.getLoginButton());
    }

    @And("Edit Account page is opened")
    public void editAccountPageIsOpened() {
        Action.clickOnWebElement(headerGeneral.getMyMobileDeDropDown());
        Action.clickOnWebElement(headerGeneral.getEditAccountOption());

    }

    @When("User changes (.*) and (.*) name and presses save button")
    public void userChangesFirstAndLastNameAndPressesSaveButton(String first, String last) {
        Action.waitUntilVisible(editAccountPage.getEditedSection());
        Action.clickOnWebElement(editAccountPage.getChangeName());
        Action.sendKeys2(editAccountPage.getFirstNameField(),first);
        Action.sendKeys2(editAccountPage.getLastNameField(),last);
        Action.clickOnWebElement(editAccountPage.getSaveChanging());
        Action.waitUntilVisible(editAccountPage.getChangedMessage());
    }

    @And("User changes street to (.*) and house number to (.*)")
    public void userChangesStreetToStreetAndHouseNumberToHouseNumber(String street, String houseNumber) {
        Action.clickOnWebElement(editAccountPage.getChangeAddress());

        Action.sendKeys2(editAccountPage.getStreetField(),street);
        Action.sendKeys2(editAccountPage.getHouseNumber(),houseNumber);
    }

    @And("zip code to (.*) and city to (.*) and presses save button")
    public void zipCodeToZipCodeAndCityToCityAndPressesSaveButton(String zipCode,String city) {
        Action.waitUntilVisible(editAccountPage.getZipCodeField());
        Action.sendKeys2(editAccountPage.getZipCodeField(),zipCode);
        Action.sendKeys2(editAccountPage.getCityField(),city);
        Action.clickOnWebElement(editAccountPage.getSaveChanging());
        Action.waitUntilVisible(editAccountPage.getChangedMessage());
    }

    @Then("changed (.*) and (.*) name,(.*),(.*),(.*)")
    public void changedFirstAndLastNameStreetHouseNumberZipCode(String first,String last,String street,String houseNumber,String zipCode) {
        Action.webElementContainsText(first,editAccountPage.getEditedSection());
        Action.webElementContainsText(last,editAccountPage.getEditedSection());
        Action.webElementContainsText(street,editAccountPage.getEditedSection());
        Action.webElementContainsText(houseNumber,editAccountPage.getEditedSection());
        Action.webElementContainsText(zipCode,editAccountPage.getEditedSection());

    }

    @And("(.*) are displayed in Edit Account page")
    public void cityAreDisplayedInEditAccountPage(String city) {
        Action.webElementContainsText(city,editAccountPage.getEditedSection());
    }
}

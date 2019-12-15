package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Action;
import methods.Helper;
import pageObjects.*;
import utils.ScreenShotUtil;

import java.text.ParseException;

import static stepDefinitions.Hooks.driver;

public class StepsArtur {


    private HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private QuickTruckSearch quickTruckSearch = new QuickTruckSearch(driver);
    private EditAccountPage editAccountPage = new EditAccountPage(driver);
    private Helper helper = new Helper();

    @Given("Mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglish() {
        InitPages.clickOnWebElement(headerGeneral.getGermanLanguage());
        InitPages.clickOnWebElement(headerGeneral.getEnglishLanguage());
        Action.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @When("User selects (.*) in Make drop-down")
    public void UserSelectsMakeInMakeDropDown(String make) throws Exception {
        InitPages.clickOnWebElement(homePageQuickSearch.getWebElementByName(make));
//        ScreenShotUtil.takeScreenShot(driver,"src/test/screenShotOutput/test.png");
    }

    @And("selects (.*) in Model drop-down")
    public void selectsModelInModelDropDown(String model) throws Exception {
        InitPages.clickOnWebElement(homePageQuickSearch.getWebElementByName(model));
//        ScreenShotUtil.takeScreenShot(driver,"src/test/screenShotOutput/test1.png");
    }

    @And("selects price up to (.*)")
    public void selectsPriceUpToPrice(String price) throws Exception {
        InitPages.sendKeys(homePageQuickSearch.getPriceUpTo(), price);
//        ScreenShotUtil.takeScreenShot(driver,"src/test/screenShotOutput/test2.png");
    }

    @And("clicks on Search button")
    public void clicksOnSearchButton() {
        InitPages.clickOnWebElement(homePageQuickSearch.getSearchButton());
    }

    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws ParseException {
        helper.assert_is_make_model_underPrice_ListTest(make, model, price);
    }

    @Given("Login page is opened")
    public void loginPageIsOpened() {
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
    }

    @When("User provide valid credentials Email and Password")
    public void UserProvideValidCredentialsEmailPassword() {
        InitPages.sendKeys(loginPage.getEMailField(), "vangartur@gmail.com");
        InitPages.sendKeys(loginPage.getPasswordField(), "Artiq!23");
    }

    @And("clicks on Log in Button")
    public void clicksOnLogInButton() {
        InitPages.clickOnWebElement(loginPage.getLoginButton());
    }

    @Then("User was successfully logged in")
    public void UserWasSuccessfullyLoggedIn() {
        InitPages.webElementContainsText("MyMobile.de", headerGeneral.getMyMobileDeDropDown());
    }

    @Then("pop-up message about invalid credentials is displayed")
    public void popUpMessageAboutInvalidCredentialsIsDisplayed() {
        InitPages.waitUntilVisible(loginPage.getNotValidCredentials());

    }

    @When("User provides invalid credentials Email and Password")
    public void userProvidesInvalidCredentialsEmailAndPassword() {
        InitPages.sendKeys(loginPage.getEMailField(), "sdfsdfs@sadas.dsad");
        InitPages.sendKeys(loginPage.getPasswordField(), "asdadad");
    }

    @When("User selects Truck category")
    public void userSelectsCategory() {
        InitPages.clickOnWebElement(homePageQuickSearch.getTruckTab());
    }

    @Then("Truck category page is displayed")
    public void truckCategoryPageIsDisplayed() {
        InitPages.waitUntilVisible(quickTruckSearch.getQuickTruckPageHeader());
    }

    @When("User selects (.*) category on Quick Truck Search")
    public void userSelectsCategoryCategory(String category) {
        InitPages.clickOnWebElement(quickTruckSearch.getWebElementByName(category));
    }

    @Then("detailed search of that (.*) is displayed")
    public void detailedSearchOfThatCategoryIsDisplayed(String category) {
        InitPages.waitUntilVisible(quickTruckSearch.getGeneralTrucksCategoryHeader());
        InitPages.webElementContainsText(category, quickTruckSearch.getGeneralTrucksCategoryHeader());

    }

    @And("Edit Account page is opened")
    public void editAccountPageIsOpened() {
        InitPages.clickOnWebElement(headerGeneral.getMyMobileDeDropDown());
        InitPages.clickOnWebElement(headerGeneral.getEditAccountOption());

    }

    @When("User changes (.*) and (.*) name and presses save button")
    public void userChangesFirstAndLastNameAndPressesSaveButton(String first, String last) {
        InitPages.waitUntilVisible(editAccountPage.getEditedSection());
        InitPages.clickOnWebElement(editAccountPage.getChangeName());
        InitPages.sendKeys(editAccountPage.getFirstNameField(), first);
        InitPages.sendKeys(editAccountPage.getLastNameField(), last);
        InitPages.clickOnWebElement(editAccountPage.getSaveChanging());
        InitPages.waitUntilVisible(editAccountPage.getChangedMessage());
    }

    @And("changes street to (.*) and house number to (.*)")
    public void changesStreetToStreetAndHouseNumberToHouseNumber(String street, String houseNumber) {
        InitPages.clickOnWebElement(editAccountPage.getChangeAddress());
        InitPages.sendKeys(editAccountPage.getStreetField(), street);
        InitPages.sendKeys(editAccountPage.getHouseNumber(), houseNumber);
    }

    @And("zip code to (.*) and city to (.*) and presses save button")
    public void zipCodeToZipCodeAndCityToCityAndPressesSaveButton(String zipCode, String city) {
        InitPages.sendKeys(editAccountPage.getZipCodeField(), zipCode);
        InitPages.sendKeys(editAccountPage.getCityField(), city);
        InitPages.clickOnWebElement(editAccountPage.getSaveChanging());
        InitPages.waitUntilVisible(editAccountPage.getChangedMessage());
    }

    @Then("changed (.*) and (.*) name,(.*),(.*),(.*)")
    public void changedFirstAndLastNameStreetHouseNumberZipCode(String first, String last, String street, String houseNumber, String zipCode) {
        InitPages.webElementContainsText(first, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(last, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(street, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(houseNumber, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(zipCode, editAccountPage.getEditedSection());

    }

    @And("(.*) are displayed in Edit Account page")
    public void cityAreDisplayedInEditAccountPage(String city) {
        InitPages.webElementContainsText(city, editAccountPage.getEditedSection());
    }
}

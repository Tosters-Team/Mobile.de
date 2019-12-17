package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Helper;
import org.junit.Assert;
import pageObjects.*;
import utils.Reflection;
import utils.ScreenShotUtil;


import static utils.PropertyConfigurator.getProperty;

public class StepsArtur {


    private HeaderGeneral headerGeneral = new HeaderGeneral();
    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch();
    private LoginPage loginPage = new LoginPage();
    private QuickTruckSearch quickTruckSearch = new QuickTruckSearch();
    private EditAccountPage editAccountPage = new EditAccountPage();
    private CarListPage carListPage = new CarListPage();

    @Given("Mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglish() throws Exception {
        InitPages.clickOnWebElement(headerGeneral.getGermanLanguage());
        InitPages.clickOnWebElement(headerGeneral.getEnglishLanguage());
        InitPages.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @When("User selects (.*) in Make drop-down")
    public void UserSelectsMakeInMakeDropDown(String make) throws Exception {
        InitPages.clickOnWebElement(homePageQuickSearch.getWebElementByName(make));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("selects (.*) in Model drop-down")
    public void selectsModelInModelDropDown(String model) throws Exception {
        InitPages.clickOnWebElement(homePageQuickSearch.getWebElementByName(model));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("selects price up to (.*)")
    public void selectsPriceUpToPrice(String price) throws Exception {
        InitPages.sendKeys(homePageQuickSearch.getPriceUpTo(), price);
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("clicks on Search button")
    public void clicksOnSearchButton() throws Exception {
        InitPages.clickOnWebElement(homePageQuickSearch.getSearchButton());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws Exception {
        Assert.assertTrue(Helper.getRandomCar(carListPage.getListAnnouncement()).getText().contains(make));
        Assert.assertTrue(Helper.getRandomCar(carListPage.getListAnnouncement()).getText().contains(model));
        Assert.assertTrue(Helper.returnsIntFromParsedString(Helper.getRandomCar(carListPage.getListPrices()).getText()) <= Helper.returnsIntFromParsedString(price));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Given("Login page is opened")
    public void loginPageIsOpened() throws Exception {
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @When("User provide valid credentials Email and Password")
    public void UserProvideValidCredentialsEmailPassword() throws Exception {
        InitPages.sendKeys(loginPage.getEMailField(), "vangartur@gmail.com");
        InitPages.sendKeys(loginPage.getPasswordField(), "Artiq!23");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("clicks on Log in Button")
    public void clicksOnLogInButton() throws Exception {
        InitPages.clickOnWebElement(loginPage.getLoginButton());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("User was successfully logged in")
    public void UserWasSuccessfullyLoggedIn() throws Exception {
        InitPages.webElementContainsText("MyMobile.de", headerGeneral.getMyMobileDeDropDown());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("pop-up message about invalid credentials is displayed")
    public void popUpMessageAboutInvalidCredentialsIsDisplayed() throws Exception {
        InitPages.waitUntilVisible(loginPage.getNotValidCredentials());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @When("User provides invalid credentials Email and Password")
    public void userProvidesInvalidCredentialsEmailAndPassword() throws Exception {
        InitPages.sendKeys(loginPage.getEMailField(), "sdfsdfs@sadas.dsad");
        InitPages.sendKeys(loginPage.getPasswordField(), "asdadad");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @When("User selects Truck category")
    public void userSelectsCategory() throws Exception {
        InitPages.clickOnWebElement(homePageQuickSearch.getTruckTab());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("Truck category page is displayed")
    public void truckCategoryPageIsDisplayed() throws Exception {
        InitPages.waitUntilVisible(quickTruckSearch.getQuickTruckPageHeader());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @When("User selects (.*) category on Quick Truck Search")
    public void userSelectsCategoryCategory(String category) throws Exception {
        InitPages.clickOnWebElement(quickTruckSearch.getWebElementByName(category));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("detailed search of that (.*) is displayed")
    public void detailedSearchOfThatCategoryIsDisplayed(String category) throws Exception {
        InitPages.waitUntilVisible(quickTruckSearch.getGeneralTrucksCategoryHeader());
        InitPages.webElementContainsText(category, quickTruckSearch.getGeneralTrucksCategoryHeader());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @And("Edit Account page is opened")
    public void editAccountPageIsOpened() throws Exception {
        InitPages.clickOnWebElement(headerGeneral.getMyCarParkButton());
        InitPages.clickOnWebElement(headerGeneral.getMyMobileDeDropDown());
        InitPages.clickOnWebElement(headerGeneral.getEditAccountOption());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @When("User changes (.*) and (.*) name and presses save button")
    public void userChangesFirstAndLastNameAndPressesSaveButton(String first, String last) throws Exception {
        InitPages.waitUntilVisible(editAccountPage.getEditedSection());
        InitPages.clickOnWebElement(editAccountPage.getChangeName());
        InitPages.sendKeys(editAccountPage.getFirstNameField(), first);
        InitPages.sendKeys(editAccountPage.getLastNameField(), last);
        InitPages.clickOnWebElement(editAccountPage.getSaveChanging());
        InitPages.waitUntilVisible(editAccountPage.getChangedMessage());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("changes street to (.*) and house number to (.*)")
    public void changesStreetToStreetAndHouseNumberToHouseNumber(String street, String houseNumber) throws Exception {
        InitPages.clickOnWebElement(editAccountPage.getChangeAddress());
        InitPages.sendKeys(editAccountPage.getStreetField(), street);
        InitPages.sendKeys(editAccountPage.getHouseNumber(), houseNumber);
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("zip code to (.*) and city to (.*) and presses save button")
    public void zipCodeToZipCodeAndCityToCityAndPressesSaveButton(String zipCode, String city) throws Exception {
        InitPages.sendKeys(editAccountPage.getZipCodeField(), zipCode);
        InitPages.sendKeys(editAccountPage.getCityField(), city);
        InitPages.clickOnWebElement(editAccountPage.getSaveChanging());
        InitPages.waitUntilVisible(editAccountPage.getChangedMessage());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("changed (.*) and (.*) name,(.*),(.*),(.*)")
    public void changedFirstAndLastNameStreetHouseNumberZipCode(String first, String last, String street, String houseNumber, String zipCode) throws Exception {
        InitPages.webElementContainsText(first, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(last, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(street, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(houseNumber, editAccountPage.getEditedSection());
        InitPages.webElementContainsText(zipCode, editAccountPage.getEditedSection());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @And("(.*) are displayed in Edit Account page")
    public void cityAreDisplayedInEditAccountPage(String city) throws Exception {
        InitPages.webElementContainsText(city, editAccountPage.getEditedSection());
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("User was successfully logged into account")
    public void UserWasSuccessfullyLoggedIntoAccount() throws Exception {
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
        InitPages.sendKeys(loginPage.getEMailField(), getProperty("EMAIL"));
        InitPages.sendKeys(loginPage.getPasswordField(), getProperty("PASSWORD"));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}

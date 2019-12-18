//package stepDefinitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import actions.Helper;
//import org.junit.Assert;
//import pageObjects.*;
//import utils.ScreenShotUtil;
//
//
//import static utils.PropertyConfigurator.getProperty;
//
//public class StepsArtur {
//
//
//    private HeaderGeneral headerGeneral = new HeaderGeneral();
//    private HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch();
//    private LoginPage loginPage = new LoginPage();
//    private QuickTruckSearch quickTruckSearch = new QuickTruckSearch();
//    private EditAccountPage editAccountPage = new EditAccountPage();
//    private CarListPage carListPage = new CarListPage();
//
//    @Given("Mobile de is opened and language changed to English")
//    public void mobileDeIsOpenedAndLanguageChangedToEnglish() throws Exception {
//        Page.clickOnWebElement(headerGeneral.getGermanLanguage());
//        Page.clickOnWebElement(headerGeneral.getEnglishLanguage());
//        Page.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @When("User selects (.*) in Make drop-down")
//    public void UserSelectsMakeInMakeDropDown(String make) throws Exception {
//        Page.clickOnWebElement(homePageQuickSearch.getWebElementByName(make));
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @And("selects (.*) in Model drop-down")
//    public void selectsModelInModelDropDown(String model) throws Exception {
//        Page.clickOnWebElement(homePageQuickSearch.getWebElementByName(model));
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @And("selects price up to (.*)")
//    public void selectsPriceUpToPrice(String price) throws Exception {
//        Page.sendKeys(homePageQuickSearch.getPriceUpTo(), price);
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @And("clicks on Search button")
//    public void clicksOnSearchButton() throws Exception {
//        Page.clickOnWebElement(homePageQuickSearch.getSearchButton());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
//    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws Exception {
//        Assert.assertTrue(Helper.getRandomCar(carListPage.getListAnnouncement()).getText().contains(make));
//        Assert.assertTrue(Helper.getRandomCar(carListPage.getListAnnouncement()).getText().contains(model));
//        Assert.assertTrue(Helper.returnsIntFromParsedString(Helper.getRandomCar(carListPage.getListPrices()).getText()) <= Helper.returnsIntFromParsedString(price));
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Given("Login page is opened")
//    public void loginPageIsOpened() throws Exception {
//        Page.clickOnWebElement(headerGeneral.getLoginButton());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//
//    }
//
//    @When("User provide valid credentials Email and Password")
//    public void UserProvideValidCredentialsEmailPassword() throws Exception {
//        Page.sendKeys(loginPage.getEMailField(), "vangartur@gmail.com");
//        Page.sendKeys(loginPage.getPasswordField(), "Artiq!23");
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @And("clicks on Log in Button")
//    public void clicksOnLogInButton() throws Exception {
//        Page.clickOnWebElement(loginPage.getLoginButton());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Then("User was successfully logged in")
//    public void UserWasSuccessfullyLoggedIn() throws Exception {
//        Page.webElementContainsText("MyMobile.de", headerGeneral.getMyMobileDeDropDown());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Then("pop-up message about invalid credentials is displayed")
//    public void popUpMessageAboutInvalidCredentialsIsDisplayed() throws Exception {
//        Page.waitUntilVisible(loginPage.getNotValidCredentials());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//
//    }
//
//    @When("User provides invalid credentials Email and Password")
//    public void userProvidesInvalidCredentialsEmailAndPassword() throws Exception {
//        Page.sendKeys(loginPage.getEMailField(), "sdfsdfs@sadas.dsad");
//        Page.sendKeys(loginPage.getPasswordField(), "asdadad");
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @When("User selects Truck category")
//    public void userSelectsCategory() throws Exception {
//        Page.clickOnWebElement(homePageQuickSearch.getTruckTab());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Then("Truck category page is displayed")
//    public void truckCategoryPageIsDisplayed() throws Exception {
//        Page.waitUntilVisible(quickTruckSearch.getQuickTruckPageHeader());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @When("User selects (.*) category on Quick Truck Search")
//    public void userSelectsCategoryCategory(String category) throws Exception {
//        Page.clickOnWebElement(quickTruckSearch.getWebElementByName(category));
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Then("detailed search of that (.*) is displayed")
//    public void detailedSearchOfThatCategoryIsDisplayed(String category) throws Exception {
//        Page.waitUntilVisible(quickTruckSearch.getGeneralTrucksCategoryHeader());
//        Page.webElementContainsText(category, quickTruckSearch.getGeneralTrucksCategoryHeader());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//
//    }
//
//    @And("Edit Account page is opened")
//    public void editAccountPageIsOpened() throws Exception {
//        Page.clickOnWebElement(headerGeneral.getMyCarParkButton());
//        Page.clickOnWebElement(headerGeneral.getMyMobileDeDropDown());
//        Page.clickOnWebElement(headerGeneral.getEditAccountOption());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @When("User changes (.*) and (.*) name and presses save button")
//    public void userChangesFirstAndLastNameAndPressesSaveButton(String first, String last) throws Exception {
//        Page.waitUntilVisible(editAccountPage.getEditedSection());
//        Page.clickOnWebElement(editAccountPage.getChangeName());
//        Page.sendKeys(editAccountPage.getFirstNameField(), first);
//        Page.sendKeys(editAccountPage.getLastNameField(), last);
//        Page.clickOnWebElement(editAccountPage.getSaveChanging());
//        Page.waitUntilVisible(editAccountPage.getChangedMessage());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @And("changes street to (.*) and house number to (.*)")
//    public void changesStreetToStreetAndHouseNumberToHouseNumber(String street, String houseNumber) throws Exception {
//        Page.clickOnWebElement(editAccountPage.getChangeAddress());
//        Page.sendKeys(editAccountPage.getStreetField(), street);
//        Page.sendKeys(editAccountPage.getHouseNumber(), houseNumber);
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @And("zip code to (.*) and city to (.*) and presses save button")
//    public void zipCodeToZipCodeAndCityToCityAndPressesSaveButton(String zipCode, String city) throws Exception {
//        Page.sendKeys(editAccountPage.getZipCodeField(), zipCode);
//        Page.sendKeys(editAccountPage.getCityField(), city);
//        Page.clickOnWebElement(editAccountPage.getSaveChanging());
//        Page.waitUntilVisible(editAccountPage.getChangedMessage());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Then("changed (.*) and (.*) name,(.*),(.*),(.*)")
//    public void changedFirstAndLastNameStreetHouseNumberZipCode(String first, String last, String street, String houseNumber, String zipCode) throws Exception {
//        Page.webElementContainsText(first, editAccountPage.getEditedSection());
//        Page.webElementContainsText(last, editAccountPage.getEditedSection());
//        Page.webElementContainsText(street, editAccountPage.getEditedSection());
//        Page.webElementContainsText(houseNumber, editAccountPage.getEditedSection());
//        Page.webElementContainsText(zipCode, editAccountPage.getEditedSection());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//
//    }
//
//    @And("(.*) are displayed in Edit Account page")
//    public void cityAreDisplayedInEditAccountPage(String city) throws Exception {
//        Page.webElementContainsText(city, editAccountPage.getEditedSection());
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//    @Then("User was successfully logged into account")
//    public void UserWasSuccessfullyLoggedIntoAccount() throws Exception {
//        Page.clickOnWebElement(headerGeneral.getLoginButton());
//        Page.sendKeys(loginPage.getEMailField(), getProperty("EMAIL"));
//        Page.sendKeys(loginPage.getPasswordField(), getProperty("PASSWORD"));
//        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//
//}

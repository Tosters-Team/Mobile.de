package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_old.Ac;
import methods.Action;
import org.junit.Assert;
import pageObjects.*;
import static pageObjects.InitPages.*;
import static stepDefinitions.Hooks.driver;
public class StepsMihail {

    HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch(driver);
    DetailedCarSearchPage detailedCarSearchPage = new DetailedCarSearchPage(driver);
    BackupCarListPage backupCarListPage = new BackupCarListPage(driver);

    @Given("Mobile.de website is accessed and the language is set to english")
    public void mobileDeWebsiteIsAccessedAndTheLanguageIsSetToEnglish() {
        Action.clickOnWebElement(headerGeneral.getGermanLanguage());
        Action.clickOnWebElement(headerGeneral.getEnglishLanguage());
        Action.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @Given("user accessed Detailed Search page")
    public void userAccessedDetailedSearchPage() {
        Action.clickOnWebElement(homePageQuickSearch.getDetailedSearch());
        Action.waitUntilVisible(detailedCarSearchPage.getPageHeader());
        Action.webElementContainsText("Detailed search: Cars – new or used", detailedCarSearchPage.getPageHeader());
    }

    @When("user selects vehicle's (.*) in condition category")
    public void userSelectsVehicleSCondition(String condition) {
        Action.clickOnWebElement(detailedCarSearchPage.getCondition(condition));
    }

    @And("user selects (.*) and (.*) in make, model, variant category")
    public void userSelectsVehicleSMakeAndModel(String make, String model) {
        Action.clickOnWebElement(detailedCarSearchPage.getMake());
        Action.sendKeys(detailedCarSearchPage.getMake(), make);
        Action.clickOnWebElement(detailedCarSearchPage.getMake());
        Action.clickOnWebElement(detailedCarSearchPage.getModel());
        Action.sendKeys(detailedCarSearchPage.getModel(), model);
        Action.clickOnWebElement(detailedCarSearchPage.getModel());
    }

    @And("user selects (.*) in vehicle type category")
    public void userSelectsVehicleSType(String type) {
        Action.clickOnWebElement(detailedCarSearchPage.getVehicleType(type));

    }

    @And("user selects (.*) and (.*) in price range category")
    public void userSelectsPriceRange(String priceFrom, String priceTo) {
        Action.sendKeys(detailedCarSearchPage.getPriceFrom(), priceFrom);
        Action.sendKeys(detailedCarSearchPage.getPriceTo(), priceTo);
    }

    @And("user selects vehicle's registration range (.*) and (.*)")
    public void userSelectsVehicleSRegistrationRangeFromYearAndToYear(String yearFrom, String yearTo) {
        Action.sendKeys(detailedCarSearchPage.getFirstRegistrationFrom(), yearFrom);
        Action.sendKeys(detailedCarSearchPage.getFirstRegistrationTo(), yearTo);
    }

    @And("user selects vehicle's mileage range (.*) and (.*)")
    public void userSelectsVehicleSMileageRangeFromKmsAndToKms(String kmsFrom, String kmsTo) {
        Action.sendKeys(detailedCarSearchPage.getKilometerFrom(), kmsFrom);
        Action.sendKeys(detailedCarSearchPage.getKilometerTo(), kmsTo);
    }

    @And("user selects (.*) and (.*) and clicks on Show offers button")
    public void userSelectsVehicleSFuel_typeAndTransmissionAndClickOnShowOffersButton(String fuelType, String transmission) {
        Action.clickOnWebElement(detailedCarSearchPage.getFuelType(fuelType));
        Action.clickOnWebElement(detailedCarSearchPage.getTranmissionType(transmission));
        Action.clickOnWebElement(detailedCarSearchPage.getShowOffersButton());
    }

    @Then("Available offers page is displaying containing vehicles that match the search criteria")
    public void availableOffersPageIsDisplayingContainingVehiclesThatMachTheSearchCriteria() throws InterruptedException {
        Thread.sleep(5000);
        Action.clickOnWebElement(backupCarListPage.getRandomCar());


        Thread.sleep(5000);
    }
    //---------------------------------------------------------------------------------------------------------------------
    LoginPage loginPage = new LoginPage(driver);
    SellPage sellPage = new SellPage(driver);

    @Given("user has logged in and accessed Sell page")
    public void userHasLoggedInAndAccessedSellPage() {
        Action.clickOnWebElement(headerGeneral.getLoginButton());
        Action.waitUntilVisible(loginPage.getEMailField());
        Action.sendKeys(loginPage.getEMailField(), "trifonovmihail@mail.ru");
        Action.sendKeys(loginPage.getPasswordField(), "Mobile.De629");
        Action.clickOnWebElement(loginPage.getLoginButton());
        Action.clickOnWebElement(homePageQuickSearch.getSellTab());
    }

    @When("user enters the (.*) and (.*) of his vehicle")
    public void userEntersTheMakeAndModelOfHisVehicle(String brand, String model) {
        Action.waitUntilVisible(sellPage.getBrand());
        Action.clickOnWebElement(sellPage.getBrand());
        Action.sendKeys(sellPage.getBrand(), brand);
        Action.clickOnWebElement(sellPage.getBrand());
        Action.clickOnWebElement(sellPage.getModel());
        Action.sendKeys(sellPage.getModel(), model);
        Action.clickOnWebElement(sellPage.getModel());
    }

    @And("enters (.*) and (.*) of first registration")
    public void entersYearAndMonthOfFirstRegistration(String year, String month) {
        Action.waitUntilVisible(sellPage.getFirstRegistrationYear());
        Action.clickOnWebElement(sellPage.getFirstRegistrationYear());
        Action.sendKeys(sellPage.getFirstRegistrationYear(), year);
        Action.clickOnWebElement(sellPage.getFirstRegistrationYear());
        Action.waitUntilVisible(sellPage.getGetFirstRegistrationMonth());
        Action.clickOnWebElement(sellPage.getGetFirstRegistrationMonth());
        Action.sendKeys(sellPage.getGetFirstRegistrationMonth(), month);
        Action.clickOnWebElement(sellPage.getGetFirstRegistrationMonth());
    }

    @And("enters the mileage (.*) and (.*)")
    public void entersTheMileageKMsAndFuelType(String mileage, String fuelType) {
        Action.waitUntilVisible(sellPage.getMileage());
        Action.clickOnWebElement(sellPage.getMileage());
        Action.sendKeys(sellPage.getMileage(), mileage);
        Action.clickOnWebElement(sellPage.getMileage());
        Action.waitUntilVisible(sellPage.getFuelType(fuelType));
        Action.clickOnWebElement(sellPage.getFuelType(fuelType));
    }

    @And("enters model (.*) and (.*) level")
    public void entersModelDescriptionAndEquipmentLevel(String option, String trim) throws InterruptedException {
        Action.waitUntilVisible(sellPage.getModelDescriptionDropDown());
        Action.waitUntilClickable(sellPage.getModelDescriptionDropDown());
        Action.clickOnWebElement(sellPage.getModelDescriptionDropDown());
        Action.clickOnWebElement(sellPage.getModelDescriptionOption(option));
        Thread.sleep(5000);
        Action.waitUntilVisible(sellPage.getEquipmentLevelOption(trim));
        Action.waitUntilClickable(sellPage.getEquipmentLevelOption(trim));
        Action.clickOnWebElement(sellPage.getEquipmentLevelOption(trim));
    }

    @And("user chooses (.*) and enters (.*) and clicks on continue button")
    public void userChoosesSelling_planAndEntersZip_codeAndClicksOnContinueButton(String sellOption, String zip) throws InterruptedException {
        Action.waitUntilClickable(sellPage.getWhenToSellOption(sellOption));
        Thread.sleep(5000);
        Action.clickOnWebElement(sellPage.getWhenToSellOption(sellOption));
        Action.sendKeys(sellPage.getZipCode(), zip);
        Thread.sleep(10000);
        Action.clickOnWebElement(sellPage.getContinueButton());
    }

    @Then("user is redirected to results page where he can see the price of his car (.*)")
    public void userIsRedirectedToResultsPageWhereHeCanSeeThePriceOfHisCar(String brand) throws InterruptedException {
        Action.waitUntilVisible(sellPage.getSellYourVehicleText());
        Action.webElementContainsText(brand, sellPage.getSellYourVehicleText());
        Assert.assertTrue(sellPage.getPrice().isDisplayed());
        Thread.sleep(10000);
    }

    //---------------------------------------------------------------------------------------------------------------------
    SidePanelSearchPage sidePanelSearchPage = new SidePanelSearchPage(driver);

    @Given("user accessed car list page without entering any search criteria")
    public void userAccessedCarListPageWithoutEnteringAnySearchCriteria() throws InterruptedException {
        Action.clickOnWebElement(homePageQuickSearch.getSearchButton());
        System.out.println("Given");
        Thread.sleep(5000);
    }

    @When("user changes from (.*) one of the vehicle's (.*)  to desired one")
    public void userChangesOneOfTheVehicleSOptionToDesiredOne(String optionType, String option) throws InterruptedException {
        Action.sendKeys(sidePanelSearchPage.getOptionType(optionType), option);
        Action.clickOnWebElement(sidePanelSearchPage.getShowOffersGeneralButton());
        System.out.println("1st When");
        Thread.sleep(5000);
    }

    @Then("the (.*) appears on top of cars list")
    public void theOptionAppearsOnTopOfCarsList(String option) throws InterruptedException {
        Action.webElementContainsText(option, sidePanelSearchPage.getDisplayedOption());
        System.out.println("1st Then");
        Thread.sleep(5000);
    }

    @When("user clicks on close button of the option")
    public void userClicksOnCloseButtonOfTheOption() throws InterruptedException {
        Action.clickOnWebElement(sidePanelSearchPage.getCloseDisplayedOption());
        System.out.println("2nd When");
        Thread.sleep(5000);
    }

    @Then("the option disappears")
    public void theOptionDisappears() throws InterruptedException {
        try {
            Assert.assertTrue(!sidePanelSearchPage.getDisplayedOption().isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.assertTrue(true);
        }

        System.out.println("2nd Then");
        Thread.sleep(5000);

    }
}

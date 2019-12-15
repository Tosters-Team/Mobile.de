package stepDefinitions;

import com.sun.org.apache.xml.internal.security.Init;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_old.Ac;
import methods.Action;
import org.hamcrest.MatcherAssert;
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
        InitPages.clickOnWebElement(headerGeneral.getGermanLanguage());
        InitPages.clickOnWebElement(headerGeneral.getEnglishLanguage());
        InitPages.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @Given("user accessed Detailed Search page")
    public void userAccessedDetailedSearchPage() {
        InitPages.clickOnWebElement(homePageQuickSearch.getDetailedSearch());
        Action.waitUntilVisible(detailedCarSearchPage.getPageHeader());
        InitPages.webElementContainsText("Detailed search: Cars – new or used", detailedCarSearchPage.getPageHeader());
    }

    @When("user chooses desired (.*) in condition category on detailed search page")
    public void userSelectsVehicleSConditionOnDetailedSearchPage(String condition) {
        InitPages.clickOnWebElement(detailedCarSearchPage.getCondition(condition));
    }

    @And("user chooses (.*) and (.*) in make, model, variant category")
    public void userSelectsVehicleSMakeAndModel(String make, String model) {
        InitPages.clickOnWebElement(detailedCarSearchPage.getMake());
        Action.sendKeys(detailedCarSearchPage.getMake(), make);
        InitPages.clickOnWebElement(detailedCarSearchPage.getMake());
        InitPages.clickOnWebElement(detailedCarSearchPage.getModel());
        Action.sendKeys(detailedCarSearchPage.getModel(), model);
        InitPages.clickOnWebElement(detailedCarSearchPage.getModel());
    }

    @And("user chooses (.*) in vehicle type category")
    public void userSelectsVehicleSType(String type) {
        InitPages.clickOnWebElement(detailedCarSearchPage.getVehicleType(type));

    }

    @And("user chooses (.*) and (.*) in price range category")
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
        InitPages.clickOnWebElement(detailedCarSearchPage.getFuelType(fuelType));
        InitPages.clickOnWebElement(detailedCarSearchPage.getTranmissionType(transmission));
        InitPages.clickOnWebElement(detailedCarSearchPage.getShowOffersButton());
    }

    @And("user chooses a random car from car list page")
    public void userChoosesARandomCarFromCarListPage() {
        InitPages.clickOnWebElement(backupCarListPage.getRandomCar());
    }

    @Then("chosen cars options: (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) match search criteria")
    public void availableOffersPageIsDisplayingContainingVehiclesThatMachTheSearchCriteria(String make, String type,
                String min_price, String max_price, String fromYear, String toYear, String fromKms, String toKms,
                String fuel_type, String transmission) throws InterruptedException {
        Thread.sleep(5000);
        InitPages.webElementContainsText(make, selectedCarPage.getBrandModel());
        InitPages.webElementContainsText(type, selectedCarPage.getBrandModel());
        InitPages.webElementContainsText(transmission, selectedCarPage.getTransmission());
        InitPages.webElementContainsText(fuel_type, selectedCarPage.getFuel());
        Assert.assertTrue(selectedCarPage.getActualPrice()>=InitPages.getPriceForComparison(min_price));
        Assert.assertTrue(selectedCarPage.getActualPrice()<=InitPages.getPriceForComparison(max_price));
        Assert.assertTrue(selectedCarPage.getActualYear()>=InitPages.getYearForComparison(fromYear));
        Assert.assertTrue(selectedCarPage.getActualYear()<=InitPages.getYearForComparison(toYear));
        Assert.assertTrue(selectedCarPage.getActualMileage()>=InitPages.getMileageForComparisson(fromKms));
        Assert.assertTrue(selectedCarPage.getActualMileage()>=InitPages.getMileageForComparisson(fromKms));

    }
    //---------------------------------------------------------------------------------------------------------------------
    LoginPage loginPage = new LoginPage(driver);
    SellPage sellPage = new SellPage(driver);

    @Given("user has logged in and accessed Sell page")
    public void userHasLoggedInAndAccessedSellPage() {
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
        Action.waitUntilVisible(loginPage.getEMailField());
        Action.sendKeys(loginPage.getEMailField(), "trifonovmihail@mail.ru");
        Action.sendKeys(loginPage.getPasswordField(), "Mobile.De629");
        InitPages.clickOnWebElement(loginPage.getLoginButton());
        InitPages.clickOnWebElement(homePageQuickSearch.getSellTab());
    }

    @When("user enters the (.*) and (.*) of his vehicle")
    public void userEntersTheMakeAndModelOfHisVehicle(String brand, String model) throws InterruptedException {
        Action.waitUntilVisible(sellPage.getBrand());
        InitPages.clickOnWebElement(sellPage.getBrand());
        Action.sendKeys(sellPage.getBrand(), brand);
        InitPages.clickOnWebElement(sellPage.getBrand());
        Thread.sleep(5000);
        InitPages.clickOnWebElement(sellPage.getModel());
        Action.sendKeys(sellPage.getModel(), model);
        InitPages.clickOnWebElement(sellPage.getModel());
    }

    @And("enters (.*) and (.*) of first registration")
    public void entersYearAndMonthOfFirstRegistration(String year, String month) {
        Action.waitUntilVisible(sellPage.getFirstRegistrationYear());
        InitPages.clickOnWebElement(sellPage.getFirstRegistrationYear());
        Action.sendKeys(sellPage.getFirstRegistrationYear(), year);
        InitPages.clickOnWebElement(sellPage.getFirstRegistrationYear());
        Action.waitUntilVisible(sellPage.getGetFirstRegistrationMonth());
        InitPages.clickOnWebElement(sellPage.getGetFirstRegistrationMonth());
        Action.sendKeys(sellPage.getGetFirstRegistrationMonth(), month);
        InitPages.clickOnWebElement(sellPage.getGetFirstRegistrationMonth());
    }

    @And("enters the mileage (.*) and (.*)")
    public void entersTheMileageKMsAndFuelType(String mileage, String fuelType) {
        Action.waitUntilVisible(sellPage.getMileage());
        InitPages.clickOnWebElement(sellPage.getMileage());
        Action.sendKeys(sellPage.getMileage(), mileage);
        InitPages.clickOnWebElement(sellPage.getMileage());
        Action.waitUntilVisible(sellPage.getFuelType(fuelType));
        InitPages.clickOnWebElement(sellPage.getFuelType(fuelType));
    }

    @And("enters model (.*) and (.*) level")
    public void entersModelDescriptionAndEquipmentLevel(String option, String trim) throws InterruptedException {
        Action.waitUntilVisible(sellPage.getModelDescriptionDropDown());
        Action.waitUntilClickable(sellPage.getModelDescriptionDropDown());
        InitPages.clickOnWebElement(sellPage.getModelDescriptionDropDown());
        InitPages.clickOnWebElement(sellPage.getModelDescriptionOption(option));
        Thread.sleep(5000);
        Action.waitUntilVisible(sellPage.getEquipmentLevelOption(trim));
        Action.waitUntilClickable(sellPage.getEquipmentLevelOption(trim));
        InitPages.clickOnWebElement(sellPage.getEquipmentLevelOption(trim));
    }

    @And("user chooses (.*) and enters (.*) and clicks on continue button")
    public void userChoosesSelling_planAndEntersZip_codeAndClicksOnContinueButton(String sellOption, String zip) throws InterruptedException {
        Action.waitUntilClickable(sellPage.getWhenToSellOption(sellOption));
        Thread.sleep(5000);
        InitPages.clickOnWebElement(sellPage.getWhenToSellOption(sellOption));
        Action.sendKeys(sellPage.getZipCode(), zip);
        Thread.sleep(10000);
        InitPages.clickOnWebElement(sellPage.getContinueButton());
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
        InitPages.clickOnWebElement(homePageQuickSearch.getSearchButton());
        System.out.println("Given");
        Thread.sleep(5000);
    }

    @When("user changes from (.*) one of the vehicle's (.*)  to desired one")
    public void userChangesOneOfTheVehicleSOptionToDesiredOne(String optionType, String option) throws InterruptedException {
        Action.sendKeys(sidePanelSearchPage.getOptionType(optionType), option);
        InitPages.clickOnWebElement(sidePanelSearchPage.getShowOffersGeneralButton());
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
        InitPages.clickOnWebElement(sidePanelSearchPage.getCloseDisplayedOption());
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

    //---------------------------------------------------------------------------------------------------------------------
    SelectedCarPage selectedCarPage = new SelectedCarPage(driver);
    @And("user pressed Show Offers Button and was redirected to car list page")
    public void userPressedShowOffersButtonAndWasRedirectedToCarListPage() {
        InitPages.clickOnWebElement(detailedCarSearchPage.getShowOffersButton());
        InitPages.webElementContainsText("Used cars", backupCarListPage.getHeaderMessage());
    }


    @When("user selects from sorting drop down (.*)")
    public void userSelectsSortingOption(String sortingOption) {
        InitPages.clickOnWebElement(backupCarListPage.getSortingDropDown());
        Action.sendKeys(backupCarListPage.getSortingDropDown(), sortingOption);
        InitPages.clickOnWebElement(backupCarListPage.getSortingDropDown());
    }

    @Then("cars are sorted according to selected (.*)")
    public void carsAreSortedAccordingToSelectedOption(String sortingOption) throws InterruptedException {
        int firstCarOption, lastCarOption;
        switch (sortingOption){
            case "Price ascending":
                InitPages.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
                firstCarOption = selectedCarPage.getActualPrice();
                driver.navigate().back();
                Thread.sleep(5000);
                InitPages.clickOnWebElement(backupCarListPage.getLastCarOnPage());
                Thread.sleep(5000);
                lastCarOption = selectedCarPage.getActualPrice();
                Assert.assertTrue(firstCarOption<lastCarOption);
                break;
            case "Price descending":
                InitPages.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
                firstCarOption = selectedCarPage.getActualPrice();
                driver.navigate().back();
                Thread.sleep(5000);
                InitPages.clickOnWebElement(backupCarListPage.getLastCarOnPage());
                Thread.sleep(5000);
                lastCarOption = selectedCarPage.getActualPrice();
                Assert.assertTrue(firstCarOption>lastCarOption);
                break;
            case "KM ascending":
                InitPages.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
                firstCarOption = selectedCarPage.getActualMileage();
                driver.navigate().back();
                Thread.sleep(5000);
                InitPages.clickOnWebElement(backupCarListPage.getLastCarOnPage());
                Thread.sleep(5000);
                lastCarOption = selectedCarPage.getActualPrice();
                Assert.assertTrue(firstCarOption<lastCarOption);
                break;
            case "KM descending":
                InitPages.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
                firstCarOption = selectedCarPage.getActualMileage();
                driver.navigate().back();
                Thread.sleep(5000);
                InitPages.clickOnWebElement(backupCarListPage.getLastCarOnPage());
                Thread.sleep(5000);
                lastCarOption = selectedCarPage.getActualPrice();
                Assert.assertTrue(firstCarOption>lastCarOption);
                break;
            case "1st Reg. ascending":
                InitPages.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
                firstCarOption = selectedCarPage.getActualDate();
                driver.navigate().back();
                Thread.sleep(5000);
                InitPages.clickOnWebElement(backupCarListPage.getLastCarOnPage());
                Thread.sleep(5000);
                lastCarOption = selectedCarPage.getActualDate();
                Assert.assertTrue(firstCarOption<lastCarOption);
                break;
            case "1st Reg. descending":
                InitPages.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
                firstCarOption = selectedCarPage.getActualDate();
                driver.navigate().back();
                Thread.sleep(5000);
                InitPages.clickOnWebElement(backupCarListPage.getLastCarOnPage());
                Thread.sleep(5000);
                lastCarOption = selectedCarPage.getActualDate();
                Assert.assertTrue(firstCarOption>lastCarOption);
                break;
        }

    }

    //--------------------------------------------------------------------------------------------------------------------
    MySearchesPage mySearchesPage = new MySearchesPage(driver);
    @Given("user is logged in on Mobile.de")
    public void userIsLoggedInOnMobileDe() {
        InitPages.clickOnWebElement(headerGeneral.getLoginButton());
        Action.waitUntilVisible(loginPage.getEMailField());
        Action.sendKeys(loginPage.getEMailField(), "trifonovmihail@mail.ru");
        Action.sendKeys(loginPage.getPasswordField(), "Mobile.De629");
        InitPages.clickOnWebElement(loginPage.getLoginButton());
    }

    @And("My search page is empty")
    public void mySearchPageIsEmpty() {
        InitPages.clickOnWebElement(headerGeneral.getMySearchesButton());
        InitPages.clickOnWebElement(headerGeneral.getShowMySearches());
        try {
            InitPages.clickOnWebElement(mySearchesPage.getDeleteSearch());
        } catch (org.openqa.selenium.NoSuchElementException e) {}

        try {
            InitPages.webElementContainsText("You have not saved any search requests", mySearchesPage.getEmptySearch());
        } catch (org.openqa.selenium.NoSuchElementException e) {}
        InitPages.clickOnWebElement(headerGeneral.getMobileDeLogo());
    }

    @And("user saves current search by clicking on Save search button and following option on pop-up")
    public void userSavesCurrentSearchByClickingOnSaveSearchButtonAndFollowingOptionOnPopUp() {
        InitPages.clickOnWebElement(backupCarListPage.getSaveSearchButton());
        //InitPages.clickOnWebElement(backupCarListPage.getEmailNotificationCheckBox());
        InitPages.clickOnWebElement(backupCarListPage.getSaveSearchOnPopUp());

    }

    @Then("the Search is saved in My searches")
    public void theSearchIsSavedInMySearches() {
        InitPages.clickOnWebElement(headerGeneral.getMySearchesButton());
        InitPages.clickOnWebElement(headerGeneral.getShowMySearches());
        Assert.assertTrue(mySearchesPage.getDeleteSearch().isDisplayed());

    }

    @And("by clicking on the Saved search user is redirected on car results page")
    public void byClickingOnTheSavedSearchUserIsRedirectedOnCarResultsPage() {
        InitPages.clickOnWebElement(mySearchesPage.getShowSavedSearch());
        InitPages.webElementContainsText("Used cars", backupCarListPage.getHeaderMessage());


    }

    @And("filters (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) match the original search")
    public void filtersConditionMakeModelMin_priceMax_priceFromYearToYearFromKmsToKmsMatchTheOriginalSearch(String condition,
                            String make, String model, String min_price, String max_price, String fromYear, String toYear,
                            String fromKms, String toKms) {
        InitPages.webElementContainsText(make, backupCarListPage.getSavedSearchFilter(0));
        InitPages.webElementContainsText(model, backupCarListPage.getSavedSearchFilter(0));
        InitPages.webElementContainsText(min_price, backupCarListPage.getSavedSearchFilter(5));
        InitPages.webElementContainsText(max_price, backupCarListPage.getSavedSearchFilter(6));
        InitPages.webElementContainsText(fromYear, backupCarListPage.getSavedSearchFilter(3));
        InitPages.webElementContainsText(toYear, backupCarListPage.getSavedSearchFilter(4));
        InitPages.webElementContainsText(fromYear, backupCarListPage.getSavedSearchFilter(1));
        InitPages.webElementContainsText(toKms, backupCarListPage.getSavedSearchFilter(2));

    }


}

//package stepDefinitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import actions.Action;
//import org.junit.Assert;
//import pageObjects.*;
//
//import static stepDefinitions.Hooks.driver;
//public class StepsMihail {
//
//    HeaderGeneral headerGeneral = new HeaderGeneral();
//    HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch();
//    DetailedCarSearchPage detailedCarSearchPage = new DetailedCarSearchPage();
//    BackupCarListPage backupCarListPage = new BackupCarListPage();
//
//    @Given("Mobile.de website is accessed and the language is set to English")
//    public void mobileDeWebsiteIsAccessedAndTheLanguageIsSetToEnglish() throws InterruptedException {
//        Page.clickOnWebElement(headerGeneral.getGermanLanguage());
//        Page.clickOnWebElement(headerGeneral.getEnglishLanguage());
//        Page.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
//    }
//
//    @Given("user accessed Detailed Search page")
//    public void userAccessedDetailedSearchPage() {
//        Page.clickOnWebElement(homePageQuickSearch.getDetailedSearch());
//        Action.waitUntilVisible(detailedCarSearchPage.getPageHeader());
//        Page.webElementContainsText("Detailed search: Cars – new or used", detailedCarSearchPage.getPageHeader());
//    }
//
//    @When("user chooses desired (.*) in condition category on detailed search page")
//    public void userSelectsVehicleSConditionOnDetailedSearchPage(String condition) {
//        Action.clickOnWebElement(detailedCarSearchPage.getCondition(condition));
//    }
//
//    @And("user chooses (.*) and (.*) in make, model, variant category")
//    public void userSelectsVehicleSMakeAndModel(String make, String model) {
//        Page.clickOnWebElement(detailedCarSearchPage.getMake());
//        Action.sendKeys(detailedCarSearchPage.getMake(), make);
//        Page.clickOnWebElement(detailedCarSearchPage.getMake());
//        Page.clickOnWebElement(detailedCarSearchPage.getModel());
//        Action.sendKeys(detailedCarSearchPage.getModel(), model);
//        Page.clickOnWebElement(detailedCarSearchPage.getModel());
//    }
//
//    @And("user chooses (.*) in vehicle type category")
//    public void userSelectsVehicleSType(String type) {
//        Action.clickOnWebElement(detailedCarSearchPage.getVehicleType(type));
//
//    }
//
//    @And("user chooses (.*) and (.*) in price range category")
//    public void userSelectsPriceRange(String priceFrom, String priceTo) {
//        Action.sendKeys(detailedCarSearchPage.getPriceFrom(), priceFrom);
//        Action.sendKeys(detailedCarSearchPage.getPriceTo(), priceTo);
//    }
//
//    @And("user selects vehicle's registration range (.*) and (.*)")
//    public void userSelectsVehicleSRegistrationRangeFromYearAndToYear(String yearFrom, String yearTo) {
//        Action.sendKeys(detailedCarSearchPage.getFirstRegistrationFrom(), yearFrom);
//        Action.sendKeys(detailedCarSearchPage.getFirstRegistrationTo(), yearTo);
//    }
//
//    @And("user selects vehicle's mileage range (.*) and (.*)")
//    public void userSelectsVehicleSMileageRangeFromKmsAndToKms(String kmsFrom, String kmsTo) {
//        Action.sendKeys(detailedCarSearchPage.getKilometerFrom(), kmsFrom);
//        Action.sendKeys(detailedCarSearchPage.getKilometerTo(), kmsTo);
//    }
//
//    @And("user selects (.*) and (.*) and clicks on Show offers button")
//    public void userSelectsVehicleSFuel_typeAndTransmissionAndClickOnShowOffersButton(String fuelType, String transmission) {
//        Action.clickOnWebElement(detailedCarSearchPage.getFuelType(fuelType));
//        Action.clickOnWebElement(detailedCarSearchPage.getTranmissionType(transmission));
//        Page.clickOnWebElement(detailedCarSearchPage.getShowOffersButton());
//    }
//
//    @And("user chooses a random car from car list page")
//    public void userChoosesARandomCarFromCarListPage() {
//        Page.clickOnWebElement(backupCarListPage.getRandomCar());
//    }
//
//    @Then("chosen car's options: (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) match search criteria")
//    public void availableOffersPageIsDisplayingContainingVehiclesThatMachTheSearchCriteria(String make, String type,
//                String min_price, String max_price, String fromYear, String toYear, String fromKms, String toKms,
//                String fuel_type, String transmission) throws InterruptedException {
//        Thread.sleep(5000);
//        Page.webElementContainsText(make, selectedCarPage.getBrandModel());
//        Page.webElementContainsText(type, selectedCarPage.getBrandModel());
//        Page.webElementContainsText(transmission, selectedCarPage.getTransmission());
//        Page.webElementContainsText(fuel_type, selectedCarPage.getFuel());
//        Assert.assertTrue(selectedCarPage.getActualPrice()>=Page.getPriceForComparison(min_price));
//        Assert.assertTrue(selectedCarPage.getActualPrice()<=Page.getPriceForComparison(max_price));
//        Assert.assertTrue(selectedCarPage.getActualYear()>=Page.getYearForComparison(fromYear));
//        Assert.assertTrue(selectedCarPage.getActualYear()<=Page.getYearForComparison(toYear));
//        Assert.assertTrue(selectedCarPage.getActualMileage()>=Page.getMileageForComparisson(fromKms));
//        Assert.assertTrue(selectedCarPage.getActualMileage()<=Page.getMileageForComparisson(toKms));
//
//    }
//    //---------------------------------------------------------------------------------------------------------------------
//    LoginPage loginPage = new LoginPage();
//    SellPage sellPage = new SellPage();
//
//    @Given("user has logged in and accessed Sell page")
//    public void userHasLoggedInAndAccessedSellPage() {
//        Page.clickOnWebElement(headerGeneral.getLoginButton());
//        Action.waitUntilVisible(loginPage.getEMailField());
//        Action.sendKeys(loginPage.getEMailField(), "trifonovmihail@mail.ru");
//        Action.sendKeys(loginPage.getPasswordField(), "Mobile.De629");
//        Page.clickOnWebElement(loginPage.getLoginButton());
//        Page.clickOnWebElement(homePageQuickSearch.getSellTab());
//    }
//
//    @When("user enters the (.*) and (.*) of his vehicle")
//    public void userEntersTheMakeAndModelOfHisVehicle(String brand, String model) throws InterruptedException {
//        Action.waitUntilVisible(sellPage.getBrand());
//        Page.clickOnWebElement(sellPage.getBrand());
//        Action.sendKeys(sellPage.getBrand(), brand);
//        Page.clickOnWebElement(sellPage.getBrand());
//        Thread.sleep(5000);
//        Page.clickOnWebElement(sellPage.getModel());
//        Action.sendKeys(sellPage.getModel(), model);
//        Page.clickOnWebElement(sellPage.getModel());
//    }
//
//    @And("enters (.*) and (.*) of first registration")
//    public void entersYearAndMonthOfFirstRegistration(String year, String month) {
//        Action.waitUntilVisible(sellPage.getFirstRegistrationYear());
//        Page.clickOnWebElement(sellPage.getFirstRegistrationYear());
//        Action.sendKeys(sellPage.getFirstRegistrationYear(), year);
//        Page.clickOnWebElement(sellPage.getFirstRegistrationYear());
//        Action.waitUntilVisible(sellPage.getGetFirstRegistrationMonth());
//        Page.clickOnWebElement(sellPage.getGetFirstRegistrationMonth());
//        Action.sendKeys(sellPage.getGetFirstRegistrationMonth(), month);
//        Page.clickOnWebElement(sellPage.getGetFirstRegistrationMonth());
//    }
//
//    @And("enters the mileage (.*) and (.*)")
//    public void entersTheMileageKMsAndFuelType(String mileage, String fuelType) {
//        Action.waitUntilVisible(sellPage.getMileage());
//        Page.clickOnWebElement(sellPage.getMileage());
//        Action.sendKeys(sellPage.getMileage(), mileage);
//        Page.clickOnWebElement(sellPage.getMileage());
//        Action.waitUntilVisible(sellPage.getFuelType(fuelType));
//        Page.clickOnWebElement(sellPage.getFuelType(fuelType));
//    }
//
//    @And("enters model (.*) and (.*) level")
//    public void entersModelDescriptionAndEquipmentLevel(String option, String trim) throws InterruptedException {
//        Action.waitUntilVisible(sellPage.getModelDescriptionDropDown());
//        Action.waitUntilClickable(sellPage.getModelDescriptionDropDown());
//        Page.clickOnWebElement(sellPage.getModelDescriptionDropDown());
//        Page.clickOnWebElement(sellPage.getModelDescriptionOption(option));
//        Thread.sleep(5000);
//        Action.waitUntilVisible(sellPage.getEquipmentLevelOption(trim));
//        Action.waitUntilClickable(sellPage.getEquipmentLevelOption(trim));
//        Page.clickOnWebElement(sellPage.getEquipmentLevelOption(trim));
//    }
//
//    @And("user chooses (.*) and enters (.*) and clicks on continue button")
//    public void userChoosesSelling_planAndEntersZip_codeAndClicksOnContinueButton(String sellOption, String zip) throws InterruptedException {
//        Action.waitUntilClickable(sellPage.getWhenToSellOption(sellOption));
//        Thread.sleep(5000);
//        Page.clickOnWebElement(sellPage.getWhenToSellOption(sellOption));
//        Action.sendKeys(sellPage.getZipCode(), zip);
//        Thread.sleep(10000);
//        Page.clickOnWebElement(sellPage.getContinueButton());
//    }
//
//    @Then("user is redirected to results page where he can see the price of his car (.*)")
//    public void userIsRedirectedToResultsPageWhereHeCanSeeThePriceOfHisCar(String brand) throws InterruptedException {
//        Action.waitUntilVisible(sellPage.getSellYourVehicleText());
//        Action.webElementContainsText(brand, sellPage.getSellYourVehicleText());
//        Assert.assertTrue(sellPage.getPrice().isDisplayed());
//        Thread.sleep(10000);
//    }
//
//    //---------------------------------------------------------------------------------------------------------------------
//    SidePanelSearchPage sidePanelSearchPage = new SidePanelSearchPage();
//
//    @Given("user accessed car list page without entering any search criteria")
//    public void userAccessedCarListPageWithoutEnteringAnySearchCriteria() throws InterruptedException {
//        Page.clickOnWebElement(homePageQuickSearch.getSearchButton());
//        System.out.println("Given");
//        Thread.sleep(5000);
//    }
//
//    @When("user changes from (.*) one of the vehicle's (.*)  to desired one")
//    public void userChangesOneOfTheVehicleSOptionToDesiredOne(String optionType, String option) throws InterruptedException {
//        Action.sendKeys(sidePanelSearchPage.getOptionType(optionType), option);
//        Page.clickOnWebElement(sidePanelSearchPage.getShowOffersGeneralButton());
//        System.out.println("1st When");
//        Thread.sleep(5000);
//    }
//
//    @Then("the (.*) appears on top of cars list")
//    public void theOptionAppearsOnTopOfCarsList(String option) throws InterruptedException {
//        Action.webElementContainsText(option, sidePanelSearchPage.getDisplayedOption());
//        System.out.println("1st Then");
//        Thread.sleep(5000);
//    }
//
//    @When("user clicks on close button of the option")
//    public void userClicksOnCloseButtonOfTheOption() throws InterruptedException {
//        Page.clickOnWebElement(sidePanelSearchPage.getCloseDisplayedOption());
//        System.out.println("2nd When");
//        Thread.sleep(5000);
//    }
//
//    @Then("the option disappears")
//    public void theOptionDisappears() throws InterruptedException {
//        try {
//            Assert.assertTrue(!sidePanelSearchPage.getDisplayedOption().isDisplayed());
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            Assert.assertTrue(true);
//        }
//
//        System.out.println("2nd Then");
//        Thread.sleep(5000);
//
//    }
//
//    //---------------------------------------------------------------------------------------------------------------------
//    SelectedCarPage selectedCarPage = new SelectedCarPage();
//    @And("user pressed Show Offers Button and was redirected to car list page")
//    public void userPressedShowOffersButtonAndWasRedirectedToCarListPage() {
//        Page.clickOnWebElement(detailedCarSearchPage.getShowOffersButton());
//        Page.webElementContainsText("Used cars", backupCarListPage.getHeaderMessage());
//    }
//
//
//    @When("user selects from sorting drop down (.*)")
//    public void userSelectsSortingOption(String sortingOption) {
//        Page.clickOnWebElement(backupCarListPage.getSortingDropDown());
//        Action.sendKeys(backupCarListPage.getSortingDropDown(), sortingOption);
//        Page.clickOnWebElement(backupCarListPage.getSortingDropDown());
//    }
//
//    @Then("cars are sorted according to selected (.*)")
//    public void carsAreSortedAccordingToSelectedOption(String sortingOption) throws InterruptedException {
//        int firstCarOption, lastCarOption;
//        switch (sortingOption){
//            case "Price ascending":
//                Page.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
//                firstCarOption = selectedCarPage.getActualPrice();
//                driver.navigate().back();
//                Thread.sleep(5000);
//                Page.clickOnWebElement(backupCarListPage.getLastCarOnPage());
//                Thread.sleep(5000);
//                lastCarOption = selectedCarPage.getActualPrice();
//                Assert.assertTrue(firstCarOption<lastCarOption);
//                break;
//            case "Price descending":
//                Page.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
//                firstCarOption = selectedCarPage.getActualPrice();
//                driver.navigate().back();
//                Thread.sleep(5000);
//                Page.clickOnWebElement(backupCarListPage.getLastCarOnPage());
//                Thread.sleep(5000);
//                lastCarOption = selectedCarPage.getActualPrice();
//                Assert.assertTrue(firstCarOption>lastCarOption);
//                break;
//            case "KM ascending":
//                Page.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
//                Thread.sleep(5000);
//                firstCarOption = selectedCarPage.getActualMileage();
//                driver.navigate().back();
//                Thread.sleep(5000);
//                Page.clickOnWebElement(backupCarListPage.getLastCarOnPage());
//                Thread.sleep(5000);
//                lastCarOption = selectedCarPage.getActualMileage();
//                Assert.assertTrue(firstCarOption<=lastCarOption);
//                break;
//            case "KM descending":
//                Page.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
//                firstCarOption = selectedCarPage.getActualMileage();
//                driver.navigate().back();
//                Thread.sleep(5000);
//                Page.clickOnWebElement(backupCarListPage.getLastCarOnPage());
//                Thread.sleep(5000);
//                lastCarOption = selectedCarPage.getActualMileage();
//                Assert.assertTrue(firstCarOption>=lastCarOption);
//                break;
//            case "1st Reg. ascending":
//                Page.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
//                firstCarOption = selectedCarPage.getActualDate();
//                driver.navigate().back();
//                Thread.sleep(5000);
//                Page.clickOnWebElement(backupCarListPage.getLastCarOnPage());
//                Thread.sleep(5000);
//                lastCarOption = selectedCarPage.getActualDate();
//                Assert.assertTrue(firstCarOption<lastCarOption);
//                break;
//            case "1st Reg. descending":
//                Page.clickOnWebElement(backupCarListPage.getFirstCarOnPage());
//                firstCarOption = selectedCarPage.getActualDate();
//                driver.navigate().back();
//                Thread.sleep(5000);
//                Page.clickOnWebElement(backupCarListPage.getLastCarOnPage());
//                Thread.sleep(5000);
//                lastCarOption = selectedCarPage.getActualDate();
//                Assert.assertTrue(firstCarOption>lastCarOption);
//                break;
//        }
//
//    }
//
//    //--------------------------------------------------------------------------------------------------------------------
//    MySearchesPage mySearchesPage = new MySearchesPage();
//    @Given("user is logged in on Mobile.de")
//    public void userIsLoggedInOnMobileDe() {
//        Page.clickOnWebElement(headerGeneral.getLoginButton());
//        Action.waitUntilVisible(loginPage.getEMailField());
//        Action.sendKeys(loginPage.getEMailField(), "trifonovmihail@mail.ru");
//        Action.sendKeys(loginPage.getPasswordField(), "Mobile.De629");
//        Page.clickOnWebElement(loginPage.getLoginButton());
//    }
//
//    @And("My search page is empty")
//    public void mySearchPageIsEmpty() {
//        Page.clickOnWebElement(headerGeneral.getMySearchesButton());
//        Action.clickOnWebElement(headerGeneral.getShowMySearches());
//        try {
//            Action.clickOnWebElement(mySearchesPage.getDeleteSearch());
//        } catch (org.openqa.selenium.NoSuchElementException e) {}
//
//        try {
//            Page.webElementContainsText("You have not saved any search requests", mySearchesPage.getEmptySearch());
//        } catch (org.openqa.selenium.NoSuchElementException e) {}
//        Page.clickOnWebElement(headerGeneral.getMobileDeLogo());
//    }
//
//    @And("user saves current search by clicking on Save search button and following option on pop-up")
//    public void userSavesCurrentSearchByClickingOnSaveSearchButtonAndFollowingOptionOnPopUp() {
//        Page.clickOnWebElement(backupCarListPage.getSaveSearchButton());
//        //Page.clickOnWebElement(backupCarListPage.getEmailNotificationCheckBox());
//        Page.clickOnWebElement(backupCarListPage.getSaveSearchOnPopUp());
//
//    }
//
//    @Then("the Search is saved in My searches")
//    public void theSearchIsSavedInMySearches() {
//        Page.clickOnWebElement(headerGeneral.getMySearchesButton());
//        Page.clickOnWebElement(headerGeneral.getShowMySearches());
//        Assert.assertTrue(mySearchesPage.getDeleteSearch().isDisplayed());
//
//    }
//
//    @And("by clicking on the Saved search user is redirected on car results page")
//    public void byClickingOnTheSavedSearchUserIsRedirectedOnCarResultsPage() {
//        Page.clickOnWebElement(mySearchesPage.getShowSavedSearch());
//        Page.webElementContainsText("Used cars", backupCarListPage.getHeaderMessage());
//
//
//    }
//
//    @And("filters (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) match the original search")
//    public void filtersConditionMakeModelMin_priceMax_priceFromYearToYearFromKmsToKmsMatchTheOriginalSearch(String condition,
//                            String make, String model, String min_price, String max_price, String fromYear, String toYear,
//                            String fromKms, String toKms) {
//        Page.webElementContainsText(make, backupCarListPage.getSavedSearchFilter(0));
//        Page.webElementContainsText(model, backupCarListPage.getSavedSearchFilter(0));
//        Page.webElementContainsText(min_price, backupCarListPage.getSavedSearchFilter(5));
//        Page.webElementContainsText(max_price, backupCarListPage.getSavedSearchFilter(6));
//        Page.webElementContainsText(fromYear, backupCarListPage.getSavedSearchFilter(3));
//        Page.webElementContainsText(toYear, backupCarListPage.getSavedSearchFilter(4));
//        Page.webElementContainsText(fromYear, backupCarListPage.getSavedSearchFilter(1));
//        Page.webElementContainsText(toKms, backupCarListPage.getSavedSearchFilter(2));
//
//    }
//
//
//}

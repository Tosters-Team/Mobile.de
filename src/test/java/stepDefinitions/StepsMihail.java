package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Action;

import static pageObjects.InitPages.*;

public class StepsMihail {
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

    @Then("Available offers page is displaying containing vehicles that mach the search criteria")
    public void availableOffersPageIsDisplayingContainingVehiclesThatMachTheSearchCriteria() throws InterruptedException {
        System.out.println("Mologhets");

        Thread.sleep(20000);
    }
}

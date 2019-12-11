package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Action;
import methods.Helper;
import pageObjects.CarListPage;
import pageObjects.HeaderGeneral;
import pageObjects.HomePageQuickSearch;

import static stepDefinitions.Hooks.driver;

import java.text.ParseException;
import java.util.Objects;

public class StepsArtur {
    public static HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    public static HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch(driver);
    public static CarListPage carListPage = new CarListPage(driver);


    @Given("Mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglish() {
        Action.clickOnWebElement(headerGeneral.getGermanLanguage());
        Action.clickOnWebElement((headerGeneral.getEnglishLanguage()));
        Action.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @When("I select (.*) in Make drop-down")
    public void iSelectMakeInMakeDropDown(String make) {
        Action.clickOnWebElement(Objects.requireNonNull(Helper.getWebElementFromEnum(make)));
        Action.waitUntilVisible(Helper.getWebElementFromEnum(make));
    }

    @And("select (.*) in Model drop-down")
    public void selectModelInModelDropDown(String model) {
        Action.clickOnWebElement(Objects.requireNonNull(Helper.getWebElementFromEnum(model)));
        Action.waitUntilVisible(Helper.getWebElementFromEnum(model));
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
        Helper.assert_is_make_model_underPrice(make, model, price);
    }
}

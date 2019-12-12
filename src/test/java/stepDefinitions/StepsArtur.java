package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Action;
import methods.Helper;
import pageObjects.HeaderGeneral;
import pageObjects.HomePageQuickSearch;
import pageObjects.InitPages;
import pageObjects.LoginPage;

import static stepDefinitions.Hooks.driver;
import java.text.ParseException;

public class StepsArtur {


    HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    InitPages homePageQuickSearch = new HomePageQuickSearch(driver);
    HomePageQuickSearch homePageQuickSearch2 = new HomePageQuickSearch(driver);
    LoginPage loginPage = new LoginPage(driver);
    Helper helper = new Helper();

    @Given("Mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglish() {
        Action.clickOnWebElement(headerGeneral.getGermanLanguage());
        Action.clickOnWebElement((headerGeneral.getEnglishLanguage()));
        Action.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @When("I select (.*) in Make drop-down")
    public void iSelectMakeInMakeDropDown(String make) throws InterruptedException {
        Action.clickOnWebElement(homePageQuickSearch.getWebElementByName(make));
        Thread.sleep(2000);
//        Action.clickOnWebElement(Objects.requireNonNull(Helper.getWebElementFromEnum(make)));
        Action.waitUntilVisible(homePageQuickSearch.getWebElementByName(make));
        Thread.sleep(2000);
    }

    @And("select (.*) in Model drop-down")
    public void selectModelInModelDropDown(String model) throws InterruptedException {
        Action.clickOnWebElement(homePageQuickSearch.getWebElementByName(model));
        Thread.sleep(2000);
//        Action.clickOnWebElement(Objects.requireNonNull(Helper.getWebElementFromEnum(model)));
        Action.waitUntilVisible(Helper.getWebElementFromEnum(model));
    }

    @And("select price up to (.*)")
    public void selectPriceUpToPrice(String price) throws InterruptedException {
        Thread.sleep(2000);
        Action.sendKeys(homePageQuickSearch2.getPriceUpTo(), price);
    }

    @And("click on Search button")
    public void clickOnSearchButton() {
        Action.clickOnWebElement(homePageQuickSearch2.getSearchButton());
    }

    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws ParseException {
        helper.assert_is_make_model_underPrice(make, model, price);
    }

    @Given("Login page is opened")
    public void loginPageIsOpened() {
        Action.clickOnWebElement(headerGeneral.getLoginButton());
        Action.waitUntilVisible(loginPage.getLoginButton());
    }

    @When("I provide valid credentials Email and Password")
    public void iProvideValidCredentialsEmailPassword() {
        Action.sendKeys(loginPage.getEMailField(), "vangartur@gmail.com");
        Action.sendKeys(loginPage.getPasswordField(), "Artiq!23");
    }

    @And("click on Log in Button")
    public void clickOnLogInButton() {
        Action.clickOnWebElement(loginPage.getLoginButton());
    }

    @Then("I have successfully logged in")
    public void iHaveSuccessfullyLoggedIn() {
        Action.webElementContainsText("MyMobile.de", headerGeneral.getMyMobileDeDropDown());
    }
}

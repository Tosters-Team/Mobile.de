package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.Action;
import org.junit.Assert;
import pageObjects.*;
import static stepDefinitions.Hooks.driver;

public class StepsAnatol {

    public static HeaderGeneral headerGeneral = new HeaderGeneral(driver);
    public static HomePageQuickSearch homePageQuickSearch = new HomePageQuickSearch(driver);
    public static CarListPage carListPage = new CarListPage(driver);
    public static LoginPage loginPage = new LoginPage(driver);
    public static CarParkPage carParkPage = new CarParkPage(driver);

    @Given("mobile de is opened and language changed to English")
    public void mobileDeIsOpenedAndLanguageChangedToEnglish() {
        Action.clickOnWebElement(headerGeneral.getGermanLanguage());
        Action.clickOnWebElement((headerGeneral.getEnglishLanguage()));
        Action.webElementContainsText("Biggest Vehicle Marketplace Online", headerGeneral.getTextOnHeader());
    }

    @Given("login to Mobile de and click on search button")
    public void loginAndClickOnSearchButton() {
        Action.clickOnWebElement(headerGeneral.getLoginButton());
        Action.waitUntilVisible(loginPage.getEMailField());
        Action.sendKeys(loginPage.getEMailField(), "leecooper_leecooper@mail.ru");
        Action.sendKeys(loginPage.getPasswordField(), "HappyTest123");
        Action.clickOnWebElement(loginPage.getLoginButton());
        Action.waitUntilVisible(homePageQuickSearch.getSearchButton());
        Action.clickOnWebElement(homePageQuickSearch.getSearchButton());
        Action.waitUntilVisible(carListPage.getParkFirstCarButton());
    }

    @When("click on park button to add the first car")
    public void addTheFirstCarInCarPark() throws InterruptedException {
        Thread.sleep(2000);
        Action.clickOnWebElement(carListPage.getParkFirstCarButton());
    }

    @And("click on park button to add the second car")
    public void addTheSecondCarInCarPark() throws InterruptedException{
        Thread.sleep(2000);
        Action.clickOnWebElement(carListPage.getParkSecondCarButton());
    }

    @And("click on car park button")
    public void clickOnCarParkButton() throws InterruptedException{
        Thread.sleep(2000);
        Action.clickOnWebElement(headerGeneral.getMyCarParkButton());
    }

    @Then("added cars are displayed")
    public void carsAreDisplayed() {
        Assert.assertTrue(Action.webElementContainsText("2",
                headerGeneral.getMyCarParkButton()));
    }
}

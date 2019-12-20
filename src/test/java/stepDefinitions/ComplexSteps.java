package stepDefinitions;

import actions.CommonActions;
import actions.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import scenarion_context.ScenarioContext;
import utils.Log;
import utils.Reflection;

import java.text.ParseException;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class ComplexSteps {

    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @When("User clicks on {int} random {string}")
    public void userClicksOnRandomButtons(int amountOfClicks, String nameOfWebElement) {

        List<WebElement> carParkButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), nameOfWebElement);

        List<WebElement> parkedStatus = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Parked status");

        Helper.getParkRandomCars(carParkButtons, parkedStatus, amountOfClicks);
    }

    @And("Cars are displayed")
    public void addedCarsAreDisplayed() {
        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        CommonActions.waitUntilVisible(amountOfCars);
        Assert.assertTrue(amountOfCars.isDisplayed());

        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
        }
    }

    @Then("the same (.*) is displayed")
    public void theSameTextIsDisplayed(String text) {
        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        WebElement textField = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Note field");
        Assert.assertTrue(textField.getText().equals(text));
        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
        }
    }

    @And("{string} is displayed")
    public void comparisonListIsDisplayed(String webElement) {
        WebElement comparisonTable = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), webElement);

        WebElement comparisonHeader = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Comparison header");

        CommonActions.waitUntilVisible(comparisonHeader);
        Assert.assertTrue(comparisonTable.isDisplayed());
        Assert.assertTrue(comparisonHeader.isDisplayed());

        scenarioContext.setCurrentPage(Reflection.getPageByName("Header"));

        CommonActions.clickOnWebElement(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "My car park button"));

        scenarioContext.setCurrentPage(Reflection.getPageByName("Car Park Page"));

        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        CommonActions.waitUntilVisible(amountOfCars);
        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
        }
    }

    @When("User selects (.*) in Make drop-down")
    public void userSelectsMakeInMakeDropDown(String make) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(
                ScenarioContext.getInstance().getCurrentPage(), make
        ));
    }

    @And("selects (.*) in Model drop-down")
    public void selectsModelInModelDropDown(String model) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), model));
    }

    @And("selects price up to (.*) in Price field")
    public void selectsPriceUpToPriceInPriceField(String price) {
        CommonActions.sendKeys(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "Price field"), price);
    }

    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws ParseException {
        List<WebElement> listOfAnnouncements = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "List of announcements");
        List<WebElement> listOfPrices = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "List of prices");
        Assert.assertTrue(CommonActions.webElementContainsText(make, Helper.getRandomElement(listOfAnnouncements)));
        Assert.assertTrue(CommonActions.webElementContainsText(model, Helper.getRandomElement(listOfAnnouncements)));
        Assert.assertTrue(Helper.returnsIntFromParsedString(Helper.getRandomElement(listOfPrices).getText())
                <= Helper.returnsIntFromParsedString(price));
    }

    @When("User selects (.*) category on Quick Truck Search")
    public void userSelectsCategoryCategoryOnQuickTruckSearch(String category) {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), category));
    }

    @Then("detailed search of that (.*) is displayed")
    public void detailedSearchOfThatCategoryIsDisplayed(String category) {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(
                scenarioContext.getCurrentPage(), "Truck page header"));
        Assert.assertTrue(Reflection.getWebElementByName(
                scenarioContext.getCurrentPage(), "Truck page header")
                .getText().contains(category));
    }

    @Then("the selected (.*) matches the 'Displayed option'")
    public void theOptionAppearsOnTopOfCarsList(String option) {
        CommonActions.webElementContainsText(option, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Displayed option"));
        Log.info("Selected option matches provided option " + option);

    }

    @Then("{string} is not displayed")
    public void theOptionDisappears(String option) {
        try {
            Assert.assertTrue(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), option).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.assertTrue(true);
            Log.info("Deleted option " + option + " is not present");
        }
    }

    @Given("User clicks on option (.*)")
    public void userClicksOnOption(String webElementName) {
        CommonActions.clickOnWebElementWoWaiters
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                webElementName));
        Log.info(webElementName + " Web Element clicked successfully");
    }

    @And("User selects a random car from {string}")
    public void userSelectsARandomCarFromList(String elementName) {
        List<WebElement> carResults = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), elementName);
        Helper.getRandomCar(carResults);
    }

    @Then("chosen car complies to the selected options: (.*), (.*), (.*)")
    public void chosenCarOptionsTypeFuelTypeTransmission(String type, String transmission, String fuel) {
        CommonActions.webElementContainsText(type, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Car body type"));
        CommonActions.webElementContainsText(transmission, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Fuel type"));
        CommonActions.webElementContainsText(fuel, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Transmission type"));
    }

    @Then("displayed offers are sorted according to selected (.*)")
    public void displayedOffersAreSortedAccordingToSelectedSortingOption(String sortingOption) {
        int firstCarOption, lastCarOption;
        List<WebElement> carResults = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "Car results");
        switch (sortingOption) {
            case "Price ascending":
                Helper.getFirstCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                Assert.assertTrue(firstCarOption < lastCarOption);
                break;
            case "Price descending":
                Helper.getFirstCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                Assert.assertTrue(firstCarOption > lastCarOption);
                break;
            case "KM ascending":
                Helper.getFirstCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                Assert.assertTrue(firstCarOption < lastCarOption);
                break;
            case "KM descending":
                Helper.getFirstCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                Assert.assertTrue(firstCarOption > lastCarOption);
                break;
            case "1st Reg. ascending":
                Helper.getFirstCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                Assert.assertTrue(firstCarOption < lastCarOption);
                break;
            case "1st Reg. descending":
                Helper.getFirstCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualDate(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualDate(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                Assert.assertTrue(firstCarOption > lastCarOption);
                break;
        }
    }
}
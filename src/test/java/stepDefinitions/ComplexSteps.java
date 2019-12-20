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
import utils.ScreenShotUtil;

import java.text.ParseException;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class ComplexSteps {

    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @When("User clicks on {int} random {string}")
    public void userClicksOnRandomButtons(int amountOfClicks, String nameOfWebElement) throws Exception {

        List<WebElement> carParkButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), nameOfWebElement);

        List<WebElement> parkedStatus = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Parked status");

        Helper.getParkRandomCars(carParkButtons, parkedStatus, amountOfClicks);
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("Cars are displayed")
    public void addedCarsAreDisplayed() throws Exception {
        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        CommonActions.waitUntilVisible(amountOfCars);
        Assert.assertTrue(amountOfCars.isDisplayed());

        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
            ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }

    @Then("the same (.*) is displayed")
    public void theSameTextIsDisplayed(String text) throws Exception {
        WebElement amountOfCars = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Amount of cars");

        List<WebElement> deleteButtons = Reflection.getListOfWebElements
                (scenarioContext.getCurrentPage(), "Remove buttons");

        WebElement textField = Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Note field");
        Assert.assertTrue(textField.getText().equals(text));
        if (amountOfCars.isDisplayed()) {
            CommonActions.clickOnAllFromList(deleteButtons);
            ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }

    @And("{string} is displayed")
    public void comparisonListIsDisplayed(String webElement) throws Exception {
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
            ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }

    @When("User selects (.*) in Make drop-down")
    public void userSelectsMakeInMakeDropDown(String make) throws Exception {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(
                ScenarioContext.getInstance().getCurrentPage(), make));
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("selects (.*) in Model drop-down")
    public void selectsModelInModelDropDown(String model) throws Exception {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), model));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("selects price up to (.*) in Price field")
    public void selectsPriceUpToPriceInPriceField(String price) throws Exception {
        CommonActions.sendKeys(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "Price field"), price);
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("cars search was done and only cars of (.*) and (.*) under (.*) are displayed")
    public void carsSearchWasDoneAndOnlyCarsOfMakeAndModelUnderPriceAreDisplayed(String make, String model, String price) throws Exception {
        List<WebElement> listOfAnnouncements = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "List of announcements");
        List<WebElement> listOfPrices = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "List of prices");
        Assert.assertTrue(CommonActions.webElementContainsText(make, Helper.getRandomElement(listOfAnnouncements)));
        Assert.assertTrue(CommonActions.webElementContainsText(model, Helper.getRandomElement(listOfAnnouncements)));
        Assert.assertTrue(Helper.returnsIntFromParsedString(Helper.getRandomElement(listOfPrices).getText())
                <= Helper.returnsIntFromParsedString(price));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @When("User selects (.*) category on Quick Truck Search")
    public void userSelectsCategoryCategoryOnQuickTruckSearch(String category) throws Exception {
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(ScenarioContext.getInstance().getCurrentPage(), category));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("detailed search of that (.*) is displayed")
    public void detailedSearchOfThatCategoryIsDisplayed(String category) throws Exception {
        CommonActions.waitUntilVisible(Reflection.getWebElementByName(
                scenarioContext.getCurrentPage(), "Truck page header"));
        Assert.assertTrue(Reflection.getWebElementByName(
                scenarioContext.getCurrentPage(), "Truck page header")
                .getText().contains(category));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("the selected '(.*)' matches the '(.*)'")
    public void theOptionAppearsOnTopOfCarsList(String option, String webElementName) throws Exception {
        CommonActions.webElementContainsText(option, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), webElementName));
        Log.info("Selected option matches provided option " + option);
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Then("{string} is not displayed")
    public void theOptionDisappears(String option) throws Exception {
        try {
            Assert.assertTrue(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), option).isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.assertTrue(true);
            Log.info("Deleted option " + option + " is not present");
        }
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Given("User clicks on option (.*)")
    public void userClicksOnOption(String webElementName) throws Exception {
        CommonActions.clickOnWebElementWoWaiters
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                webElementName));
        Log.info(webElementName + " Web Element clicked successfully");
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("User selects a random car from {string}")
    public void userSelectsARandomCarFromList(String elementName) throws Exception {
        List<WebElement> carResults = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), elementName);
        Helper.getRandomCar(carResults);
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("chosen car complies to the selected options: (.*), (.*), (.*)")
    public void chosenCarOptionsTypeFuelTypeTransmission(String type, String transmission, String fuel) throws Exception {
        CommonActions.webElementContainsText(type, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Car body type"));
        CommonActions.webElementContainsText(transmission, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Fuel type"));
        CommonActions.webElementContainsText(fuel, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Transmission type"));
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("displayed offers are sorted according to selected (.*)")
    public void displayedOffersAreSortedAccordingToSelectedSortingOption(String sortingOption) throws Exception {
        int firstCarOption, lastCarOption;
        List<WebElement> carResults = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "Car results");
        switch (sortingOption) {
            case "Price ascending":
                Helper.getFirstCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                Assert.assertTrue(firstCarOption < lastCarOption);
                break;
            case "Price descending":
                Helper.getFirstCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Price"));
                Assert.assertTrue(firstCarOption > lastCarOption);
                break;
            case "KM ascending":
                Helper.getFirstCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                Assert.assertTrue(firstCarOption < lastCarOption);
                break;
            case "KM descending":
                Helper.getFirstCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualMileage(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Mileage"));
                Assert.assertTrue(firstCarOption > lastCarOption);
                break;
            case "1st Reg. ascending":
                Helper.getFirstCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualPrice(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                Assert.assertTrue(firstCarOption < lastCarOption);
                break;
            case "1st Reg. descending":
                Helper.getFirstCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                firstCarOption = Helper.getActualDate(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                driver.navigate().back();
                scenarioContext.setCurrentPage(Reflection.getPageByName("Backup Car List Page"));
                Helper.getLastCar(carResults);
                ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
                scenarioContext.setCurrentPage(Reflection.getPageByName("Selected Car Page"));
                lastCarOption = Helper.getActualDate(Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                "Registration date"));
                Assert.assertTrue(firstCarOption > lastCarOption);
                break;
        }
    }

    @Then("filters (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) match the original search")
    public void filtersConditionMakeModelMin_priceMax_priceFromYearToYearFromKmsToKmsMatchTheOriginalSearch(
            String condition, String make, String model, String min_price, String max_price, String fromYear,
            String toYear, String fromKms, String toKms ) {
        List<WebElement> carResults = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(),
                "Saved search filters");
        CommonActions.webElementContainsText(make, carResults.get(0));
        CommonActions.webElementContainsText(model, carResults.get(0));
        CommonActions.webElementContainsText(min_price, carResults.get(5));
        CommonActions.webElementContainsText(max_price, carResults.get(6));
        CommonActions.webElementContainsText(fromYear, carResults.get(3));
        CommonActions.webElementContainsText(toYear, carResults.get(4));
        CommonActions.webElementContainsText(fromKms, carResults.get(1));
        CommonActions.webElementContainsText(toKms, carResults.get(2));
    }

    @And("Delete saved searches")
    public void deleteSavedSearches() {
        scenarioContext.setCurrentPage(Reflection.getPageByName("Header"));
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "My searches"));
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "Show my searches"));
        scenarioContext.setCurrentPage(Reflection.getPageByName("My Searches Page"));
        Log.info("Accessed saved searches");
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "Delete stored search"));
        CommonActions.webElementContainsText("You have not saved any search requests.",
                Reflection.getWebElementByName(scenarioContext.getCurrentPage(), "Empty search"));
        Log.info(" Saved searches is cleared");
    }
}
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
import static stepDefinitions.Hooks.driver;
import java.util.List;

public class MihailGenericSteps {
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Given("User clicks on {string} on {string}")
    public void userClicksOnLanguageSelectorDropDownOnHeader(String element, String pageName) {
        scenarioContext.setCurrentPage(Reflection.getPageByName(pageName));
        Log.info(pageName + " page is accessed successfully");
        CommonActions.clickOnWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(),element));
        Log.info(element + " Web Element clicked saxfull");
    }

    @Given("User clicks on {string}")
    public void userClicksOn(String webElementName) {
        CommonActions.clickOnWebElement
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                webElementName));
        Log.info(webElementName + " Web Element clicked saxfull");
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

    @When("User provides (.*) in (.*)")
    public void userProvidesOptionInOption_typeOnSidePanelSearchPage(String option, String optionType) {
        CommonActions.sendKeysWithOutClearField(Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(),optionType), option);
        Log.info("User entered " + option + " value in " + optionType + " field saxfully");
    }

    @And("User is on {string}")
    public void userIsOnPage(String pageName) {
        scenarioContext.setCurrentPage
                (Reflection.getPageByName(pageName));
        Log.info(pageName + "  page is accessed successfully");
    }

    @Given("User clicks on option (.*)")
    public void userClicksOnOption(String webElementName) {
        CommonActions.clickOnWebElementWoWaiters
                (Reflection.getWebElementByName
                        (scenarioContext.getCurrentPage(),
                                webElementName));
        Log.info(webElementName + " Web Element clicked saxfull");
    }


    @And("User selects a random car from {string}")
    public void userSelectsARandomCarFromList(String elementName) {
        List<WebElement> carResults = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), elementName);
        Helper.getRandomCar(carResults);
    }

    @Then("asdgsdgdgsdg")
    public void asdgsdgdgsdg() {
        System.out.println("kasjdaksdg");
    }

    @Then("chosen car complies to the selected options: (.*), (.*), (.*)")
    public void chosenCarOptionsTypeFuel_typeTransmission(String type, String transmission, String fuel) {
        CommonActions.webElementContainsText(type, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Car body type"));
        CommonActions.webElementContainsText(transmission, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Fuel type"));
        CommonActions.webElementContainsText(fuel, Reflection.getWebElementByName
                (scenarioContext.getCurrentPage(), "Transmission type"));
    }

    @And("User selects {string} field to populate")
    public void userSelectsMakeFieldFieldToPopulate(String field) {
        scenarioContext.setWebElement(Reflection.getWebElementByName(scenarioContext.getCurrentPage(), field));
        Log.info("User selected the following field: " + field);
    }

    @And("User enters (.*)")
    public void userEntersMake(String option) {
        CommonActions.sendKeysWithOutClearField(scenarioContext.getWebElement(), option);
        Log.info("User entered " + option + " value in selected field");
    }

    @Then("displayed offers are sorted according to selected (.*)")
    public void displayedOffersAreSortedAccordingToSelectedSorting_option(String sortingOption) {
        int firstCarOption, lastCarOption;
        List<WebElement> carResults = Reflection.getListOfWebElements(scenarioContext.getCurrentPage(), "Car results");
        switch (sortingOption){
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
                Assert.assertTrue(firstCarOption<lastCarOption);
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
                Assert.assertTrue(firstCarOption>lastCarOption);
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
                Assert.assertTrue(firstCarOption<lastCarOption);
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
                Assert.assertTrue(firstCarOption>lastCarOption);
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
                Assert.assertTrue(firstCarOption<lastCarOption);
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
                Assert.assertTrue(firstCarOption>lastCarOption);
                break;
        }

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

    }
}

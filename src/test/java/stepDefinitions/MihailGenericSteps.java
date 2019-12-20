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

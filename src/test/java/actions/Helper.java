package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import scenarion_context.ScenarioContext;
import utils.Reflection;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import static actions.CommonActions.clickOnWebElement;
import static actions.CommonActions.waitUntilVisible;


public class Helper {
    private static ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public static void getRandomCar(List<WebElement> list) {
        Random random = new Random();
        int randomCar = random.nextInt((list.size()-1) - 1) + 1;
        clickOnWebElement(list.get(randomCar));
    }

    public static void getFirstCar(List<WebElement> list) {
        clickOnWebElement(list.get(1));
    }

    public static void getLastCar(List<WebElement> list) {
        clickOnWebElement(list.get(23));
    }

    public static int getActualPrice(WebElement price) {
        return Integer.parseInt(price.getText().substring(1).replaceAll(",",""));
    }

    public static int getActualMileage(WebElement mileage) {
        return Integer.parseInt(mileage.getText().replaceAll("[^\\d.]", "").replace(".",""));
    }

    public static int getActualDate(WebElement firstRegistration) {
        int dateInt;
        String dateString = firstRegistration.getText();
        String[] separatedDate = dateString.split("/");
        StringBuilder unifiedDate = new StringBuilder();
        unifiedDate.append(separatedDate[1]);
        unifiedDate.append(separatedDate[0]);
        dateInt = Integer.parseInt(unifiedDate.toString());
        System.out.println(dateInt);
        return dateInt;
    }

    public static int returnsIntFromParsedString(String toParse) throws ParseException {
        String str = toParse.replace("€", "$");
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = format.parse(str);
        return number.intValue();
    }


    public static void getParkRandomCars(List<WebElement> webElements, List<WebElement> carIsParked, int amount) {
        Random randomNumber = new Random();
        waitUntilVisible(webElements.get(webElements.size() - 1));
        for (int i = 1; i <= amount; i++) {
            int parkRandomCar = randomNumber.nextInt(webElements.size());
            clickOnWebElement(webElements.get(parkRandomCar));
            waitUntilVisible(carIsParked.get(parkRandomCar));
            webElements.remove(parkRandomCar);
        }
    }

    public static int getPriceForComparison(String price) {
        int priceInt = Integer.parseInt(price);
        return priceInt;
    }

    public static int getYearForComparison(String year) {
        int yearInt = Integer.parseInt(year);
        return yearInt;
    }

    public static int getMileageForComparisson(String mileage) {
        System.out.println("V init pageah problema");
        int mileageInt = Integer.parseInt(mileage);
        return mileageInt;
    }
}

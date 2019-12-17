package methods;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.CarListPage;
import pageObjects.InitPages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import static pageObjects.InitPages.clickOnWebElement;
import static pageObjects.InitPages.waitUntilVisible;

public class Helper {


    public static WebElement getRandomCar(List<WebElement> list) {
        Random random = new Random();
        int randomCar = random.nextInt(list.size());
        return list.get(randomCar);
    }

    public static int returnsIntFromParsedString(String toParse) throws ParseException {
        String str = toParse.replace("€", "$");
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = format.parse(str);
        return number.intValue();
    }


    public static void getParkRandomCars(List<WebElement> webElements, List<WebElement> carIsParked, int amount) {
        Random randomNumber = new Random();
        InitPages.waitUntilVisible(webElements.get(webElements.size()-1));
        for (int i = 1; i <= amount; i++) {
            int parkRandomCar = randomNumber.nextInt(webElements.size());
            clickOnWebElement(webElements.get(parkRandomCar));
            waitUntilVisible(carIsParked.get(parkRandomCar));
            webElements.remove(parkRandomCar);
        }
    }
}

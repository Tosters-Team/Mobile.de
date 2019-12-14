package methods;

import enums.Examples;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.CarListPage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import static stepDefinitions.Hooks.driver;

public class Helper {
    private CarListPage carListPage = new CarListPage(driver);


    private WebElement getRandomCar(List<WebElement> list) {
        Random random = new Random();
        int randomCar = random.nextInt(list.size());
        return list.get(randomCar);
    }

       public void assert_is_make_model_underPrice_ListTest(String make, String model, String price) throws ParseException {
        Assert.assertTrue(getRandomCar(carListPage.getListAnnouncement()).getText().contains(make));
        Assert.assertTrue(getRandomCar(carListPage.getListAnnouncement()).getText().contains(model));
        Assert.assertTrue(returnsIntFromParsedString(getRandomCar(carListPage.getListPrices()).getText()) <= returnsIntFromParsedString(price));
    }
    private static int returnsIntFromParsedString(String toParse) throws ParseException {
        String str = toParse.replace("€", "$");
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = format.parse(str);
        return number.intValue();
    }

    public static WebElement getWebElementFromEnum(String string) {
        for (Examples b : Examples.values()) {
            if (b.getToCall().equalsIgnoreCase(string)) {
                return b.getWebElement();
            }
        }
        return null;
    }
}

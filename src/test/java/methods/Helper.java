package methods;

import enums.MakesAndModels;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import stepDefinitions.StepsArtur;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

public class Helper {
    private static final WebElement[] ARRAY_OF_FIRST_THREE_HEADERS_PRICE = new WebElement[] {StepsArtur.carListPage.getFirstPriceTag(),StepsArtur.carListPage.getSecondPriceTag(),StepsArtur.carListPage.getThirdPriceTag()};

    private static final WebElement[] ARRAY_OF_FIRST_THREE_HEADERS_ANNOUNCE = new WebElement[] {StepsArtur.carListPage.getFirstHeaderAnnouncement(),StepsArtur.carListPage.getSecondHeaderAnnouncement(),StepsArtur.carListPage.getThirdHeaderAnnouncement()};

    private static WebElement returnsWebElement(WebElement[] toSort) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(toSort.length);
        return toSort[randomIndex];
    }

    public static void assert_is_make_model_underPrice(String make, String model, String price) throws ParseException {
        Assert.assertTrue(returnsWebElement(ARRAY_OF_FIRST_THREE_HEADERS_ANNOUNCE).getText().contains(make));
        Assert.assertTrue(returnsWebElement(ARRAY_OF_FIRST_THREE_HEADERS_ANNOUNCE).getText().contains(model));
        Assert.assertTrue(returnsIntFromParsedString(returnsWebElement(ARRAY_OF_FIRST_THREE_HEADERS_PRICE).getText()) <= returnsIntFromParsedString(price));
    }

    private static int returnsIntFromParsedString(String toParse) throws ParseException {
        String str = toParse.replace("€", "$");
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = format.parse(str);
        return number.intValue();
    }

    public static WebElement getWebElementFromEnum(String string) {
        for (MakesAndModels b : MakesAndModels.values()) {
            if (b.getToCall().equalsIgnoreCase(string)) {
                return b.getWebElement();
            }
        }
        return null;
    }
}
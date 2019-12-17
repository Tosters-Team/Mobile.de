package utils;

import org.openqa.selenium.WebElement;
import pageObjects.InitPages;
import pageObjects.WebElementName;

import java.lang.reflect.Field;


public class Reflection {

    public static WebElement getWebElementByName(InitPages page, String name) {

        for (Field field : page.getClass().getDeclaredFields()) {
            if (field.getAnnotation(WebElementName.class).name().equals(name)){
                try {
                    field.setAccessible(true);
                    return (WebElement) field.get(page);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

package utils;


import org.openqa.selenium.WebElement;
import pageObjects.Page;
import pageObjects.annotations.WebElementName;

import java.lang.reflect.Field;


public class Reflection {

    public static WebElement getWebElementByName(Page page, String webElementName) {

        for (Field field : page.getClass().getDeclaredFields()) {
            if (field.getAnnotation(WebElementName.class).name().equals(webElementName)) {
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
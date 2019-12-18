package utils;

import org.openqa.selenium.WebElement;
import pageObjects.Page;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

import java.lang.reflect.Field;


public class Reflection {

    public static WebElement getWebElementByName(Page page, String name) {

        for (Field field : page.getClass().getDeclaredFields()) {
            if (field.getAnnotation(WebElementName.class).name().equals(name)) {
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

    public static Page getPageByName(String pageName) {
        for (Class clazz : Page.class.getClasses()) {
            if (clazz.getAnnotation(PageName.class).equals(pageName)) {
                try {
                    return Page.class.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
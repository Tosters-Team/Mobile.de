package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"login-username\"]")
    private WebElement eMailField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"loginSubmitButton\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div/div/div/span")
    private WebElement notValidCredentials;

    public WebElement getEMailField() {
        return eMailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getNotValidCredentials() {
        return notValidCredentials;
    }
}
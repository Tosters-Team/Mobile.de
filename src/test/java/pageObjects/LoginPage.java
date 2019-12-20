package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

@PageName(name = "Login Page")
public class LoginPage extends Page {

    public LoginPage() {
        super();
    }


    @WebElementName(name = "Email field")
    @FindBy(xpath = "//*[@id=\"login-username\"]")
    private WebElement eMailField;

    @WebElementName(name = "Password field")
    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordField;

    @WebElementName(name = "LogIn button")
    @FindBy(xpath = "//*[@id=\"loginSubmitButton\"]")
    private WebElement loginButton;

    @WebElementName(name = "Login Page")
    @FindBy(xpath = "//*[@id=\"loginTab\"]/h3")
    private WebElement loginPage;

    @WebElementName(name = "The credentials you provided cannot be confirmed as authentic.")
    @FindBy(xpath = "//*[@id=\"container\"]/div[1]/div/div/div/span")
    private WebElement notValidCredentials;

}



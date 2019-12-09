package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/a/span")
    private WebElement changePassword;

    @FindBy(xpath = "//*[@id=\"newPassword\"]")
    private WebElement newPasswordField;

    @FindBy(xpath = "//*[@id=\"oldPassword\"]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div[2]/button")
    private WebElement saveChangingPassword;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement lastNameField;

    public WebElement getChangePassword() {
        return changePassword;
    }

    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getSaveChangingPassword() {
        return saveChangingPassword;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getSaveChangingName() {
        return saveChangingName;
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/form/div/div[3]/div[2]/button")
    private WebElement saveChangingName;
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderGeneral extends InitPages{

    public HeaderGeneral(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"hdmylogin\"]/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[3]")
    private WebElement myMobileDeDropDown;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[3]/ul/li[6]")
    private WebElement logoutOption;

    @FindBy(xpath = "//*[@id=\"hdmyacc\"]")
    private WebElement editAccountOption;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[2]")
    private WebElement myCarParkButton;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[1]")
    private WebElement mySearchesButton;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[1]/ul/li[2]/a/span/span")
    private WebElement showMySearches;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/a/i")
    private WebElement logoHomePageButton;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[1]/li[3]")
    private WebElement germanLanguage;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/span/span")
    private WebElement textOnHeader;

    public WebElement getTextOnHeader() {
        return textOnHeader;
    }

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[1]/li[3]/ul/li[1]")
    private WebElement englishLanguage;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/a/i")
    private WebElement mobileDeLogo;

    public WebElement getMobileDeLogo() {
        return mobileDeLogo;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getMyMobileDeDropDown() {
        return myMobileDeDropDown;
    }

    public WebElement getLogoutOption() {
        return logoutOption;
    }

    public WebElement getEditAccountOption() {
        return editAccountOption;
    }

    public WebElement getMyCarParkButton() {
        return myCarParkButton;
    }

    public WebElement getMySearchesButton() {
        return mySearchesButton;
    }

    public WebElement getShowMySearches() {
        return showMySearches;
    }

    public WebElement getLogoHomePageButton() {
        return logoHomePageButton;
    }

    public WebElement getGermanLanguage() {
        return germanLanguage;
    }

    public WebElement getEnglishLanguage() {
        return englishLanguage;
    }
}

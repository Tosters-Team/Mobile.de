package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@PageName(name = "Header")
public class HeaderGeneral extends Page {

    public HeaderGeneral() {
        super();
    }


    @WebElementName(name = "Login button")
    @FindBy(xpath = "//*[@id=\"hdmylogin\"]/span")
    protected WebElement loginButton;

    @WebElementName(name = "My Mobile.de drop-down")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[3]")
    protected WebElement myMobileDeDropDown;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[3]/ul/li[6]")
    protected WebElement logoutOption;

    @WebElementName(name = "Edit Account")
    @FindBy(xpath = "//*[@id=\"hdmyacc\"]")
    protected WebElement editAccountOption;

    @WebElementName(name = "My car park button")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[2]")
    protected WebElement myCarParkButton;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/header[1]/div[2]/nav[1]/div[1]/ul[2]/li[1]/a[1]")
    protected WebElement mySearchesButton;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[1]/ul/li[1]/a/span")
    protected WebElement showMySearches;

    @WebElementName(name = "Logo")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/a/i")
    protected WebElement logoHomePageButton;

    @WebElementName(name = "Language selector drop-down")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[1]/li[3]")
    protected WebElement languageDropDown;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/span/span")
    protected WebElement textOnHeader;

    @WebElementName(name = "English language option")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[1]/li[3]/ul/li[1]")
    protected WebElement englishLanguage;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/a/i")
    protected WebElement mobileDeLogo;

}

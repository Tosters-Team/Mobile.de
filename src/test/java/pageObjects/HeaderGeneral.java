package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.annotations.PageName;
import pageObjects.annotations.WebElementName;

@Getter

@PageName(name = "Header")
public class HeaderGeneral extends Page {

    public HeaderGeneral() {
        super();
    }


    @WebElementName(name = "Login button")
    @FindBy(xpath = "//*[@id=\"hdmylogin\"]/span")
    private WebElement loginButton;

    @WebElementName(name = "My Mobile.de drop-down")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[3]")
    private WebElement myMobileDeDropDown;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[3]/ul/li[6]")
    private WebElement logoutOption;

    @WebElementName(name = "Edit Account")
    @FindBy(xpath = "//*[@id=\"hdmyacc\"]")
    private WebElement editAccountOption;

    @WebElementName(name = "My car park button")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[2]")
    private WebElement myCarParkButton;

    @WebElementName(name = "My searches")
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/header[1]/div[2]/nav[1]/div[1]/ul[2]/li[1]/a[1]")
    private WebElement mySearchesButton;

    @WebElementName(name = "Show my searches")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[2]/li[1]/ul/li[1]/a/span")
    private WebElement showMySearches;

    @WebElementName(name = "Logo")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/a/i")
    private WebElement logoHomePageButton;

    @WebElementName(name = "Language selector drop-down")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[1]/li[3]")
    private WebElement languageDropDown;

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/span/span")
    private WebElement textOnHeader;

    @WebElementName(name = "English language option")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/nav/div/ul[1]/li[3]/ul/li[1]")
    private WebElement englishLanguage;

    @WebElementName(name = "Mobile logo")
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[2]/div/a/i")
    private WebElement mobileDeLogo;
}

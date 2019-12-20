package scenarion_context;

import gherkin.ast.Scenario;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Page;

import static stepDefinitions.Hooks.driver;

public class ScenarioContext {

    private static ScenarioContext instance = null;

    private Page currentPage;
    private Scenario scenario;
    private static WebElement webElement;

    private ScenarioContext() {
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
        PageFactory.initElements(driver, currentPage);

    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public WebElement getWebElement() {
        return webElement;
    }
    public void setWebElement(WebElement webElement) {
        ScenarioContext.webElement = webElement;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            return new ScenarioContext();
        } else return instance;
    }
}

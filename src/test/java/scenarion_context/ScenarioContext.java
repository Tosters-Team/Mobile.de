package scenarion_context;

import gherkin.ast.Scenario;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Page;

import static stepDefinitions.Hooks.driver;

public class ScenarioContext {

    private static ScenarioContext instance = null;

    private static Page currentPage;
    private Scenario scenario;

    private ScenarioContext() {
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
        PageFactory.initElements(driver, currentPage);

    }

    public Page getCurrentPage() {
        return currentPage;
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

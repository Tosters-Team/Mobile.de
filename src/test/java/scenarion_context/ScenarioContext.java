package scenarion_context;

import gherkin.ast.Scenario;
import pageObjects.Page;

public class ScenarioContext {

    private static ScenarioContext instance = null;

    private Page currentPage;
    private Scenario scenario;

    private ScenarioContext() {
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
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

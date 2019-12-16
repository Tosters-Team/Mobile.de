package scenarion_context;

import gherkin.ast.Scenario;
import pageObjects.InitPages;

public class ScenarioContext {

    private static ScenarioContext scenarioContext = null;
    private Scenario scenario;
    private InitPages currentPage;

    private ScenarioContext() {
    }

    public void setCurrentPage(InitPages currentPage) {
        this.currentPage = currentPage;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public InitPages getCurrentPage() {
        return currentPage;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public static ScenarioContext getInstance() {
        if (scenarioContext == null) {
            return new ScenarioContext();
        } else return scenarioContext;
    }
}

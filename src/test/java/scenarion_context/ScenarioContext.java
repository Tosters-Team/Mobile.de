package scenarion_context;

import gherkin.ast.Scenario;
import pageObjects.InitPages;

public class ScenarioContext {

    private static ScenarioContext instance = null;

    private InitPages currentPage;
    private Scenario scenario;

    public ScenarioContext() {
    }

    public void setCurrentPage(InitPages currentPage) {
        this.currentPage = currentPage;
    }

    public InitPages getCurrentPage() {
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

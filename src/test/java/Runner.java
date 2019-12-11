import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/testResources/features",
                  glue = "stepDefinitions",
                  tags = {"@TestTag"})
public class Runner {


}

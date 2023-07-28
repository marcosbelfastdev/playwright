package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import steps.screenContainerModel.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "steps", tags = "@dev2")
public class RunnerScreenContainerModel {

}

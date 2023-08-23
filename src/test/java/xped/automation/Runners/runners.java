package xped.automation.Runners;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"xped/automation/StepsDefinitions"},
        plugin = {"pretty","html:test-output"},
        dryRun = false,
        monochrome = true
)
public class runners {

}

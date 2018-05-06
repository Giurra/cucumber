package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:",
        glue = "classpath:steps",
        plugin = {"html:target/myreport"}
)
public class MyTests {

}

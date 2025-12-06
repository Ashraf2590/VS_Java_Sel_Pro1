package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/html-report/index.html",
        "json:target/cucumber-reports/json-report/cucumber.json",
        "junit:target/cucumber-reports/xml-report/cucumber.xml"
    },
    tags = "@smoke",
    tags = "@ashraf",
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

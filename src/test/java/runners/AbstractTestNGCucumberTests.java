package runners;

import org.testng.annotations.DataProvider;

public abstract class AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        // This should be overridden by subclasses to provide Cucumber scenarios
        return new Object[0][0];
    }
}

package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(

        features = "src/test/java/features",
        glue = "stepDefinitions",
        monochrome = true,
        publish = true,
        dryRun = false,
        tags = "@wip",
        plugin = {
                "pretty",
                "html:target/html-reports/cucumber.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                "rerun:target/failed_scenarios.txt"
        }
        )
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
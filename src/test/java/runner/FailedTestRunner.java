package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features="@target/failed.txt",
    glue={"stepdefinitions","hooks","api"},
    plugin={
        "pretty",
        "html:target/rerun-report.html"
    }
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
}
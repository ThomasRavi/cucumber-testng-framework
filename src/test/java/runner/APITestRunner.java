package runner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"api"},
        tags = "@api",
        plugin = {
                "pretty",
                "html:target/report.html",
                "rerun:target/failed.txt"
        }
)
public class APITestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
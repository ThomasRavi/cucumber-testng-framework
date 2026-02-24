package hooks;

import io.cucumber.java.*;
import driver.DriverFactory;
import utils.*;
import com.aventstack.extentreports.*;

public class Hooks {

    static ExtentReports extent = ExtentManager.getInstance();
    static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before("@ui")
    public void setup(Scenario scenario) {

        DriverFactory.initDriver(ConfigReader.get("browser"));

        ExtentTest extentTest =
            extent.createTest(scenario.getName());

        test.set(extentTest);
    }

    @After("@ui")
    public void tearDown(Scenario sc) {

        if (sc.isFailed()) {
            ScreenshotUtil.capture(sc.getName());
            test.get().fail("Test Failed");
        } else {
            test.get().pass("Test Passed");
        }

        DriverFactory.quit();
        extent.flush(); // VERY IMPORTANT
    }
}
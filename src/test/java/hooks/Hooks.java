package hooks;

import io.cucumber.java.*;
import driver.DriverFactory;
import utils.*;
import com.aventstack.extentreports.*;
import org.testng.Reporter;

public class Hooks {

    static ExtentReports extent = ExtentManager.getInstance();
    static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before("@ui")
    public void setup(Scenario scenario) {

        // Get browser directly from TestNG XML
        String browser = Reporter.getCurrentTestResult()
                .getTestContext()
                .getCurrentXmlTest()
                .getParameter("browser");

        if (browser == null) {
            browser = "chrome"; // fallback safety
        }

        DriverFactory.initDriver(browser);

        ExtentTest extentTest =
                extent.createTest(scenario.getName());

        test.set(extentTest);
    }

    @After("@ui")
    public void tearDown(Scenario sc) {

        if (sc.isFailed() && DriverFactory.getDriver() != null) {
            ScreenshotUtil.capture(sc.getName());
            test.get().fail("Test Failed");
        } else if (test.get() != null) {
            test.get().pass("Test Passed");
        }

        DriverFactory.quit();
    }

    @AfterAll
    public static void flushReport() {
        extent.flush();
    }
}
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static final String GRID_URL = "http://localhost:4444";

    public static void initDriver(String browser) {

        try {

            if (browser.equalsIgnoreCase("chrome")) {

                ChromeOptions options = new ChromeOptions();
                driver.set(new RemoteWebDriver(new URL(GRID_URL), options));

            } else if (browser.equalsIgnoreCase("firefox")) {

                FirefoxOptions options = new FirefoxOptions();
                driver.set(new RemoteWebDriver(new URL(GRID_URL), options));

            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.get().manage().window().maximize();

        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to Selenium Grid", e);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
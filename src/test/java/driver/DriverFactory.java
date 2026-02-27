package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        String executionMode = System.getProperty("execution", "local");

        try {

            if (executionMode.equalsIgnoreCase("grid")) {

                String gridUrl = "http://localhost:4444";

                if (browser.equalsIgnoreCase("chrome")) {
                    driver.set(new RemoteWebDriver(new URL(gridUrl), new ChromeOptions()));
                } else if (browser.equalsIgnoreCase("firefox")) {
                    driver.set(new RemoteWebDriver(new URL(gridUrl), new FirefoxOptions()));
                }

            } else { // LOCAL MODE

                if (browser.equalsIgnoreCase("chrome")) {
                    driver.set(new ChromeDriver());
                } else if (browser.equalsIgnoreCase("firefox")) {
                    driver.set(new FirefoxDriver());
                }

            }

            driver.get().manage().window().maximize();

        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed", e);
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
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit() {
        driver.get().quit();
        driver.remove();
    }
}
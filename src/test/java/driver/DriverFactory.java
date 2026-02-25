package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

    	if (browser.equalsIgnoreCase("chrome")) {

    	    WebDriverManager.chromedriver().setup();

    	    ChromeOptions options = new ChromeOptions();

    	    // Headless mode for CI
    	    if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
    	        options.addArguments("--headless=new");
    	        options.addArguments("--no-sandbox");
    	        options.addArguments("--disable-dev-shm-usage");
    	        options.addArguments("--window-size=1920,1080");
    	    }

    	    driver.set(new ChromeDriver(options));

    	}  else {
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
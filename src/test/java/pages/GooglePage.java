package pages;

import org.openqa.selenium.By;
import driver.DriverFactory;

public class GooglePage {

    By searchBox = By.name("q");

    public void open(String url) {
        DriverFactory.getDriver().get(url);
    }

    public void search(String text) {
        DriverFactory.getDriver().findElement(searchBox).sendKeys(text);
    }

    public String getTitle() {
        return DriverFactory.getDriver().getTitle();
    }
}
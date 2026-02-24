package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pages.GooglePage;
import utils.ConfigReader;

public class GoogleSteps {

GooglePage page = new GooglePage();

@Given("User opens Google")
public void open() {
    page.open(ConfigReader.get("url"));
}

@When("User searches {string}")
public void search(String text) {

    DriverFactory.getDriver()
        .findElement(By.name("q"))
        .sendKeys(text + Keys.ENTER);
    
    
    new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5))
    .until(ExpectedConditions.titleContains(text));
}
@Then("Title contains {string}")
public void verify(String exp) {
    assert page.getTitle().contains(exp);
}
}
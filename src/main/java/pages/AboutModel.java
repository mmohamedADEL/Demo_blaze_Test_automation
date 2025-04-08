package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutModel {
    private WebDriver driver;
    By CloseButton = By.xpath("(//button[contains(text(),'Close')])[4]");

    public AboutModel(WebDriver driver) {
        this.driver = driver;

        Navbar navbar = new Navbar(driver);
        navbar.clickOnAboutLink();

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseButton));
    }

    // Method to click the close button
    public void clickCloseButton() {
        driver.findElement(CloseButton).click();
    }
}


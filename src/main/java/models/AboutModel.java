package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;

public class AboutModel {
    private WebDriver driver;
    By CloseButton = By.xpath("(//button[contains(text(),'Close')])[4]");

    public AboutModel(WebDriver driver) {
        this.driver = driver;
        // Wait for the page to load
        Utility.waitForVisibility(driver, CloseButton);
    }

    // Method to click the close button
    public void clickCloseButton() {
        Utility.clickOnElement(driver, CloseButton);
    }
}


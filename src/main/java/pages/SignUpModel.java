package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;

public class SignUpModel {
    WebDriver driver;

    // Locators
    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By closeButton = By.xpath("//*[@id='signInModal'] //button[contains(text(),'Close')]");
    By signUpButton = By.xpath("//button[@onclick='register()']");
    public SignUpModel(WebDriver driver) {
        this.driver = driver;
        // Wait for the sign-up modal to be visible
        Utility.waitForVisibility(driver, usernameField);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }
    public SignUpModel InterUsername(String username) {
        Utility.sendData(driver, this.usernameField, username);
        return this;
    }

    public SignUpModel InterPassword(String password) {
        Utility.sendData(driver, this.passwordField, password);
        return this;
    }
    public SignUpModel clickSignUpButton() {
        Utility.clickOnElement(driver, signUpButton);
        return this;
    }
    public String getAlertMessage(){
        String alertText = Utility.getAlertMessageThenAccept(driver);
        return alertText;
    }
    public void clickCloseButton() {
        Utility.clickOnElement(driver, closeButton);
    }
    public HomePage AlertAccept() {
        Utility.acceptAlert(driver);
        return new HomePage(driver);
    }

}

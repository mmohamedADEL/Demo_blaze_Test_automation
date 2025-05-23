package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.LogUtility;
import utilities.Utility;

public class SignUpModel {
    WebDriver driver;

    // Locators
    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By closeButton = By.xpath("//*[@id='signInModal'] //button[contains(text(),'Close')]");
    By signUpButton = By.xpath("//button[@onclick='register()']");
    public SignUpModel(WebDriver driver) {
        this.driver = driver;
        Utility.waitForVisibility(driver, usernameField);
    }
    public SignUpModel InterUsername(String username) {
        Utility.sendData(driver, this.usernameField, username);
        LogUtility.info("Username entered: " + username);
        return this;
    }

    public SignUpModel InterPassword(String password) {
        Utility.sendData(driver, this.passwordField, password);
        LogUtility.info("Password entered: " + password);
        return this;
    }
    public SignUpModel clickSignUpButton() {
        Utility.clickOnElement(driver, signUpButton);
        return this;
    }
    public String getAlertMessage(){
        String alertText = Utility.getAlertMessageThenAccept(driver);
        LogUtility.info("Alert message: " + alertText);
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

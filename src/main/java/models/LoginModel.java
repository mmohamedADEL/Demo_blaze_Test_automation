package models;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilities.LogUtility;
import utilities.Utility;

import java.time.Duration;

public class LoginModel {
    WebDriver driver ;
    By Username_field = By.id("loginusername");
    By Password_Field = By.id("loginpassword");
    By loginSubmit = By.xpath("//button[@onclick='logIn()']");
    By closeButton = By.xpath("(//button[contains(text(),'Close')])[3]");
    public LoginModel(WebDriver driver) {
        this.driver = driver;
        // Wait for the login modal to be visible
        Utility.waitForVisibility(driver, Username_field);

    }
    public LoginModel InterUsername(String username) {
        Utility.sendData(driver, Username_field, username);
        LogUtility.info("Username entered: " + username);
        return this;
    }
    public LoginModel InterPassword(String password) {
        Utility.sendData(driver, Password_Field, password);
        LogUtility.info("Password entered: " + password);
        return this;
    }
    public HomePage clickLoginButton() {
        Utility.clickOnElement(driver, loginSubmit);
        return new HomePage(driver);
    }
    public String clickLoginExpectingAlert() {
        driver.findElement(loginSubmit).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        // Switch to the alert and get its text
        String alertText = Utility.getAlertMessageThenAccept(driver);
        LogUtility.info("Alert message: " + alertText);

        return alertText;
    }
    public void clickCloseButton() {
        Utility.clickOnElement(driver, closeButton);

    }
    public void AlertAccept() {
        Utility.acceptAlert(driver);
    }
    
}

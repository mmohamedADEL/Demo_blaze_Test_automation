package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        Navbar navbar = new Navbar(driver);
        navbar.clickOnLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(Username_field));

    }
    public LoginModel InterUsername(String username) {
        Utility.sendData(driver, Username_field, username);
        return this;
    }
    public LoginModel InterPassword(String password) {
        Utility.sendData(driver, Password_Field, password);
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
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
    public void clickCloseButton() {
        Utility.clickOnElement(driver, closeButton);

    }
    public void AlertAccept() {
        driver.switchTo().alert().accept();
    }
}

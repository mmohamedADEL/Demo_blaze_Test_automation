package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;

public class ContactModel {
    private WebDriver driver;
    public ContactModel(WebDriver driver) {
        this.driver = driver;
        Utility.waitForVisibility(driver, emailField);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
    }



    //define the locators for the contact form fields
    By contactButton = By.xpath("//a[contains(text(),'Contact')]");
    By emailField = By.id("recipient-email");
    By nameField = By.id("recipient-name");
    By messageField = By.id("message-text");
    By sendButton = By.xpath("//button[contains(text(),'Send message')]");
    By closeButton = By.xpath("//button[contains(text(),'Close')]");
    //define

    //method to fill in the contact form
    public ContactModel fillContactForm(String email, String name, String message) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(messageField).sendKeys(message);
        return this;
    }
    //method to click the send button
    public ContactModel clickSendButton() {
        driver.findElement(sendButton).click();
        return this;
    }
    //method to click the close button
    public ContactModel clickCloseButton() {
        driver.findElement(closeButton).click();
        return this;
    }
    //method to dismiss alert
    public HomePage dismissAlert() {
        driver.switchTo().alert().accept();
        return  new HomePage(driver);
    }



}

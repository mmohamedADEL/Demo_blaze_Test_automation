package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.LogUtility;
import utilities.Utility;

public class ContactModel {
    private WebDriver driver;
    public ContactModel(WebDriver driver) {
        this.driver = driver;
        Utility.waitForVisibility(driver, emailField);
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
        Utility.sendData(driver , emailField, email);
        LogUtility.info("Email entered: " + email);
        Utility.sendData(driver , nameField, name);
        LogUtility.info("Name entered: " + name);
        Utility.sendData(driver , messageField, message);
        LogUtility.info("Message entered: " + message);
        return this;
    }
    //method to click the send button
    public ContactModel clickSendButton() {
        Utility.clickOnElement(driver , sendButton);
        return this;
    }
    //method to click the close button
    public ContactModel clickCloseButton() {
        Utility.clickOnElement(driver , closeButton);
        return this;
    }
    //method to dismiss alert
    public HomePage acceptAlert() {
        Utility.acceptAlert(driver);
        return  new HomePage(driver);
    }



}

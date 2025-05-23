package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.HomePage;
import utilities.LogUtility;
import utilities.Utility;

import java.time.Duration;

public class PlaceOrderModel {
    WebDriver driver;

    // Define locators for elements on the place order page
    private final By name = By.id("name");
    private final By country = By.id("country");
    private final By city = By.id("city");
    private final By creditCard = By.id("card");
    private final By month = By.id("month");
    private final By year = By.id("year");
    private final By purchaseButton = By.xpath("//button[@onclick='purchaseOrder()']");
    private final By closeButton = By.xpath("(//button[contains(text(), 'Close')])[3]");
    private final By confirmButton = By.xpath("//button[text()='OK']");
    private final By alert = By.cssSelector("div.sweet-alert.showSweetAlert.visible");

    public PlaceOrderModel(WebDriver driver) {
        this.driver = driver;
        // Wait for the page to load
        Utility.waitForVisibility(driver, name);
    }
    public PlaceOrderModel enterName(String nameText) {
        Utility.sendData(driver, name, nameText);
        LogUtility.info("Name entered: " + nameText);
        return this;
    }
    public PlaceOrderModel enterCountry(String countryText) {
        Utility.sendData(driver, country, countryText);
        LogUtility.info("Country entered: " + countryText);
        return this;
    }
    public PlaceOrderModel enterCity(String cityText) {
        Utility.sendData(driver, city, cityText);
        LogUtility.info("City entered: " + cityText);
        return this;
    }
    public PlaceOrderModel enterCreditCard(String cardText) {
        Utility.sendData(driver, creditCard, cardText);
        LogUtility.info("Credit card entered: " + cardText);
        return this;
    }
    public PlaceOrderModel enterMonth(String monthText) {
        Utility.sendData(driver, month, monthText);
        LogUtility.info("Month entered: " + monthText);
        return this;
    }

    public PlaceOrderModel enterYear(String yearText) {
        Utility.sendData(driver, year, yearText);
        LogUtility.info("Year entered: " + yearText);
        return this;
    }
    public PlaceOrderModel clickOnPurchaseButton() {
        Utility.clickOnElement(driver, purchaseButton);
        return this;
    }
    public CartPage clickOnCloseButton() {
        Utility.clickOnElement(driver, closeButton);
        return new CartPage(driver);
    }
    public HomePage clickOnConfirmButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
        Utility.clickOnElement(driver, confirmButton);
        return new HomePage(driver);
    }
    public void placeOrder(String nameText, String countryText, String cityText, String cardText, String monthText, String yearText) {
        enterName(nameText);
        enterCountry(countryText);
        enterCity(cityText);
        enterCreditCard(cardText);
        enterMonth(monthText);
        enterYear(yearText);
        clickOnPurchaseButton();
        clickOnCloseButton();
        clickOnConfirmButton();
    }
    public void ClearName()
    {
        driver.findElement(name).clear();
    }
    public void ClearCountry()
    {
        driver.findElement(country).clear();
    }
    public void ClearCity()
    {
        driver.findElement(city).clear();
    }
    public void ClearCard()
    {
        driver.findElement(creditCard).clear();
    }
    public void ClearMonth()
    {
        driver.findElement(month).clear();
    }
    public void ClearYear()
    {
        driver.findElement(year).clear();
    }

    public String getAlertText() {
        // Wait for the alert to be visible
        Utility.waitForVisibility(driver, alert);
        // Switch to the alert and get its text
        String alertText = Utility.getAlertMessage(driver);
        LogUtility.info("Alert message: " + alertText);
        return Utility.getAlertMessageThenAccept(driver);
    }
    public String getAlertTextThenAccept() {
        return Utility.getAlertMessageThenAccept(driver);

    }
    public boolean isConfirmationButtonDisabled() {
        return driver.findElement(confirmButton).getAttribute("disabled") != null;
    }







}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(name));
    }
    public PlaceOrderModel enterName(String nameText) {
        Utility.sendData(driver, name, nameText);
        return this;
    }
    public PlaceOrderModel enterCountry(String countryText) {
        Utility.sendData(driver, country, countryText);
        return this;
    }
    public PlaceOrderModel enterCity(String cityText) {
        Utility.sendData(driver, city, cityText);
        return this;
    }
    public PlaceOrderModel enterCreditCard(String cardText) {
        Utility.sendData(driver, creditCard, cardText);
        return this;
    }
    public PlaceOrderModel enterMonth(String monthText) {
        Utility.sendData(driver, month, monthText);
        return this;
    }

    public PlaceOrderModel enterYear(String yearText) {
        Utility.sendData(driver, year, yearText);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
        return driver.findElement(alert).getText();
    }

}

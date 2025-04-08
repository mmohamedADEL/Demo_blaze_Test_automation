package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderModel {
    WebDriver driver;

    // Define locators for elements on the place order page
    By name = By.id("name");
    By country = By.id("country");
    By city = By.id("city");
    By creditCard = By.id("card");
    By month = By.id("month");
    By year = By.id("year");
    By purchaseButton = By.xpath("//button[@onclick='purchaseOrder()']");
    By closeButton = By.xpath("(//button[contains(text(), 'Close')])[3]");

    public PlaceOrderModel(WebDriver driver) {
        this.driver = driver;
        new CartPage(driver).clickOnPlaceOrderButton();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
    }


}

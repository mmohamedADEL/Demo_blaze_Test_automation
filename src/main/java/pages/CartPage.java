package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class CartPage {
    private WebDriver driver;
    // Define locators for elements on the cart page
    By placeOrderButton = By.xpath("//button[@data-target=\"#orderModal\"]");
    public CartPage(WebDriver driver) {

        this.driver = driver;
    }
    public void clickOnPlaceOrderButton() {
        Utility.clickOnElement(driver, placeOrderButton);

    }
    public PlaceOrderModel navigatePlaceOrderModel() {
        Utility.clickOnElement(driver, placeOrderButton);
        return new PlaceOrderModel(driver);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class ProductPage {
    private WebDriver driver;

    // Define locators for elements on the product page
    By addToCartButton = By.xpath("//a[@onclick='addToCart(1)']");
    By cartButton = By.id("cartur");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage clickOnAddToCartButton() {
        Utility.clickOnElement(driver, addToCartButton);
        return this;
    }
    public CartPage navigateToCart() {

        Utility.clickOnElement(driver, cartButton);
        return new CartPage(driver);
    }
    public ProductPage acceptAlert() {
        Utility.acceptAlert(driver);
        return new ProductPage(driver);
    }
}

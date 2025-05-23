package pages;

import models.Navbar;
import models.PlaceOrderModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Utility;


import java.util.List;

public class CartPage {
    private WebDriver driver;
    // Define locators for elements on the cart page
    private final By placeOrderButton = By.xpath("//button[@data-target=\"#orderModal\"]");
    private final By productRows = By.xpath("//tr");
    private final By totalPrice = By.id("totalp");
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
    public HomePage navigateToHomePage() {
        new Navbar(driver).clickOnHomeLink();
        return new HomePage(driver);
    }
    public int calculateTotalPriceFromItems() {
        List<WebElement> rows = driver.findElements(productRows);
        int sum = 0;

        for (WebElement row : rows) {
            WebElement priceCell = row.findElement(By.xpath(".//td[3]"));
            sum += Integer.parseInt(priceCell.getText().trim());
        }
        return sum;
    }

    public int getDisplayedTotalFromUI() {
        String totalText = driver.findElement(totalPrice).getText().trim();
        return Integer.parseInt(totalText);
    }

    public void deleteProductByName(String productName) {
        List<WebElement> rows = driver.findElements(productRows);

        for (WebElement row : rows) {
            if (row.getText().contains(productName)) {
                // Delete button is in the 4th column
                WebElement deleteButton = row.findElement(By.xpath(".//td[4]/a"));
                deleteButton.click();
                break;
            }
        }
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> productNames = driver.findElements(By.xpath("//tbody[@id='tbodyid']/tr/td[2]"));
        // Check if the product name exists in the list of product names
        for (WebElement product : productNames) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

}

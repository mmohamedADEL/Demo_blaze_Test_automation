package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private final By welcomeMessage = By.id("nameofuser");
    private final By logoutButton = By.id("logout2");
    private final By loginButton = By.id("login2");
    private final By cartButton = By.id("cartur");
    private final By SignUpButton = By.id("signin2");

    private final By PhoneCategory = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private final By LapTopCategory = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private final By ScreenCategory = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private final By username = By.id("inputUsername");
    private final By NextButton = By.id("next2");
    private final By PreviousButton = By.id("prev2");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnLogoutButton() {
        Utility.clickOnElement(driver, logoutButton);
    }
    public By getCategoryLocator(String categoryText) {
        return By.xpath("//a[@id='itemc' and @onclick=\"byCat('" + categoryText + "')\"]");
    }

    public HomePage  clickOnCategory(String category) {
        Utility.waitForElementToBeClickable(driver, getCategoryLocator(category));
        Utility.clickOnElement(driver,getCategoryLocator(category));
        return this;
    }
    public By getProductByName(String productName) {
        return By.xpath("//a[@class='hrefch' and contains(text(), '" + productName + "')]");
    }
    public ProductPage clickOnProductByName(String productName) {
        Utility.clickOnElement(driver, getProductByName(productName));
        return new ProductPage(driver);
    }
    public ProductPage FindProduct(String category ,String productName) {
        clickOnCategory(category);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getProductByName(productName)));

        Utility.clickOnElement(driver, getProductByName(productName));
        return new ProductPage(driver);
    }
    public CartPage navigateToCartPage() {
        Utility.clickOnElement(driver, cartButton);
        return new CartPage(driver);
    }
    public String getWelcomeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        return driver.findElement(welcomeMessage).getText();
    }
    public LoginModel navigateToLoginModel() {
        Utility.clickOnElement(driver, loginButton);
        return new LoginModel(driver);
    }
    public SignUpModel navigateToSignUpModel() {
        Utility.clickOnElement(driver, SignUpButton);
        return new SignUpModel(driver);
    }

}

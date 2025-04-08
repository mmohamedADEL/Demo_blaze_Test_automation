package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class Navbar {

    private WebDriver driver;
     private final By homeLink = By.xpath("//a[@class=\"nav-link\" and @href=\"index.html\"]");
     private final By aboutLink = By.xpath("//*[@data-target=\"#videoModal\"]");
     final By contact = By.xpath("//*[@data-target=\"#exampleModal\"]");
     private final  By cart= By.id("cartur");
     private final By login = By.id("login2");
     private final By signUp = By.id("signin2");

    public Navbar(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage clickOnHomeLink() {
        Utility.clickOnElement(driver, homeLink);
        return new HomePage(driver);
    }
    public void openContactPopup() {
        Utility.clickOnElement(driver, contact);
       // return new ContactModel(driver);
    }
    public void clickOnAboutLink() {
        Utility.clickOnElement(driver, aboutLink);
        //return new AboutPage(driver);
    }
    public CartPage clickOnCart() {
        Utility.clickOnElement(driver, cart);
        return new CartPage(driver);
    }
    public void clickOnLogin() {
        Utility.clickOnElement(driver, login);
       // return new LoginModel(driver);
    }
    public void ClickOnSignUp() {
        Utility.clickOnElement(driver, signUp);
    }


}

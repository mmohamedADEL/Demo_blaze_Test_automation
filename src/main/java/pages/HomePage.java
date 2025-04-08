package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private final By welcomeMessage = By.id("nameofuser");
    private final By logoutButton = By.id("logout2");
    private final By cartButton = By.id("cartur");
    private final By PhoneCategory = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private final By LapTopCategory = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private final By ScreenCategory = By.xpath("//a[@onclick=\"byCat('monitor')\"]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By username = By.id("inputUsername");
    public String getWelcomeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        return driver.findElement(welcomeMessage).getText();
    }

}

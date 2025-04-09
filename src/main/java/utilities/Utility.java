package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {
    //TODO: Clicking on element
    public static void clickOnElement(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }
    //TODO: Sending date to elements
    public static void sendData(WebDriver driver,By locator,String text)
    {
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }
    //TODO: generate visibility wait
    public static void waitForVisibility(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By cartButton) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(cartButton));
    }

    //TODO: get alert message

    public static String getAlertMessageThenAccept(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    // Method to accept the alert
    public static void acceptAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
       driver.switchTo().alert().accept();
    }

}

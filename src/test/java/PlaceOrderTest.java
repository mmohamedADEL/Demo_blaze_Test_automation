import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.PlaceOrderModel;

public class PlaceOrderTest {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/cart.html");
    }
    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
           driver.quit();
        }
    }
@Test
public void testPlaceOrder() {

    PlaceOrderModel placeOrder = new PlaceOrderModel(driver);

    placeOrder.enterCreditCard("1234567890123456")
            .enterName("John Doe")
            .enterCountry("USA")
            .enterCity("New York")
            .enterMonth("January")
            .enterYear("2025")
            .clickOnPurchaseButton()
            .clickOnConfirmButton();
}


}

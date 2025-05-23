import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import models.PlaceOrderModel;
import utilities.DataUtil;

public class PurchaseWithoutLogin {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void buyWithoutLogin(){

        HomePage homePage = new HomePage(driver);
        homePage.FindProduct("phone","Iphone 6 32gb")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToCart()
                .navigatePlaceOrderModel()
                .enterCreditCard(DataUtil.getJsonData("TestData","CheckoutData","CreditCard"))
                .enterName(DataUtil.getJsonData("TestData","CheckoutData","Name"))
                .clickOnPurchaseButton();
        Assert.assertEquals(new PlaceOrderModel(driver).getAlertText(),"Please Login To Confirm Order");

    }

}

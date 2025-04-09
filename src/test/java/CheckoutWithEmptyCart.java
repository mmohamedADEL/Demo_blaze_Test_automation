import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginModel;
import pages.PlaceOrderModel;
import pages.ProductPage;
import utilities.DataUtil;

public class CheckoutWithEmptyCart {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkOutWithEmptyCard(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginModel();
        LoginModel loginModel = new LoginModel(driver);
        homePage = loginModel.InterUsername(DataUtil.getJsonData("TestData","LoginCred","username"))
                .InterPassword(DataUtil.getJsonData("TestData","LoginCred","password"))
                .clickLoginButton();
        Assert.assertTrue(homePage.getWelcomeText().contains("7amada"));

        ProductPage productPage = new ProductPage(driver);
        productPage.navigateToCart()
                .navigatePlaceOrderModel()
                .enterCreditCard(DataUtil.getJsonData("TestData","CheckoutData","CreditCard"))
                .enterName(DataUtil.getJsonData("TestData","CheckoutData","Name"))
                .clickOnPurchaseButton();
        Assert.assertEquals(new PlaceOrderModel(driver).getAlertText(),"The cart is empty");

    }
}

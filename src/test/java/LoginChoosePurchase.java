import com.beust.ah.A;
import models.PlaceOrderModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import models.LoginModel;
import utilities.DataUtil;
import utilities.LogUtility;

public class LoginChoosePurchase {
    WebDriver driver;

    @BeforeMethod
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
    public void happyScenario(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginModel();
        LoginModel loginModel = new LoginModel(driver);
        homePage = loginModel.InterUsername(DataUtil.getJsonData("TestData","LoginCred","username"))
                .InterPassword(DataUtil.getJsonData("TestData","LoginCred","password"))
                .clickLoginButton();
        Assert.assertTrue(homePage.getWelcomeText().contains("7amada"));
        LogUtility.info("Login successful");
        homePage.FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToCart()
                .navigatePlaceOrderModel()
                .enterCreditCard(DataUtil.getJsonData("TestData","CheckoutData","CreditCard"))
                .enterName(DataUtil.getJsonData("TestData","CheckoutData","Name"))
                .enterCity(DataUtil.getJsonData("TestData","CheckoutData","City"))
                .enterCountry(DataUtil.getJsonData("TestData","CheckoutData","Country"))
                .enterMonth(DataUtil.getJsonData("TestData","CheckoutData","Month"))
                .enterYear(DataUtil.getJsonData("TestData","CheckoutData","Year"))
                .clickOnPurchaseButton()
                .clickOnConfirmButton();

        homePage.clickOnLogoutButton();

    }
    @Test
    public void validateSendStringInCreditCardField(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginModel();
        LoginModel loginModel = new LoginModel(driver);
        homePage = loginModel.InterUsername(DataUtil.getJsonData("TestData","LoginCred","username"))
                .InterPassword(DataUtil.getJsonData("TestData","LoginCred","password"))
                .clickLoginButton();
        Assert.assertTrue(homePage.getWelcomeText().contains("7amada"));
        LogUtility.info("Login successful");
        homePage.FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToCart()
                .navigatePlaceOrderModel()
                .enterCreditCard("string")
                .enterName(DataUtil.getJsonData("TestData","CheckoutData","Name"))
                .enterCity(DataUtil.getJsonData("TestData","CheckoutData","City"))
                .enterCountry(DataUtil.getJsonData("TestData","CheckoutData","Country"))
                .enterMonth(DataUtil.getJsonData("TestData","CheckoutData","Month"))
                .enterYear(DataUtil.getJsonData("TestData","CheckoutData","Year"))
                .clickOnPurchaseButton();
        //assert that an alert appears
        Assert.assertTrue(new PlaceOrderModel(driver).isConfirmationButtonDisabled());
    }

}

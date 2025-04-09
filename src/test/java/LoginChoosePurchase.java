import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginModel;
import utilities.DataUtil;

public class LoginChoosePurchase {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
   /* @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }*/

    @Test(invocationCount = 3)
    public void happyScenario(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateToLoginModel();
        LoginModel loginModel = new LoginModel(driver);
        homePage = loginModel.InterUsername(DataUtil.getJsonData("TestData","LoginCred","username"))
                .InterPassword(DataUtil.getJsonData("TestData","LoginCred","password"))
                .clickLoginButton();
        Assert.assertTrue(homePage.getWelcomeText().contains("7amada"));

        homePage.FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToCart()
                .navigatePlaceOrderModel()
                .enterCreditCard(DataUtil.getJsonData("TestData","CheckoutData","CreditCard"))
                .enterName(DataUtil.getJsonData("TestData","CheckoutData","Name"))
                .clickOnPurchaseButton()
                .clickOnConfirmButton();

        homePage.clickOnLogoutButton();

    }

}

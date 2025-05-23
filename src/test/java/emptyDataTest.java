import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import models.PlaceOrderModel;
import utilities.DataUtil;

public class emptyDataTest {

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
    public void testBuyProductWithEmptyCreditCard(){
        HomePage homePage = new HomePage(driver);

        homePage.navigateToLoginModel().InterUsername(DataUtil.getJsonData("TestData","LoginCred","username"))
                .InterPassword(DataUtil.getJsonData("TestData","LoginCred","password"))
                .clickLoginButton();
        Assert.assertTrue(homePage.getWelcomeText().contains("7amada"));

        String text =homePage.FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToCart()
                .navigatePlaceOrderModel()
                .enterCreditCard("")
                .enterName("")
                .clickOnPurchaseButton()
                .getAlertTextThenAccept();


        Assert.assertEquals(text,"Please fill out Name and Creditcard.");

                new PlaceOrderModel(driver).clickOnCloseButton();
            homePage.clickOnLogoutButton();


    }



}

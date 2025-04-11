import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactModel;
import pages.HomePage;
import pages.Navbar;
import utilities.DataUtil;

public class ContactUsTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

    }

    @Test(invocationCount = 3)
    public void validContactUs()
    {
        HomePage homePage = new HomePage(driver);

        homePage.navigateToLoginModel().InterUsername(DataUtil.getJsonData("TestData","LoginCred","username"))
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

        new Navbar(driver).openContactPopup();

        new ContactModel(driver).fillContactForm(DataUtil.getJsonData("TestData","ContactData","email"),DataUtil.getJsonData("TestData","ContactData","name"),DataUtil.getJsonData("TestData","ContactData","message"))
                .clickSendButton()
                .dismissAlert();
        homePage.clickOnLogoutButton();






    }


}

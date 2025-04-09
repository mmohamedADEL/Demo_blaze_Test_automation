import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class Home_test {
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

    }
    /*@AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }*/
   /* @Test
   public void testSendMessage() {
        // Navigate to the contact form
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo

        // Fill in the contact form and send the message
        contact.fillContactForm("test@example.com", "Test User", "This is a test message")
                .clickSendButton()
                .dismissAlert();

        // Add assertions here if needed to verify the behavior
    }*/
//    @Test
//    public void testAboutUs() {
//        // Navigate to the "About Us" page
//        AboutModel aboutPage = new AboutModel(driver);
//        aboutPage.clickCloseButton();
//
//        // Add assertions here if needed to verify the behavior
//    }
    @Test
   public void loginandSignUP(){
        HomePage homePage = new HomePage(driver);


        homePage.navigateToSignUpModel()
                .InterUsername("seswwwd/8")
                        .InterPassword("123456")
                                .clickSignUpButton()
                .AlertAccept()
                .navigateToLoginModel()
                .InterUsername("seswwwd/8")
                        .InterPassword("123456")
                                .clickLoginButton()
                .navigateToAbout()
                    .clickCloseButton();





    }



    @Test()
    public void testChooseProduct(){
            HomePage homePage = new HomePage(driver);
        homePage.FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToCart()
                .navigatePlaceOrderModel()
                .enterCreditCard("1234567890123456")
                .enterName("John Doe")
                .clickOnPurchaseButton()
                .clickOnConfirmButton();
    }

    @Test
    public void CartTest(){
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToHomePage()
                .FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToHomePage()
                .FindProduct("phone","Samsung galaxy s6")
                .clickOnAddToCartButton()
                .acceptAlert()
                .navigateToCart();
//        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6") ,
//                "Product is not in the cart");
        Assert.assertEquals(cartPage.calculateTotalPriceFromItems(), cartPage.getDisplayedTotalFromUI(),
                "Total price calculation is incorrect");

    }





}


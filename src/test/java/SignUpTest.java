import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpModel;

public class SignUpTest {
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
    public void validSignUp(){
        SignUpModel signUp = new SignUpModel(driver);
        String alertMessage = signUp
                .InterUsername("7amoda")
                .InterPassword("123456")
                .clickSignUpButton()
                .getAlertMessage();
        Assert.assertTrue(alertMessage.contains("Sign up successful"));
    }
    @Test
    //with empty field
    public void invalidSignUp(){
        SignUpModel signUp = new SignUpModel(driver);
        String alertMessage = signUp
                .InterUsername("testuser")
                .clickSignUpButton()
                .getAlertMessage();
        Assert.assertTrue(alertMessage.contains("Please fill out Username and Password."));
    }
    @Test
    public void exsistUserName(){
        SignUpModel signUp = new SignUpModel(driver);
        String alertMessage = signUp
                .InterUsername("7amada")
                .InterPassword("12395")
                .clickSignUpButton()
                .getAlertMessage();
        Assert.assertTrue(alertMessage.contains("exist"));
    }

}

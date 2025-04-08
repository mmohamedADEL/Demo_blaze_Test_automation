import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import pages.AboutModel;
import pages.ContactModel;

public class Home_test {
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
    public void testSendMessage() {
        // Navigate to the contact form
        ContactModel contact = new ContactModel(driver);

        // Fill in the contact form and send the message
        contact.fillContactForm("test@example.com", "Test User", "This is a test message")
                .clickSendButton()
                .dismissAlert();

        // Add assertions here if needed to verify the behavior
    }
    @Test
    public void testAboutUs() {
        // Navigate to the "About Us" page
        AboutModel aboutPage = new AboutModel(driver);
        aboutPage.clickCloseButton();

        // Add assertions here if needed to verify the behavior
    }


}


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.URL;

public class LoginTests {
    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_x86_64");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\chromedriver_win32\\chromedriver-win64");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        // Navigate to the login page
        driver.get("https://testserver.moveitcloud.com/");

        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        // Replace with actual test steps
        loginPage.loginAs("interview.bocho.bochev", "EBnYQ5-G");

        // Add assertions and validations here
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
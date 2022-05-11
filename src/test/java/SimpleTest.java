import config.CapabilitiesManager;
import config.ConfigurationManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SimpleTest {

    private static final String APP = CapabilitiesManager.capabilities().app(); //"https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    private static final String APPIUM = ConfigurationManager.configuration().Appium();//"http://localhost:4723/wd/hub";

    //private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    //private static final String APPIUM = "http://localhost:4723/wd/hub";

    private AndroidDriver driver;

    @Before()
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "9");
//        caps.setCapability("deviceName", "Android Emulator");
//        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", APP);
        driver = new AndroidDriver(new URL(APPIUM), caps);
    }

    @After()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("List Demo")));
        screen.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Altocumulus")));

        // WebElement elemByID = driver.findElementById("elem-id-here");
        // AndroidElement elemByID = (AndroidElement) driver.findElementById("elem-id-here");

        //WebElement accEleme1 = driver
        //        .findElementByAndroidUIAutomator("resourceId(\"android:id/text1");



    }
}

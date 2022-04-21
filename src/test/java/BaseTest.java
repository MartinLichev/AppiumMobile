import config.CapabilitiesManager;
import config.ConfigurationManager;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MenuPage;

import java.net.MalformedURLException;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;
    protected static MenuPage menuPage;
    protected int waitTime = 0;

    @Before
    public void suiteSetup() throws MalformedURLException {
        String platformName = CapabilitiesManager.capabilities().platformName();
        driver = DriverManager.createInstance(platformName);

        wait = new WebDriverWait(driver, ConfigurationManager.configuration().waitTime());
        waitTime = ConfigurationManager.configuration().waitTime();

        menuPage = new MenuPage(driver);
    }

    @After
    public void suiteTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

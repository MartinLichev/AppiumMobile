import config.CapabilitiesManager;
import config.ConfigurationManager;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import pages.MenuPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static MenuPage menuPage;
    protected int waitTime = 0;

    @Before
    public void suiteSetup() throws MalformedURLException {
        String platformName = CapabilitiesManager.capabilities().platformName();
        driver = DriverManager.createInstance(platformName);

        waitTime = ConfigurationManager.configuration().waitTime();
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);

        menuPage = new MenuPage(driver);
    }

    @After
    public void suiteTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

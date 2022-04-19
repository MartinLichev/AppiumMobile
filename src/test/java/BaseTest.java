import config.CapabilitiesManager;
import config.ConfigurationManager;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;
    protected int waitTime = 0;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetup(){
        String platformName = CapabilitiesManager.capabilities().platformName();
        driver = DriverManager.createInstance(platformName);

        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigurationManager.configuration().waitTime()).getSeconds());
        waitTime = ConfigurationManager.configuration().waitTime();
    }

    @AfterSuite(alwaysRun = true)
    public void suiteTearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}

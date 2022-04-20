package driver;

import config.CapabilitiesManager;
import config.ConfigurationManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverManager {

    public static AppiumDriver createInstance(String platformName) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", CapabilitiesManager.capabilities().platformName());
        capabilities.setCapability("deviceName", CapabilitiesManager.capabilities().deviceName());
        capabilities.setCapability("app", CapabilitiesManager.capabilities().app());

        AppiumDriver driver = null;
        DriverType platform = DriverType.getDriverByName(platformName);

        switch (platform) {
            case ANDROID:
                driver = new AndroidDriver(ConfigurationManager.configuration().Appium(), capabilities);
                break;

            case IOS:
                /*TODO*/
                break;
        }

        return driver;
    }
}

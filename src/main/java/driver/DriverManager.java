package driver;

import config.CapabilitiesManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static final String APPIUM = "http://localhost:4723/wd/hub";
    private static AppiumDriver driver;

    /**
     * Creates an instance based on capabilities.properties
     *
     * @param platformName Android/IoS
     * @return driver of the desired type Android/IoS
     */
    public static AppiumDriver createInstance(String platformName) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", CapabilitiesManager.capabilities().platformName());
        capabilities.setCapability("deviceName", CapabilitiesManager.capabilities().deviceName());
        capabilities.setCapability("app", CapabilitiesManager.capabilities().app());

        DriverType platform = DriverType.getDriverByName(platformName);

        switch (platform) {
            case ANDROID:
                try {
                    driver = new AndroidDriver(new URL(APPIUM), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case IOS:
                /*TODO*/
                break;
        }
        return driver;
    }
}

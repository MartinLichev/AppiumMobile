package pages;

import config.ConfigurationManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static java.time.Duration.*;

/**
 * Provides drive, timeout and initialization of elements to child pages (PageFactory)
 */
public abstract class BasePage {

    private static final int TIMEOUT = ConfigurationManager.configuration().waitTime();
    AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(TIMEOUT)), this);
    }
}

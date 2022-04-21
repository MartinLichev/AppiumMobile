package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@UtilityClass
public class ElementUtils {

    public static String formatXpath(String xpath, Object... param) {
        return String.format(xpath, param);
    }

    /**
     * Builds a WebElement by providing non-formatted xpath and preferred params to it
     *
     * @param driver
     * @param xpath
     * @param param
     * @return The WebElement found by the driver
     */
    public static WebElement buildWebElement(AppiumDriver driver, String xpath, Object... param) {
        return driver.findElementByXPath(formatXpath(formatXpath(xpath,param)));
    }
}

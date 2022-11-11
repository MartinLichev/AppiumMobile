package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

import java.util.List;

@UtilityClass
public class ElementUtils {

    /**
     * Formats the parametrized xpath String with provided n String params
     * @param xpath  parametrized String
     * @param param  the Sting params of the xpath
     * @return String with applied params
     */
    public static String formatXpath(String xpath, Object... param) {
        return String.format(xpath, param);
    }

    /**
     * Builds a WebElement by providing non-formatted xpath and preferred params to it
     *
     * @param driver Android/IoS
     * @param xpath  parametrized String
     * @param param  the Sting params of the xpath
     * @return The WebElement found by the driver
     */
    public static MobileElement buildWebElement(AppiumDriver driver, String xpath, Object... param) {
        return (MobileElement) driver.findElementByXPath(formatXpath(formatXpath(xpath, param)));
    }

    /**
     * Builds a List<MobileElement> by providing non-formatted xpath and preferred params to it
     *
     * @param driver Android/IoS
     * @param xpath  parametrized String
     * @param param  the Sting params of the xpath
     * @return The List<MobileElement> found by the driver
     */
    public static List<MobileElement> buildWebElements(AppiumDriver driver, String xpath, Object... param) {
        return driver.findElements(By.xpath(formatXpath(xpath, param)));
    }

    /**
     * Clicks on a MobileElement from a list of MobileElements which contains a specific text
     *
     * @param list List of MobileElement to be iterated
     * @param txt  Text contained by the desired mobileElement to be clicked
     */
    public static void clkElementFromListByTxt(List<MobileElement> list, String txt) {
        for (MobileElement element : list) {
            if (element.getText().equals(txt)) {
                element.click();
                break;
            }
        }
    }
}

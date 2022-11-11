package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;

import static utils.ElementUtils.buildWebElement;

public class EchoBoxPage extends BasePage {

    public static final String MSG_TEXT_XPATH = "//android.widget.TextView[@content-desc='%s']";

    public EchoBoxPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "messageInput")
    private MobileElement loc_inputMsg;

    @AndroidFindBy(accessibility = "messageSaveBtn")
    private MobileElement loc_btnSave;

    private MobileElement loc_txtMsg;

    public void setMsg(String msg) {
        loc_inputMsg.sendKeys(msg);
    }

    /**
     * Clicks on Save button
     * @return new instance of EchoBoxPage
     */
    public EchoBoxPage clkSaveBtn() {
        loc_btnSave.click();
        return new EchoBoxPage(driver);
    }

    /**
     * Check if a message with specific text is displayed
     * @param msg the desired text
     * @return true if displayed, false if not
     */
    public boolean isMsgDisplayed(String msg) {
        try {
            loc_txtMsg = buildWebElement(driver, MSG_TEXT_XPATH, msg);
            loc_txtMsg.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Test message " + msg + " is not displayed!");
            return false;
        }
        return true;
    }
}

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static utils.ElementUtils.buildWebElement;

public class EchoBoxPage {

    public static final String MSG_TEXT_XPATH = "//android.widget.TextView[@content-desc='%s']";

    AppiumDriver driver;

    public EchoBoxPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "messageInput")
    private MobileElement loc_inputMsg;

    @AndroidFindBy(accessibility = "messageSaveBtn")
    private MobileElement loc_btnSave;

    private WebElement loc_txtMsg;

    public void setMsg(String msg) {
        loc_inputMsg.sendKeys(msg);
    }

    public EchoBoxPage clkSaveBtn(){
        loc_btnSave.click();
        return new EchoBoxPage(driver);
    }

    public boolean isMsgDisplayed(String msg){
        try {
            loc_txtMsg = buildWebElement(driver, MSG_TEXT_XPATH, msg);
            loc_txtMsg.isDisplayed();
        } catch (NoSuchElementException e){
            System.out.println("Test message " + msg + " is not displayed!");
            return false;
        }
        return true;
    }
}

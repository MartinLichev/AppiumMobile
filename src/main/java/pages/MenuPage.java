package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    AppiumDriver driver;

    public MenuPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Echo Box")
    private MobileElement loc_btnEchoBox;

    public EchoBoxPage clkEchoBoxBtn() {
        loc_btnEchoBox.click();
        return new EchoBoxPage(driver);
    }
}

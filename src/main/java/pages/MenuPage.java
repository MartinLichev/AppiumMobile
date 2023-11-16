package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

    public MenuPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Echo Box")
    private MobileElement loc_btnEchoBox;

    /**
     * Clicks on echo box option
     *
     * @return new instance of EchoBoxPage
     */
    public EchoBoxPage clkEchoBoxBtn() {
        loc_btnEchoBox.click();
        return new EchoBoxPage(driver);
    }
}

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    AppiumDriver driver;
    int waitTime = 0;

    public SignInPage(AppiumDriver driver, int waitTime) {
        this.driver = driver;
        this.waitTime = waitTime;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Login Screen")
    private WebElement loc_btnSignIn;

    public void clkSignInBtn() {
        loc_btnSignIn.click();
    }
}

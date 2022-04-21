import org.junit.Test;
import pages.SignInPage;

public class SignInTest extends BaseTest {


    @Test
    public void googleSignIn() {
        driver.resetApp();

        SignInPage signInPage = new SignInPage(driver);

        signInPage.clkSignInBtn();
    }
}

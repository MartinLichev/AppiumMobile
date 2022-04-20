import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInTest extends BaseTest{
    SignInPage signInPage;

    @Test
    public void googleSignIn(){
        signInPage.clkSignInBtn();
    }
}

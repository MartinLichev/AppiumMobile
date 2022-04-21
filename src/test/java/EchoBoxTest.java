import org.junit.Assert;
import org.junit.Test;
import pages.EchoBoxPage;

public class EchoBoxTest extends BaseTest{

    EchoBoxPage echoBoxPage;

    @Test
    public void sendKeyEchoBox(){
        driver.resetApp();

        echoBoxPage = menuPage.clkEchoBoxBtn();

        echoBoxPage.setMsg("test");
        echoBoxPage = echoBoxPage.clkSaveBtn();

        Assert.assertTrue(echoBoxPage.isMsgDisplayed("test"));
    }
}

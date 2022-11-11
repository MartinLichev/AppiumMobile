import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EchoBoxPage;
import pages.MenuPage;

public class EchoBoxTest extends BaseTest {

    EchoBoxPage echoBoxPage;

    MenuPage menuPage;

    @Override
    public void preconditions() {
        resetApp();
        menuPage = new MenuPage(getDriver());
        echoBoxPage = menuPage.clkEchoBoxBtn();
    }

    @Test
    public void sendKeyEchoBox() {
        echoBoxPage.setMsg("test");
        echoBoxPage = echoBoxPage.clkSaveBtn();

        Assert.assertTrue(echoBoxPage.isMsgDisplayed("test"));
    }
}

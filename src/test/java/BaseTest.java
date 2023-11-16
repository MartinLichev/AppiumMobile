import config.CapabilitiesManager;
import config.ConfigurationManager;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public abstract class BaseTest {

    private static AppiumDriver driver;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd.HHmmss");
    private final String URL_REPORT = System.getProperty("user.dir") + "\\test-output\\SmokeSuite\\" + "SmokeTests.html";
    private final boolean AUTO_SHOW_REPORT = ConfigurationManager.configuration().showReport();


    /**
     * Creates a driver instance before the execution of the suite
     */
    @BeforeSuite
    public void suiteSetup() {
        String platformName = CapabilitiesManager.capabilities().platformName();
        driver = DriverManager.createInstance(platformName);
    }

    /**
     * Closes the driver after the execution of the suite
     * and shows report if AUTO_SHOW_REPORT is set to true
     */
    @AfterSuite
    public void suiteTearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (AUTO_SHOW_REPORT) {
            File htmlFile = new File(URL_REPORT);
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public abstract void preconditions();

    /**
     * Preconditions to be executed before every test
     * (can be change to before all tests in class with
     * @BeforeTest)
     */
    @BeforeMethod
    public void generalPreconditions() {
        preconditions();
    }

    /**
     * Post conditions to be executed after every test
     * Creates a screenshot if the test fails
     * @param testResult
     */
    @AfterMethod(alwaysRun = true)
    public void methodPostConditions(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(testResult.getName(), Arrays.toString(testResult.getParameters()));
        }
    }

    /**
     * Takes a screenshot
     *
     * @param testMethod the Test name
     * @param testParams Test params if any
     */
    public static void takeScreenshot(String testMethod, String testParams) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(ConfigurationManager.configuration().path2Screenshots() + testMethod + "-"
                    + testParams + SDF.format(new Timestamp(System.currentTimeMillis())) + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the driver
     *
     * @return driver
     */
    public AppiumDriver getDriver() {
        return driver;
    }

    /**
     * Resets the application returning it to its initial screen
     */
    public void resetApp() {
        driver.resetApp();
    }
}

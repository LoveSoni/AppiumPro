package AppiumProTopics;

import AppiumServer.Server;
import com.applitools.eyes.appium.Eyes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SimulateSMS extends Server {
    private AppiumDriver driver;
    Eyes eyes;
    @BeforeMethod
    public void setUp(){
        startServer();
        eyes = new Eyes();
        eyes.setApiKey("WRm7YvJoRLQm3xQF5LTEh6LXKHPuA111Ya4wvwpGwxzFE110");
    }

    @Test
    public void sendSMS(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        //capabilities.setCapability(AndroidMobileCapabilityType.AVD,"Pixel3");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        try {
            driver = new AndroidDriver(new URL(getServerUrl()),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        eyes.open(driver,"AppiumPro","SendNotifications");
        eyes.checkWindow();
      // ((AndroidDriver)driver).sendSMS("111","hey");
    }
    @AfterMethod
    public  void testDown(){
        eyes.close();
        eyes.abortIfNotClosed();
        driver.quit();
    }
}

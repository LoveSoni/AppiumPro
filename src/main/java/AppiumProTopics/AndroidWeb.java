package AppiumProTopics;

/**
 * https://appiumpro.com/editions/4-using-appium-for-testing-mobile-web-apps
 */

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidWeb extends Server {
    private AppiumDriver appiumDriver;
    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void androidSeeder() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability("autoAcceptAlerts", true);
        try {
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown(){
        stopServer();
    }

}

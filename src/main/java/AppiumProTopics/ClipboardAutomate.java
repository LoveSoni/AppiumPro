package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClipboardAutomate extends Server {
    private AppiumDriver appiumDriver;
    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void automateClipboard(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
    }
}

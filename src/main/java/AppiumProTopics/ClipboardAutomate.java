package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClipboardAutomate extends Server {
    private AppiumDriver driver;

    private String ANDROID_APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.4.0/TheApp-v1.4.0.apk";

    @BeforeMethod
    public void setUp() {
        startServer();
    }

    @Test
    public void automateClipboard(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("avd", "Pixel3");
        capabilities.setCapability("app", ANDROID_APP);
        capabilities.setCapability("automationName", "UiAutomator2");
    }

    @AfterMethod
    public void stop(){
        startServer();
    }
}

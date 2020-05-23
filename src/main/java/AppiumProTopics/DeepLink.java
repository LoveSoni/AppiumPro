package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DeepLink extends Server {
    private String APP_ANDROID = "/Users/love/Desktop/AppiumPro/apps/TheApp_DeepLink.apk";
    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() {
        startServer();
    }

    @Test
    public void testDeepLink() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", APP_ANDROID);
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("udid", "emulator-5554");
        driver = new AndroidDriver(new URL(getServerUrl()), caps);
        String AUTH_USER = "alice";
        String AUTH_PASS = "mypassword";
        driver.get("theapp://login/alice/mypassword");
    }
}

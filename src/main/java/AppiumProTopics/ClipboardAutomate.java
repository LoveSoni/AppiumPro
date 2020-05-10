package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ClipboardAutomate extends Server {
    private AppiumDriver driver;

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
        capabilities.setCapability("autoGrantPermissions",true);
        capabilities.setCapability("app", "/Users/love/Desktop/AppiumPro/apps/TheApp.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        try {
            driver = new AndroidDriver(new URL(getServerUrl()),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ((HasClipboard)driver).setClipboardText("hiiiiiii");
        System.out.println("Clipboard text msg is :"+((HasClipboard) driver).getClipboardText());
    }

    @AfterMethod
    public void stop(){
        startServer();
    }
}

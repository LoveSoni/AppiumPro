package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UseAndroidUIAutomator extends Server {
    private AppiumDriver driver;

    @BeforeMethod
    public void setDriver(){
        startServer();
    }

    @Test
    public void useAutomator(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AVD,"Pixel3");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apps/ebay.apk");
        try {
            driver = new IOSDriver(new URL(getServerUrl()),desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}

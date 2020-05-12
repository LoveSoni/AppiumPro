package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EspressoCapability extends Server {

    private String AUTOMATION_NAME = "Espresso";
    private AppiumDriver driver;
    private String APP = System.getProperty("user.dir") +File.separator + "apps" +File.separator + "TheApp.apk";

    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void espressoTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"random");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AVD,"Pixel3");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,APP);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AUTOMATION_NAME);
        desiredCapabilities.setCapability("showGradleLog",true);
        driver = new AndroidDriver(new URL(getServerUrl()),desiredCapabilities);
    }
}

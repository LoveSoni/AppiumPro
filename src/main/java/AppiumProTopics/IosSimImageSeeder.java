package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class IosSimImageSeeder extends Server {

    @BeforeMethod
    @Test
    public void seedImage(){
        String slash = File.separator;
         String appPath = System.getProperty("user.dir") + slash + "apps" + "SamplePhotosApp.app.zip";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
        desiredCapabilities.setCapability("app",appPath);

    }
}

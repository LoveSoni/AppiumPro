package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class IosSimImageSeeder extends Server {
    private AppiumDriver appiumDriver;

    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void seedImage() throws MalformedURLException {
        String slash = File.separator;
        String appPath = System.getProperty("user.dir") + slash + "apps" + slash +"SamplePhotosApp.app";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformVersion", "12.2");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
        desiredCapabilities.setCapability("app",appPath);
        appiumDriver = new AndroidDriver(new URL(getServerUrl()),desiredCapabilities);
    }

    @AfterMethod
    public void tearDown(){
        startServer();
    }
}

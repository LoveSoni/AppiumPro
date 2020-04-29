package AppiumProTopics;

import AppiumServer.Server;
import com.google.common.collect.ImmutableMap;
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
import java.util.Map;

public class ExecuteShellCommand extends Server {
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
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.photos");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("autoAcceptAlerts", true);
        try {
            appiumDriver = new AndroidDriver(new URL(getServerUrl()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Map<String,Object> command = ImmutableMap.of("command","pm list packages");
        String output = (String)appiumDriver.executeScript("mobile: shell",command);
        System.out.println("--output is -"+output);
    }

    @AfterMethod
    public void tearDown(){
        stopServer();
    }

}

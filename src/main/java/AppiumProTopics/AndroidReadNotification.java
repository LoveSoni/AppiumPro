package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidReadNotification extends Server
{
    private AppiumDriver driver;

    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void sendSMS(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(AndroidMobileCapabilityType.AVD,"Pixel");
        capabilities.setCapability("automationName", "UiAutomator2");
        try {
            driver = new AndroidDriver(new URL(getServerUrl()),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ((AndroidDriver)driver).sendSMS("111","hey");
        ((AndroidDriver) driver).openNotifications();
        String msg = driver.findElement(By.id("android:id/message_text")).getText();
        System.out.println(msg);
    }
}

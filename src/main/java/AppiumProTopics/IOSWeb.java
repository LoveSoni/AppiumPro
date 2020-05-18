package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSWeb extends Server {
    private AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        startServer();
    }

    @Test
    public void launchSafariBrowser() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xs Max");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW,true);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "xcuitest");
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("192.168.1.101");
        desiredCapabilities.setCapability("remoteDebugProxy","127.0.0.1");
        desiredCapabilities.setCapability(IOSMobileCapabilityType.BROWSER_NAME, "safari");
        driver = new IOSDriver(new URL(getServerUrl()), desiredCapabilities);
        driver.get("https://www.capgemini.com");
    }

    @AfterMethod
    public void tearDown() {
        stopServer();
    }
}

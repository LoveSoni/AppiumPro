package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class IosSwitchApps extends Server {

    private String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.3.0/TheApp-v1.3.0.app.zip";
    private String PHOTOS_BUNDLE_ID = "com.apple.mobileslideshow";
    private String BUNDLE_ID = "io.cloudgrey.the-app";

    @BeforeMethod
    public void setUp() {
        startServer();
    }

    @Test
    public void switchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8 Plus");
        capabilities.setCapability("platformVersion", "12.2");
        capabilities.setCapability("app", APP);
        AppiumDriver driver = new IOSDriver(new URL(getServerUrl()), capabilities);
        HashMap<String, Object> args = new HashMap<>();
        args.put("bundleId", PHOTOS_BUNDLE_ID);

        HashMap theAppBundleId = new HashMap();
        theAppBundleId.put("bundleId",BUNDLE_ID);
        driver.executeScript("mobile: launchApp", args);
        driver.executeScript("mobile: activateApp",theAppBundleId);
        driver.executeScript("mobile: activateApp",args);
    }
}

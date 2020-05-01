package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSAppUpgrades extends Server {
    private AndroidDriver driver;
    private String BUNDLE_ID = "io.cloudgrey.the-app";
    private String APP_V1_0_0 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.0/TheApp-v1.0.0.app.zip";
    private String APP_V1_0_1 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.1/TheApp-v1.0.1.app.zip";
    private String APP_V1_0_2 = "https://github.com/cloudgrey-io/the-app/releases/download/v1.0.2/TheApp-v1.0.2.app.zip";

    @BeforeMethod
    public void setUp() {
        startServer();
    }

    @Test
    public void appUpgrade() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8 Plus");
        capabilities.setCapability("platformVersion", "12.2");
        capabilities.setCapability("app", APP_V1_0_0);
        driver = new AndroidDriver(new URL(getServerUrl()),capabilities);
    }
}

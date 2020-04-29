package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class IosSimImageSeeder extends Server {
    private AppiumDriver appiumDriver;
    private String PROJECT_PATH = System.getProperty("user.dir");
    private String slash = File.separator;

    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void seedImage() throws IOException {
        String appPath = PROJECT_PATH + slash + "apps" + slash +"SamplePhotosApp.app";
        File videoFile = new File(PROJECT_PATH + slash + "data"+ slash + "video.mp4");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformVersion", "12.2");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("deviceName", "iPhone 8 Plus");
        desiredCapabilities.setCapability("app",appPath);
        desiredCapabilities.setCapability("autoAcceptAlerts",true);
        appiumDriver = new IOSDriver(new URL(getServerUrl()),desiredCapabilities);
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("All Photos")));
        el.click();
        List<WebElement> photos = appiumDriver.findElements(MobileBy.className("XCUIElementTypeImage"));
        int numPhotos = photos.size();
        System.out.println("Number of Photos Available"+numPhotos);
        System.out.println("Video File path "+videoFile.getCanonicalPath());
        try {
            ((IOSDriver)appiumDriver).pushFile("myVideo.mp4",videoFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]){
        System.out.println("hii");
    }
    @AfterMethod
    public void tearDown(){
        startServer();
    }
}

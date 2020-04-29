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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AndImageSeeder extends Server {
    private AppiumDriver appiumDriver;
    private String PROJECT_PATH = System.getProperty("user.dir");
    private String slash = File.separator;

    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void androidSeeder(){
        File imageFile = new File(PROJECT_PATH + slash + "data" + slash + "Image.jpeg");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID,"42006bcf9a2f84d3");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.photos");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("autoAcceptAlerts",true);
        try {
            appiumDriver = new AndroidDriver(new URL(getServerUrl()),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        appiumDriver.switchTo().alert().accept();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        appiumDriver.navigate().back();
        try {
            ((AndroidDriver)appiumDriver).pushFile("/Internal storage/Image.jpeg",imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(){
        stopServer();
    }
}

package AppiumProTopics;

import AppiumServer.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidPerformance extends Server {
    private AppiumDriver driver;

    @BeforeMethod
    public void setUp(){
        startServer();
    }

    @Test
    public void androidPerformance(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.apps.photos");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        try {
            driver = new AndroidDriver(new URL(getServerUrl()),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("Supported Perfomance Data Types - "+((AndroidDriver)driver).getSupportedPerformanceDataTypes());
        // 1. Memory info
        List<List<Object>> list = ((AndroidDriver) driver).getPerformanceData("com.google.android.apps.photos","memoryinfo",10);
        Map<String,String> values = new HashMap<>();
        for(int i=0;i<list.get(0).size();i++){
            if(list.get(1).get(i)!=null) {
                values.put((String)list.get(0).get(i),(String)list.get(1).get(i));
            }
        }
        System.out.println("And data is :"+list.toString());
        System.out.println("Map value -"+values.toString());
        //2. network nfo
        List<List<Object>> networkinfo = ((AndroidDriver) driver).getPerformanceData("com.google.android.apps.photos","networkinfo",10);
        System.out.println("And network data is -"+networkinfo);
        //3. battery info
        List<List<Object>> batteryinfo = ((AndroidDriver) driver).getPerformanceData("com.google.android.apps.photos","batteryinfo",10);
        System.out.println("Battery info -"+batteryinfo);
        //4. cpu info

    }

}

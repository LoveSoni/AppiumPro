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
        String packageName = "com.google.android.apps.photos";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", packageName);
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        try {
            driver = new AndroidDriver(new URL(getServerUrl()),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("Supported Perfomance Data Types - "+((AndroidDriver)driver).getSupportedPerformanceDataTypes());
        // 1. Memory info
        Map<String,String> data = getPerformanceData(packageName,"memoryinfo",10);
        System.out.println("Memory Info- "+data.toString());
        //2. Battery info
        Map<String,String> batteryinfo = getPerformanceData(packageName,"batteryinfo",1);
        System.out.println("Battery Info- "+batteryinfo.toString());
        //3. Network info
        Map<String,String> networkInfo = getPerformanceData(packageName,"networkinfo",1);
        System.out.println("Network Info- "+networkInfo.toString());
        //4. cpu info
        Map<String,String> cpuInfo = getPerformanceData(packageName,"cpuinfo",20);
        System.out.println("Cpu info- "+cpuInfo.toString());

    }

    public Map<String,String> getPerformanceData(String packageName,String perfomanceType,int time){
        List<List<Object>> listData = ((AndroidDriver)driver).getPerformanceData(packageName,perfomanceType,time);
        Map<String,String> values = new HashMap<>();
        for(int i=0;i< listData.get(0).size();i++){
            if (listData.get(1).get(i)!=null){
                values.put((String)listData.get(0).get(i),(String)listData.get(1).get(i));
            }
        }
        return values;
    }

}

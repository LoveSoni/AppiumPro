package AppiumServer;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Server {
    private AppiumDriverLocalService appiumDriverLocalService;

    public void startServer(){
        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        appiumDriverLocalService.start();
    }

    public String getServerUrl(){
        return appiumDriverLocalService.getUrl().toString();
    }
    public void stopServer(){
        appiumDriverLocalService.stop();
    }
}

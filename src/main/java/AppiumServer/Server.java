package AppiumServer;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Server {
    private AppiumDriverLocalService appiumDriverLocalService;

    public void startServer() {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withArgument(GeneralServerFlag.RELAXED_SECURITY, "");
        appiumServiceBuilder.usingAnyFreePort();
        appiumServiceBuilder.withIPAddress("0.0.0.0");
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
    }

    public String getServerUrl() {
        return appiumDriverLocalService.getUrl().toString();
    }

    public void stopServer() {
        appiumDriverLocalService.stop();
    }
}

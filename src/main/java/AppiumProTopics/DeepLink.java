package AppiumProTopics;

import AppiumServer.Server;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class DeepLink  extends Server {
    private String USER_NAME="alice";
    private final String slash = File.separator;
    private String PASSWORD = "mypassword";
    private String ANDROID_APP_PATH = System.getProperty("user.dir") +slash + "apps" + slash + "TheApp,apk";
    private String IOS_APP_PATH = System.getProperty("user.dir") + slash + "apps" + slash + "TheAppIOS.app.zip";

    @BeforeMethod
    public void setUp(){
        startServer();
    }

    public void androidLoginStep(){

    }

    @Test
    public void deepLinkTest(){

    }

    @AfterMethod
    public void tearDown(){
        stopServer();
    }

}

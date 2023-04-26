
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","13.0");
        caps.setCapability("deviceName","samsung");
        caps.setCapability("udid","R5CR90MHNYW");
        caps.setCapability("app","/Users/mert.bacak/Desktop/apk/imdb.apk");
        caps.setCapability("newCommandTimeout","600");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @AfterEach
    public void tearDown() {
        if (null != this.driver) {
            this.driver.quit();
        }
    }

}

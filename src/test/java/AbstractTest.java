import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractTest {
    protected AppiumDriver<MobileElement> driver;
    protected DesiredCapabilities capabilities;

    @BeforeClass
    public void init(){
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    }

    @AfterClass
    public void cleanup(){
        driver.quit();
    }

    protected void startDriver(){
        startDriver("http://localhost:4723/wd/hub");
    }

    protected void startDriver(String url){
        try {
            driver = new AppiumDriver<MobileElement>(new URL(url), capabilities);
        }
        catch(MalformedURLException e){
            throw new RuntimeException(e);
        }
    }
}

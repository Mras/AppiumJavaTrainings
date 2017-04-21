import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MyTests {
    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void init() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "CB5A2228H6");
        capabilities.setCapability(MobileCapabilityType.APP, new File("./VirtruEmailEncryption_v2.2.2_apkpure.com.apk").getAbsolutePath());

        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
    }

    @AfterClass
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void myTest() throws InterruptedException{
        System.out.println("My Test Passes!");
        Thread.sleep(5000);
        Assert.assertNotNull(driver);
    }
}

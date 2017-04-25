import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class NativeTests extends AbstractTest{

    @Test
    public void nativeTest(){
        MobileElement gmailButton = driver.findElement(By.id("com.fsck.virtru.k9:id/oauth_gmail_account_btn"));
        gmailButton.click();
        //@TODO Implement test flow
    }

    @BeforeClass
    public void init(){
        super.init();
        capabilities.setCapability(MobileCapabilityType.APP, new File("./VirtruEmailEncryption_v2.2.2_apkpure.com.apk").getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.fsck.virtru.k9");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.virtru.mobile.ui.activity.SplashScreenActivity");
        startDriver();
    }
}

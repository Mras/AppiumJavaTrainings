import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

public class HybridTests extends AbstractTest{
    @Test
    public void hybridTest(){


        printContexts();
    }

    @BeforeClass
    public void init(){
        super.init();
        capabilities.setCapability(MobileCapabilityType.APP, new File("./Wikipedia_org.wikipedia.apk").getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wikipedia");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wikipedia.MainActivity");
        startDriver();
    }

    private void printContexts(){
        Set<String> currentContexts = driver.getContextHandles();
        for (String context : currentContexts) {
            System.out.println(context);
        }
    }
}

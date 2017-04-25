import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WebTests extends AbstractTest{
    @Test
    public void webTest() {
        driver.get("https://www.google.com");
        MobileElement question = driver.findElement(By.cssSelector("input[name='q']"));
        question.sendKeys("Advanced Appium lessons");
        question.submit();
        String firstResultTitle = driver.findElement(By.cssSelector("div.g:first-of-type h3 a")).getText();
        assertTrue(firstResultTitle.contains("Advanced Appium"),"First result is not about Appium");
        assertTrue(firstResultTitle.contains("PageObject"),"First result is not so interesting as it has nothing about PageObjects");
    }

    @BeforeClass
    public void init(){
        super.init();
        capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "Browser");
        startDriver();
    }
}

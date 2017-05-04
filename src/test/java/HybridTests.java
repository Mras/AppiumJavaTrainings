import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class HybridTests extends AbstractTest{
    @Test
    public void hybridTest(){
        MobileElement searchField = driver.findElementById("org.wikipedia:id/search_container");
        searchField.sendKeys("Boeing 747");
        WebDriverWait wait = new WebDriverWait(driver,5);
        String firstTitleID = "org.wikipedia:id/page_list_item_title";
        wait.until(ExpectedConditions.elementToBeClickable(By.id(firstTitleID)));
        MobileElement firstTitle = driver.findElementById(firstTitleID);
        Assert.assertEquals(firstTitle.getText(), "Boeing 747");
        firstTitle.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("org.wikipedia:id/view_article_header_menu_bar")));
        driver.context("WEBVIEW_org.wikipedia");
        MobileElement hullLossLink = driver.findElementByCssSelector("a[title='Hull loss']");
        hullLossLink.click();
        driver.context("NATIVE_APP");
        MobileElement readArticleButton = driver.findElementById("org.wikipedia:id/link_preview_go_button");
        readArticleButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("org.wikipedia:id/view_article_header_menu_bar")));

        Dimension screenSize = driver.manage().window().getSize();
        MobileElement pageView = driver.findElementById("org.wikipedia:id/page_toc_drawer");
        int pageViewWidth = pageView.getCoordinates().inViewPort().getX() + pageView.getSize().getWidth();
        int pageViewHeight = pageView.getCoordinates().inViewPort().getY() + pageView.getSize().getHeight();

        new TouchAction(driver)
                .press(pageView,pageViewWidth/2,pageViewHeight-250)
                .waitAction(Duration.ofSeconds(1))
                .moveTo(pageView,pageViewWidth/2,0)
                .release()
                .perform();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("direction", "down");
//        js.executeScript("mobile: scroll", scrollObject);
        driver.context("NATIVE_APP");
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

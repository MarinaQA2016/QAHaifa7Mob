package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public AppiumDriver driver;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("appPackage", "com.flt.checklist");
        capabilities.setCapability("appActivity","com.flt.checklist.MainActivity");
        capabilities.setCapability("automationName","Uiautomator1");
        capabilities.setCapability("app",
                "C:/Marina/TelRan/Auto/Groups/QAHaifa7/QAHaifa7Mob/apk/easy_checklist.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

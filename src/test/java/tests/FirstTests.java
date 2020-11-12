package tests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTests {
    public AppiumDriver driver;

    @Test
    public void openCheckList() throws MalformedURLException, InterruptedException {
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

        Thread.sleep(5000);
        driver.findElement(By.id("com.flt.checklist:id/add_shopping_list")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("android.widget.EditText")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/buttonPanel")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}

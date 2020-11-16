package tests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckListsHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckListsTest extends TestBase{
    CheckListsHelper checkListsPage;

    @BeforeMethod
    public void initTests(){
        checkListsPage = PageFactory.initElements(driver,CheckListsHelper.class);
        checkListsPage.waitUntilPageIsLoaded();
    }

    @Test
    public void isCorrectScreen(){
        Assert.assertEquals("Check List", checkListsPage.getHeaderText());
    }

    @Test
    public void createCheckList()  {
        int firstListQuantity = checkListsPage.getListsQuantity();
        System.out.println("firstListQuantity: " + firstListQuantity);
        checkListsPage.createCheckList("ChList");
        int lastListQuantity = checkListsPage.getListsQuantity();
        System.out.println("lastListQuantity: " + lastListQuantity);

        Assert.assertEquals(firstListQuantity+1,lastListQuantity);
    }

    @Test
    public void createCheckListAndRotate(){
        int firstListQuantity = checkListsPage.getListsQuantity();
        System.out.println("firstListQuantity: " + firstListQuantity);
        checkListsPage.rotateScreenLandScape();
        checkListsPage.createCheckList("AfterRotationm");
        int landscapeListQuantity = checkListsPage.getListsQuantity();
        Assert.assertEquals(firstListQuantity+1,landscapeListQuantity);
        checkListsPage.rotateScreenPortrait();
        int portraitListQuantity = checkListsPage.getListsQuantity();
        Assert.assertEquals(firstListQuantity+1,portraitListQuantity);
    }
}

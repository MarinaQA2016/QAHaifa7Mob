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
import pages.CurrentCheckListHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckListsTest extends TestBase{
    CheckListsHelper checkListsPage;
    CurrentCheckListHelper currentListPage;

    @BeforeMethod(alwaysRun = true)
    public void initTests(){
        checkListsPage = PageFactory.initElements(driver,CheckListsHelper.class);
        currentListPage = PageFactory.initElements(driver, CurrentCheckListHelper.class);
        checkListsPage.waitUntilPageIsLoaded();
    }

    @Test(groups = {"smoke","regression"})
    public void isCorrectScreen(){
        Assert.assertEquals("Check List", checkListsPage.getHeaderText());
    }

    @Test(groups = {"regression"})
    public void createCheckList()  {
        int firstListQuantity = checkListsPage.getListsQuantity();
        System.out.println("firstListQuantity: " + firstListQuantity);
        checkListsPage.createCheckList("ChList");
        int lastListQuantity = checkListsPage.getListsQuantity();
        System.out.println("lastListQuantity: " + lastListQuantity);

        Assert.assertEquals(firstListQuantity+1,lastListQuantity);
    }

    @Test
    public void createCheckListGoToBackGround(){
        int firstListQuantity = checkListsPage.getListsQuantity();
        checkListsPage.createCheckList("ChList");
        checkListsPage.runBackGround(2);
        int lastListQuantity = checkListsPage.getListsQuantity();
        Assert.assertEquals(firstListQuantity+1,lastListQuantity);
    }


    @Test(groups = {"smoke"})
    public void createCheckListAndRotate() {
        int firstListQuantity = checkListsPage.getListsQuantity();
        System.out.println("firstListQuantity: " + firstListQuantity);
        checkListsPage.rotateScreenLandScape();
        checkListsPage.waitUntilPageIsLoaded();
        checkListsPage.createCheckList("AfterRotationm");
        int landscapeListQuantity = checkListsPage.getListsQuantity();
        Assert.assertEquals(firstListQuantity + 1, landscapeListQuantity);
        checkListsPage.rotateScreenPortrait();
        checkListsPage.waitUntilPageIsLoaded();
        int portraitListQuantity = checkListsPage.getListsQuantity();
        Assert.assertEquals(firstListQuantity + 1, portraitListQuantity);
    }

    @Test
    public void createCheckListAndSwipeIt(){
        checkListsPage.createCheckListNoReturn("FirstNotEmptyChList");
        for(int i=0; i<15; i++) currentListPage.addItem("item" + i);
        currentListPage.swipeUpToLastCheckList(15);
        currentListPage.returnToCheckLists();

    }

    @Test
    public void deleteFirstCheckList(){
        int firstListQuantity = checkListsPage.getListsQuantity();
        if (firstListQuantity == 0) checkListsPage.createCheckList("FirstCheckList");
        firstListQuantity = checkListsPage.getListsQuantity();
        checkListsPage.deleteFirstCheckList();
        int lastListQuantity = checkListsPage.getListsQuantity();
        Assert.assertEquals(firstListQuantity-1,lastListQuantity);
    }
    @Test
    public void createNotEmptyCheckList(){
        int firstListQuantity = checkListsPage.getListsQuantity();
        checkListsPage.createCheckListNoReturn("FirstNotEmptyChList");
        currentListPage.addItem("fiestItem")
                .returnToCheckLists();
        checkListsPage.waitUntilPageIsLoaded();
        int lastQuantityNoRotation = checkListsPage.getListsQuantity();
        checkListsPage.rotateScreenLandScape();
        checkListsPage.createCheckListNoReturn("FirstNotEmptyChList");
        currentListPage.addItem("secondItem")
                .returnToCheckLists();
        checkListsPage.waitUntilPageIsLoaded();
        int afterLanscapeRotation = checkListsPage.getListsQuantity();
        currentListPage.rotateScreenPortrait();
        checkListsPage.waitUntilPageIsLoaded();
        int finalCheckLists = checkListsPage.getListsQuantity();
        Assert.assertEquals(firstListQuantity + 1, lastQuantityNoRotation);
        Assert.assertEquals(firstListQuantity + 2, afterLanscapeRotation);
        Assert.assertEquals(afterLanscapeRotation, finalCheckLists);

    }
}

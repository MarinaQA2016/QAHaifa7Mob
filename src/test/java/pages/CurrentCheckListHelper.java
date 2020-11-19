package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrentCheckListHelper extends PageBase {
    @FindBy(className = "android.widget.ImageButton")
    WebElement returnButton;
    @FindBy(id = "com.flt.checklist:id/add_item")
    WebElement plusButton;
    @FindBy(id = "com.flt.checklist:id/add_item_edit")
    WebElement nameItemField;


    public CurrentCheckListHelper(WebDriver driver) {
        super(driver);
    }
    public CurrentCheckListHelper waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(returnButton,5);
        return this;
    }
    public CurrentCheckListHelper returnToCheckLists(){
        returnButton.click();
        return this;
    }
    public CurrentCheckListHelper addItem(String name){
        waitUntilElementIsClickable(nameItemField,10);
        editField(nameItemField,name);
        plusButton.click();
        return this;
    }


    public void swipeUpToLastCheckList(int num) {
        String lastItemName = "item" + (num-1);
        swipeUpToElement(By.xpath("//*[contains(text(),'" + lastItemName + "')]"),5);
    }
}

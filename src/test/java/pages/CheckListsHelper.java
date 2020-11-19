package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class CheckListsHelper extends PageBase {
    @FindBy(className = "android.widget.TextView")
    WebElement headerText;
    @FindBy(id = "com.flt.checklist:id/add_shopping_list")
    WebElement plusButton;
    @FindBy(className = "android.widget.EditText")
    WebElement nameField;
    @FindBy(id = "android:id/button1")
    WebElement okButton;
    @FindBy(className = "android.widget.ImageButton")
    WebElement returnButton;
    @FindBy(id="com.flt.checklist:id/list_title")
    List<WebElement> checkLists;
    @FindBy(id="com.flt.checklist:id/list_delete")
    List<WebElement> deleteButtonList;


    public CheckListsHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(headerText,10);
        waitUntilElementIsClickable(plusButton,10);
    }

    public String getHeaderText() {
        return headerText.getText();
    }

    public void createCheckList(String name) {
        this.createCheckListNoReturn(name);
        waitUntilElementIsClickable(returnButton,5);
        returnButton.click();
        this.waitUntilPageIsLoaded();
    }

    public void createCheckListNoReturn(String name) {
        plusButton.click();
        waitUntilElementIsClickable(okButton, 10);
        waitUntilElementIsClickable(nameField, 10);
        editField(nameField, name);
        okButton.click();
    }



    public int getListsQuantity() {
        return checkLists.size();
    }

    public void deleteFirstCheckList(){
        this.waitUntilElementsAreVisible(deleteButtonList,10);
        deleteButtonList.get(0).click();
        this.waitUntilElementIsClickable(okButton,10);
        okButton.click();
        this.waitUntilElementIsInvisible(okButton,10);
    }



}

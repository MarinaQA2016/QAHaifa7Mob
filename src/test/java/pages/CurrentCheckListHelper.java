package pages;

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
    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(returnButton,5);
    }
    public void returnToCheckLists(){
        returnButton.click();
    }
    public void addItem(String name){
        waitUntilElementIsClickable(nameItemField,10);
        editField(nameItemField,name);
        plusButton.click();
    }
}

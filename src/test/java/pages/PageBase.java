package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    WebDriver driver;


    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsPresent(By locator, int time) {
        try {
            new WebDriverWait (driver,time).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementsArePresent(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilNumberOfElementsToBe(By locator, int quantity,int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.numberOfElementsToBe(locator,quantity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementsAreVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void frameToBeAvailableAndSwitchToIt(WebElement iframe, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void waitUntilElementsAreVisible(List<WebElement> elementsList, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElements(elementsList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void rotateScreenLandScape() {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        appDriver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotateScreenPortrait() {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        appDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void runBackGround(int time) {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        appDriver.runAppInBackground(Duration.ofSeconds(time));
    }

    public void swipeUp() {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        TouchAction action = new TouchAction(appDriver);
        Dimension size = driver.manage().window().getSize();
        int x = (int)(size.width * 0.5);
        int y1 = (int)(size.height * 0.8);
        int y2 = (int)(size.height * 0.2);
        action.press(PointOption.point(x,y1))
                .waitAction()
                .moveTo(PointOption.point(x,y2))
                .release()
                .perform();
    }

    public void swipeUpToElement(By by, int maxTimes){
        int counter = 0;
        while(driver.findElements(by).size()==0 && counter < maxTimes){
            swipeUp();
            counter++;
        }
    }

}

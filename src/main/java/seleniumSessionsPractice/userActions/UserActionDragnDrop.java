package seleniumSessionsPractice.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static seleniumSessionsPractice.userActions.UserActionsSubMenu.driver;

public class UserActionDragnDrop {
    static WebDriver driver;




    public static void dragAndDrop(WebDriver driver, By source, By dest) {
    Actions act= new Actions(driver);
/*
        act.dragAndDrop(driver.findElement(source), driver.findElement(dest)).perform();
*/
       // or
        act.dragAndDropBy(driver.findElement(source), 100,0 ).release().perform();
      //  or
   /*     act.
                clickAndHold(driver.findElement(source)).
                moveToElement(driver.findElement(dest)).
                release().build().perform();*/
    }

    public static void main(String[] args) {
        driver= new ChromeDriver();
        //drag and element and drop at some other element
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

        By sourceEle = By.id("draggable");
        By targetEle = By.id("droppable");
        dragAndDrop(driver, sourceEle, targetEle);


/*        Actions act = new Actions(driver);
        act
                .clickAndHold(sourceEle)
                .moveToElement (targetEle)
                .release().perform();*/

    }


}

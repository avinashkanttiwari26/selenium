package seleniumSessionsPractice.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectClassPractice {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
        Thread.sleep(2000);

        WebElement menu = driver.findElement(By.cssSelector("div#mbsc-control-0")); //

        // note that select element is hidden. Select class won't help.
        // approach1 fails
        /*
        * <select id="demo-multiple-select" multiple="" style="display: none;"><option></option>
                                            <option value="1">Books</option>
                                            <option value="2">Movies, Music &amp; Games</option>
                                            <option value="3">Electronics &amp; Computers</option>
                                            <option value="4">Home, Garden &amp; Tools</option>
                                            <option value="5">Health &amp; Beauty</option>
                                            <option value="6">Toys, Kids &amp; Baby</option>
                                            <option value="7">Clothing &amp; Jewelry</option>
                                            <option value="8">Sports &amp; Outdoors</option>
                                        </select>*/
        /*
                Select sel = new Select(menu);
                sel.selectByIndex(1);
                Thread.sleep(3000);
                sel.selectByValue("4");
                Thread.sleep(3000);
        */
        menu.click();
        Thread.sleep(2000);
//approach2 fails :
        // options are hidden inside select; this will return empty list code fails.
 /*       List<WebElement> menuOptions = driver.findElements(By.cssSelector("div#mbsc-control-0 option"));

        for(int i=1; i<menuOptions.size(); i++){
            menuOptions.get(i).click();
            Thread.sleep(2000);

        }*/

// approach3

        driver.findElement(By.xpath("//div[ normalize-space(.)='Books']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[ normalize-space(.)= 'Electronics & Computers']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[ normalize-space(.)='Books']")).click() ;
        Thread.sleep(2000);
        driver.findElement(By.tagName("body")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//div[contains(text(), 'Movies')]")).click() ;
//handling sgv:
        String menuText = "Electronics & Computers";
        String locatorSvg = "//span[ normalize-space(.)='" + menuText + "']/..//span[@class='mbsc-textfield-tag-clear mbsc-icon mbsc-ios/*[local-name()='svg']";

        String locatorParentSGV = "//span[ normalize-space(.)='" + menuText + "']/..//span[@class='mbsc-textfield-tag-clear mbsc-icon mbsc-ios']"; //   /*[local-name()='svg']

        String locatorTextParentSiblingSpan = "(//span[ normalize-space(.) = 'Books' and @class='mbsc-textfield-tag mbsc-ios mbsc-ltr'] /span) [2]";
        //it didn't click on sgv element so trying to click parent of it.
        // sometime element become clickable only after hovering over it.


        By sgvElementForMenuText = By.xpath(locatorTextParentSiblingSpan);
// below didn't work. next approach is to try to move to element and click.
/*
        driver.findElement(sgvElementForMenuText).click();
*/

//Movies, Music & Games
        //below too failed

        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath(locatorParentSGV))).perform();
        driver.findElement(By.xpath(locatorParentSGV)).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        act.moveToElement(driver.findElement(By.xpath(locatorTextParentSiblingSpan)));
        WebElement xx = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorTextParentSiblingSpan)));

        xx.click();

    }
}

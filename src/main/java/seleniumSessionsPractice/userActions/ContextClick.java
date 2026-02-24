package seleniumSessionsPractice.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Array;
import java.util.List;

import static org.openqa.selenium.devtools.v137.debugger.Debugger.pause;

public class ContextClick {

    static WebDriver driver;
    static Actions act;
    public static void rightClick(By ele){
    act= new Actions(driver);
    act.contextClick(driver.findElement(ele)).perform();

    }

    public void doActionsSendKeys(By locator, String text)
    {
        Actions act= new Actions(driver);
        act.sendKeys(driver.findElement(locator), text).perform();
    }

    public void doActionsClick(By locator)
    {
        Actions act= new Actions(driver);
        act.click(driver.findElement(locator)).perform();
    }

    public void doSendKeysWithPause(By locator, String text)
    {
       Actions act= new Actions(driver);
       char[] ch =text.toCharArray();
       for (char c: ch)
        {
            act.sendKeys(driver.findElement(locator), String.valueOf(c)).pause(500).perform();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        By eleRightClick= By.xpath("//span[text()='right click me']");
        rightClick(eleRightClick);

        List<WebElement> contextMenu = driver.findElements(By.cssSelector("ul.context-menu-list> li.context-menu-icon"));
        for(WebElement ele: contextMenu)
        {
            rightClick(eleRightClick);
            Thread.sleep(2000);
            ele.click();
            driver.switchTo().alert().accept();
        }
    }
}

package seleniumSessionsPractice.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class UseKeysActions {


    public static void main(String[] args) {
    WebDriver driver= new ChromeDriver();
    Actions act= new Actions(driver);

    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

    WebElement ele1 = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

    act.sendKeys(ele1,"Avi").pause(Duration.ofMillis(300)).
            sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                sendKeys("Tiwari").
                    sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                        sendKeys("mail").
                            sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                                sendKeys("phone").
                                    sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                                       sendKeys("password").
                                        sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                                            sendKeys("password").pause(Duration.ofMillis(300)).
                                                sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                                                    sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                                                        sendKeys(Keys.SPACE).pause(Duration.ofMillis(300)).
                                                            sendKeys(Keys.TAB).pause(Duration.ofMillis(300)).
                                                                sendKeys(Keys.ENTER).pause(Duration.ofMillis(300)).perform();

   //navigate bottom or top of page- operating system dependent
   act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();// control for windows
   act.sendKeys(Keys.COMMAND).sendKeys(Keys.HOME).perform();// command for mac

    act.scrollToElement(ele1);
    }


}

package seleniumSessionsPractice.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BigBasket {
static WebDriver driver;


public static void multiLevelhover(By ele1, By ele2, By ele3, By ele4) throws InterruptedException {
    Actions act= new Actions(driver);
    Thread.sleep(1000);

    act.moveToElement(driver.findElement(ele1)).click().pause(Duration.ofMillis(500)).perform();
        act.moveToElement(driver.findElement(ele2)).pause(Duration.ofMillis(500)).perform();
            act.moveToElement(driver.findElement(ele3)).pause(Duration.ofMillis(500)).perform();
                act.moveToElement(driver.findElement(ele4)).click().perform();
}

    public static void main(String[] args) throws InterruptedException {
        //multi action

        driver= new ChromeDriver();
        driver.get("https://www.bigbasket.com/");
        Actions act= new Actions(driver);
        Thread.sleep(1000);


        By ele1= By.xpath("(//span[text()='Shop by'])[2]");
        By ele2= By.linkText("Snacks & Branded Foods");
        By ele3= By.linkText("Breakfast Cereals");
        By ele4= By.linkText("Flakes");

        act.moveToElement(driver.findElement(ele1)).click().pause(Duration.ofMillis(500)).perform();
                act.moveToElement(driver.findElement(ele2)).pause(Duration.ofMillis(500)).perform();
                    act.moveToElement(driver.findElement(ele3)).pause(Duration.ofMillis(500)).perform();
                        act.moveToElement(driver.findElement(ele4)).click().perform();

    }


}

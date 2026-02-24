package seleniumSessionsPractice.userActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserActionsSubMenu {
    static WebDriver driver;
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static Actions act;

    public static void handleSubMenu(By parentLocator, By childLocator){
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(parentLocator)).perform();
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(childLocator)
        );
        driver.findElement(childLocator).click();
    }
    public void hover(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        new Actions(driver)
                .moveToElement(element)
                .pause(Duration.ofMillis(200))
                .perform();
    }

    public static void dragAndDrop(WebDriver driver, By source, By dest) {
        act= new Actions(driver);
        act.dragAndDrop(driver.findElement(source), driver.findElement(dest));
/*        or
        act.dragAndDropBy(driver.findElement(source), 100,100 );*/
/*or*/
        act.
           clickAndHold(driver.findElement(source)).
                moveToElement(driver.findElement(dest)).
                    release().build().perform();
    }



        public static void main(String[] args) throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("https://www.devmedia.com.br/");

        By course = By.xpath("//a[ text()='Cursos' ]");
        Thread.sleep(3000);
        Actions act = new Actions(driver);
/*        act.moveToElement(driver.findElement(course)).click();
        Thread.sleep(3000);*/
       act.moveToElement(driver.findElement(course)).perform();

        driver.findElement(By.xpath("//a[@title='Inteligência Artificial']")).click();
    }

}

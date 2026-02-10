package seleniumSessionsPractice.webDriver;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WebDriverConcepts {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

       // Object var1 = driver.get("");
        WebDriver.Options var2 = driver.manage();
        WebElement ele3 = driver.findElement(By.id(""));
        WebElement ele4 = driver.findElement(By.xpath("//*[@id='login']"));
        @Nullable String ele5 = driver.getTitle();
        @Nullable String ele6 = driver.getCurrentUrl();
        Class<? extends WebDriver> ele7 = driver.getClass();
        String ele8 = driver.getWindowHandle();
        Set<String> ele9 = driver.getWindowHandles();
        @Nullable String ele10 = driver.getPageSource();
        //Object var11 = driver.close();
        //Object var12 = driver.quit();
        WebDriver.TargetLocator window = driver.switchTo();

    }
}

package seleniumSessionsPractice.windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AssignmenWH {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
        String parentWindowHandle= driver.getWindowHandle();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(@href, 'twitter')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href, 'linkedin')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href, 'facebook')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href, 'youtube')]")).click();


        Set<String> whs = driver.getWindowHandles();
        List<String> ls= new ArrayList<>(whs);

        for(String wh: whs)
        {
            driver.switchTo().window(wh);
            if(!wh.equals(parentWindowHandle)){
                System.out.println(driver.getTitle());
                driver.close();
            }
            driver.switchTo().window(parentWindowHandle);
        }

    }
}

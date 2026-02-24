package seleniumSessionsPractice.windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class BrowserWindowHandling {

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


        Set<String> windowHandles = driver.getWindowHandles();

        //driver.getWindowHandles().forEach(System.out::println);
        Iterator<String> it= windowHandles.iterator();
        ArrayList<String> whs= new ArrayList<>();

/*        //below code will close even parent window
        while (it.hasNext())
        {
            String wh = it.next();
            System.out.println(wh);
            whs.add(wh);
            driver.switchTo().window(wh).close();
            Thread.sleep(1000);
        }*/
        while (it.hasNext())
        {
            String wh = it.next();
            System.out.println(wh);
            whs.add(wh);
            if(!wh.equals(parentWindowHandle))driver.switchTo().window(wh).close();
            Thread.sleep(1000);
        }
        driver.switchTo().window(parentWindowHandle);

        Thread.sleep(2000);

    }

}

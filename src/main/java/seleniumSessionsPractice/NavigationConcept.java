package seleniumSessionsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class NavigationConcept {

    static WebDriver driver;

    public static void main(String[] args) {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wwww.google.com");
        System.out.println(driver.getTitle());

        driver.navigate().to("https://www.amazon.in");
        System.out.println(driver.getTitle());

        driver.navigate().back();
        System.out.println(driver.getTitle());

        driver.navigate().forward();
        System.out.println(driver.getTitle());

        driver.navigate().refresh();

        try {
            driver.navigate().to(new URL("https://wwww.google.com"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}

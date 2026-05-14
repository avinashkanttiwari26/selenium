package seleniumSessionsPractice.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWait {
    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
         * code
         * */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //latest one is effective from that point, doesn't cumulate


    }


}

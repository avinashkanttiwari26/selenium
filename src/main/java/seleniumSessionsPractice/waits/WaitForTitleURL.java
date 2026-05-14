package seleniumSessionsPractice.waits;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForTitleURL {
    static WebDriver driver;

    public static String getTitleWait(String value) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (wait.until(ExpectedConditions.titleContains(value))) {
                @Nullable String title = driver.getTitle();
            }
            return value;
        } catch (TimeoutException e) {
            System.out.println("title not found");
        }
        return null;
    }

    public static void main(String[] args) {
        driver = new ChromeDriver();
        // driver.get("");
        String value = "";
        getTitleWait("abc");

/*        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        if(wait.until(ExpectedConditions.titleContains(value)))
        {
            @Nullable String title = driver.getTitle();
        }*/


    }


}

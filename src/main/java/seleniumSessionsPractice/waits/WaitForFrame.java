package seleniumSessionsPractice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForFrame {

    static WebDriver driver;

    public static void frameToBePresentAndSwitchWait(By frameLocator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebDriver el = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

    }


    public static void main(String[] args) {

        driver = new ChromeDriver();


    }


}

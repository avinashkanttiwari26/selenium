package seleniumSessionsPractice.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForBrowserWindow {
    static WebDriver driver;

    public static boolean waitForBrowserWindow(int timeout, int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Boolean flag = wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
        return flag;
    }


    public static void main(String[] args) {

    }


}

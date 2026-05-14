package seleniumSessionsPractice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitConcept {
    static WebDriver driver;

    public static WebElement waitForElementPresence(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));//sel 4.x
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementVisibility(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));//sel 4.x
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        By emailId = By.id("input-email");
        By password = By.id("input-password");
        By loginBtn = By.xpath("//input [@value='Login']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//sel 4.x
        WebElement ab = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));


        WebElement lgnBtn = waitForElementPresence(emailId, 5);
    }
}

package seleniumSessionsPractice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitConcept {
    static WebDriver driver;

    public static void waitElementVisibilityFluentWait(int timeout, int pollingTime, By locator) {
        Wait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("element not found");

        waitFluent.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
// below is example that same features can be used with WebDriverWait
/*        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
                                                wait.withTimeout(Duration.ofSeconds(timeout)).
                                                    pollingEvery(Duration.ofSeconds(pollingTime)).
                                                    ignoring(NoSuchElementException.class).
                                                    ignoring(StaleElementReferenceException.class).
                                                    withMessage("element not found");*/
    }

    public static void main(String[] args) {
        driver = new ChromeDriver();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .withMessage("element not found");

        driver.get("https://classic.crmpro.com");
        By pricingLink = By.linkText("pricing");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(pricingLink)));

    }


}

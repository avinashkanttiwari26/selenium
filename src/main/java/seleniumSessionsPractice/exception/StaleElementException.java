package seleniumSessionsPractice.exception;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException {
    public static void main(String[] args) throws InterruptedException {
        WebDriver  driver= new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        By login= By.id("input-email");
        driver.findElement(login).sendKeys("avi1");
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(login).sendKeys("avi2");

        //

        WebElement eleLogin = driver.findElement(login);
        eleLogin.sendKeys("avi3");
        driver.navigate().refresh();
        eleLogin.sendKeys("avi4"); //stale-element-reference-exception





    }

}

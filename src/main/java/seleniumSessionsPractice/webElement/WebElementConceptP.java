package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumSessionsPractice.utils.ElementUtils;

public class WebElementConceptP {

    static WebDriver driver;

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static void doSendKeys(By locator, String value)
    {
       getElement(locator).sendKeys(value);
    }

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        By emailId = By.id("input-email");
        By password = By.id("input-password");


        getElement(emailId).sendKeys("email");
        doSendKeys(password, "password");

        /* or - */
        ElementUtils eleUtil = new ElementUtils(driver);
        eleUtil.doSendKeys(emailId, "email");


    }

}

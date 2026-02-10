package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumSessionsPractice.utils.ElementUtils;

public class GetTextConcept {

    static WebDriver driver;

    public static String doGetText(By locator)
    {
        return driver.findElement(locator).getText();
    }

    public static String doGetAttribute(By locator, String attribute)
    {
        return driver.findElement(locator).getAttribute(attribute);
    }

    public static void main(String[] args) {
        driver = new ChromeDriver();
        ElementUtils eleUtil = new ElementUtils(driver);
        driver.manage().window().maximize();

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        By forgotPwd = By.linkText("Forgotten Password");

        System.out.println(doGetText(forgotPwd));
        System.out.println(doGetAttribute(forgotPwd, "href"));
        System.out.println(doGetAttribute(forgotPwd, "placeholder"));


    }


}

package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsEnabled {

    static WebDriver driver;

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public static boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public static void main(String[] args)
    {
        driver = new ChromeDriver();
        driver.get("https://classic.freecrm.com/register/");

        By locator = By.id("submitButton");
        isElementEnabled(locator);





    }
}

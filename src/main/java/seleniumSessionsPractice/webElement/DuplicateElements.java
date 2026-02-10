package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DuplicateElements {
    static WebDriver driver;

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static void doClick(By locator)
    {
       getElement(locator).click();
    }

    public static List<String> getElementTextLinks(By locator)
    {
        List<WebElement> ele = driver.findElements(locator);
        List<String> eleList = new ArrayList<String>();
        for (WebElement el1:ele)
        {
            if(!el1.getText().isEmpty()) {
                eleList.add(el1.getText());
            }
        }
        return eleList;

    }



    public static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        By forgotPwdLink = By.linkText("Forgotten Password");

        //practice point
        FileInputStream fis = new FileInputStream("./src/main/java/config/config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String urlNaveen = prop.get("urlNaveen").toString();
        //

        driver.get(urlNaveen);
       // driver.findElement(By.id("input-email"));
        doClick(forgotPwdLink);

        By.linkText("Forgot Password");
        By.partialLinkText(prop.getProperty("email"));
    }
}

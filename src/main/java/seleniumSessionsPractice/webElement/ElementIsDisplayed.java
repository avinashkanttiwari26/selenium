package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ElementIsDisplayed {
    static WebDriver driver;
    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static boolean isElementDisplayed(By locator)
    {
        try {
            boolean flag =  getElement(locator).isDisplayed();
            return flag;
        }
        catch (NoSuchElementException e){
        return false;
        }
    }

    public static boolean isElementDisplayedOnce(By locator)
    {
        List<WebElement> eleList = driver.findElements(locator);
        if (eleList.size()==1)
        {
            System.out.println("element is displayed once");
            return true;
        }
        else if(eleList.size()>1)
        {
            System.out.println("element is displayed multiple times");
            return false;
        }
        else if(eleList.size()==0)
        {
            System.out.println("element is not present");
            return false;
        }
    return false;
    }

    public static int elementDisplayedCount(By locator)
    {
        int displayedCount = driver.findElements(locator).size();
        return displayedCount;
    }


    public static void main(String[] args) throws IOException {

        driver=new ChromeDriver();
        driver.manage().window().maximize();

        FileInputStream fis = new FileInputStream("./src/main/java/config/config.properties");
        Properties prop = new Properties();
        prop.load(fis);

        By locator=By.id("input-email");
        By locator2=By.id("input-password");

        //System.out.println(prop.getProperty("urlNaveen"));
        driver.get(prop.getProperty("urlNaveen"));

        // isDisplayed
        boolean flag= driver.findElement(locator).isDisplayed();





    }



}

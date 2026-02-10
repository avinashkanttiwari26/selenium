package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class WebTableHandling {


    static WebDriver driver;

    public static void selectUserName(String userName){
        By username= By.xpath("//a[text() = '"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']");
        // driver.findElement(username).click();
        WebElement checkbox = driver.findElement(username);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkbox);
    }

    public static List<String> getUserDetails(String userName){
        List<WebElement> uds = driver.findElements(By.xpath("//a[text() = '"+userName+"']/parent::td/following-sibling::td"));

        List<String> userDetails=new ArrayList<String>();
        for (WebElement ud : uds) {
            String prop=ud.getText();
            userDetails.add(prop);
        }
        return userDetails;

    }

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        selectUserName("Joe.Root");

        //print row
       // List<WebElement> userDetails = driver.findElements(By.xpath("//a[text() = 'Joe.Root']/ancestor::tr/td[@class='left']"));
/*
        List<WebElement> userDetails = driver.findElements(By.xpath("//a[text() = 'Joe.Root']/parent::td/following-sibling::td"));

        for (WebElement userDetail : userDetails) {
            String prop=userDetail.getText();
            System.out.println(prop);
        }
*/

        System.out.print(getUserDetails("Joe.Root"));



    }
}

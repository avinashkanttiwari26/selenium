package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RightPanelLinks {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        // aside[@id='column-right']//a
        // a[@class='list-group-item']

        List<WebElement> rightLinksList = driver.findElements(By.xpath("//a[@class='list-group-item']"));

        System.out.println(rightLinksList.size());

        for (WebElement e : rightLinksList) {
            String text = e.getText();
            System.out.println(text);

        }

    }

}

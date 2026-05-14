package adhoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DisplayedCheck {




    @Test
    public void eleDisplayed()
    {
/*        WebDriver driver= new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        WebElement ele = driver.findElement(By.xpath("//form/div/a[contains(@href, 'forgotten')]"));
        System.out.println(ele.isDisplayed());*/

        ArrayList<String> listA = new ArrayList<String>(Arrays.asList("a", "b"));
        ArrayList<String> listB = new ArrayList<String>(Arrays.asList("a", "b","c"));

        Assert.assertEquals(listA, listB);



    }

}

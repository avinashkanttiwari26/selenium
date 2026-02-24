package seleniumSessionsPractice.jsExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetBackgroundColor {

    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        String bgColor = driver.findElement(By.xpath("//input[@value='Continue']")).getCssValue("backgroundColor");
        System.out.println(bgColor);

/*
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript()*/



    }


}

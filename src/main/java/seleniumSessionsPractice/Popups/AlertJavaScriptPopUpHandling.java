package seleniumSessionsPractice.Popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJavaScriptPopUpHandling {

    static WebDriver driver;


    public static void main(String[] args) {
        //JS alerts:
//1. alert()
//2. prompt()
//3. confirm()

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement (By.xpath("//button[text()='Click for JS Alert' ]")). click();


        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();
        alert.dismiss();// not for Prompt
        alert.sendKeys("admin"); // not for jSalert or confirm, only prompt has textbox
    }





}

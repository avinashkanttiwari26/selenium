package seleniumSessionsPractice.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowToFrame {


//    browser- page- shadodom- iframe -element


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/iframe-in-shadow-dom//");


        JavascriptExecutor js = (JavascriptExecutor) driver;

        String framepath = "return document.querySelector('#userName').shadowRoot.querySelector('#pact1')";
        WebElement eleFrame = (WebElement) js.executeScript(framepath);

        driver.switchTo().frame(eleFrame);
        driver.findElement(By.cssSelector("input#jex")).sendKeys("abcd");
        driver.findElement(By.cssSelector("button#connect")).click();

    }
}

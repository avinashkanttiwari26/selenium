package seleniumSessionsPractice.jsExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumSessionsPractice.utils.JSUtils;

public class JSExecutorConcept {

    static WebDriver driver;

    public static String getTitleByjs(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String title = js.executeScript("return document.title").toString();
        return title;
    }

    public static void main(String[] args) {
        driver= new ChromeDriver();
/*
        JavascriptExecutor js = (JavascriptExecutor) driver;
*/
        driver.get("https://www.google.com");
        //JSUtils js = new JSUtils(driver);

        System.out.println(getTitleByjs(driver));



    }


}

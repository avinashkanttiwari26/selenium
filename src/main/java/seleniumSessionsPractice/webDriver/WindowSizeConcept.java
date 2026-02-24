package seleniumSessionsPractice.webDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSizeConcept {

    public static void main(String[] args) {
        Dimension dim= new Dimension(430,932);
        WebDriver driver= new ChromeDriver();
        driver.manage().window().setSize(dim);


        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        driver.manage().window().getPosition();





    }


}

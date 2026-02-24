package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsLec17 {

    public static void main(String []ar) throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.get("https://www.aqi.in/dashboard/canada");

        By eleCity = By.xpath("//p[contains(text(), 'Gibbons')]");
        By rankPath=By.tagName("p");
        Thread.sleep(3000);
        String rank = driver.findElement(with(By.tagName("p")).toLeftOf(driver.findElement(eleCity))).getText();
        System.out.print(driver.findElement(with(By.tagName("p")).above(eleCity)).getText()); //Kerrobert, CanadaAnalyze the real-time most air polluted cities in the country.5.
        System.out.print(driver.findElement(with(By.tagName("p")).above(eleCity).below(By.xpath("//p[contains(text(), '7')]"))).getText()); //



        //System.out.print(driver.findElement(with(By.tagName("p")).toRightOf(eleCity)).getText());

        System.out.println(rank);

/*        By aqiPath=By.tagName("p");

        WebElement aqiValue = driver.findElement(with(eleCity).toRightOf(aqiPath));
        System.out.println(aqiValue);*/





    }



}

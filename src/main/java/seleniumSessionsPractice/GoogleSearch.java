package seleniumSessionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearch {

    static WebDriver driver;
    public List<String> searchSuggesetions(By searchbox, By searchSuggestions, String searchText)
    {
        driver.findElement(searchbox).sendKeys(searchText);
        List<WebElement> searchSuggestion = driver.findElements(searchSuggestions);

        List<String> list= new ArrayList<String>();

        for(WebElement e: searchSuggestion)
        {
            System.out.println(e.getText());
            list.add(e.getText());
        }

        return list;

    }

    public void clickhSuggesetions(By searchbox, By searchSuggestions, String searchText, String clickSuggestion)
    {
        driver.findElement(searchbox).sendKeys(searchText);
        List<WebElement> searchSuggestion = driver.findElements(searchSuggestions);

        List<String> list= new ArrayList<String>();

        for(WebElement e: searchSuggestion)
        {
            if (e.getText().contains(clickSuggestion))  //(e.getText().equals(clickSuggestion)
            {
                e.click();
                break;
            }
        }

    }




    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium Search");
        Thread.sleep(3000);
        By list= By.xpath("//ul [@class='G43f7e']/li");

        List<WebElement> listAll = driver.findElements(list);

        for (WebElement el : listAll) {
            System.out.println(el.getText());

        }


    }
}

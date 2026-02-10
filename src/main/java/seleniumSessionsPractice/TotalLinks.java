package seleniumSessionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class TotalLinks {
    static WebDriver driver;

    public List<WebElement> getElements(By locator)
    {
        return driver.findElements(locator);
    }

    public int  getElementsSize(By locator)
    {
        return driver.findElements(locator).size();
    }
    public static List<String> getElementTextLinks(By locator)
    {
        List<WebElement> ele = driver.findElements(locator);
        List<String> eleList = new ArrayList<String>();
        for (WebElement el1:ele)
        {
            if(!el1.getText().isEmpty()) {
                eleList.add(el1.getText());
            }
        }
        return eleList;

    }

    public static void main(String[] args) {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://naveenautomationlabs.com/opencart");

        //htmltag = <a>
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int sizeLinks = links.size();
        System.out.println("total links: "+sizeLinks);
/*
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
        //or

        for (int i = 0; i<links.size();i++) {
            System.out.println(links.get(i).getText()+"     "+ links.get(i).getAttribute("href"));
        }*/


        // print links only if has text
        // print how many links have text and how many hasnt.
        int hasText=0;
        for(WebElement link : links) {
            if(link.getText().trim().length()!=0)
            {
                System.out.println(link.getText()+"     "+link.getAttribute("href"));
                hasText++;
            }
        }
        System.out.println("total links: "+sizeLinks);
        System.out.println("hasText: "+hasText);
        System.out.println("doesn't have text:  "+(sizeLinks-hasText));

        List<String> linkAll = getElementTextLinks(By.tagName("a"));
        System.out.println("total links: "+linkAll);
        System.out.println("total links with text: "+linkAll.size());
        System.out.println(linkAll.contains("Avinash"));
    }

}

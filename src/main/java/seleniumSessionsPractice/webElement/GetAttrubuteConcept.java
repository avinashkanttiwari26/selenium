package seleniumSessionsPractice.webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class GetAttrubuteConcept {
    static WebDriver driver;

    public static List<String> getAttributeList(By locator, String att)
    {
        List<WebElement> attList = driver.findElements(locator);
        List<String> listAtt = new ArrayList<String>();

        for(WebElement e: attList)
        {
            String attValue = e.getAttribute(att).trim();
            if(!attValue.equals(null) && !attValue.isEmpty()) {
                //System.out.println(attValue);
                listAtt.add(attValue);
            }
        }
        return listAtt;
    }

    public static void main(String[] args) {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");

        By img= By.tagName("img");
        List<WebElement> imgList = driver.findElements(img);

        for(WebElement e: imgList)
        {

            String srcValue = e.getAttribute("src");
            if(!srcValue.equals(null)) {
                System.out.println(srcValue);
            }
        }

    }
}

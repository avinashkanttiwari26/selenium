package seleniumSessionsPractice.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownWithoutSelect {


    static WebDriver driver;
    //WAP to select a value without using select class methods: by index , by value ...

    public void selectValue(By locator, String expectedText)
    {
        Select sel = new Select(driver.findElement(locator));
        List<WebElement> listOptions = sel.getOptions();

        for (WebElement element: listOptions )
        {
            if (element.getText().equals(expectedText.trim()))
            {
                element.click();
                break;
            }
        }
    }
    //WAP to select a value without using select class
    public void selectWithoutSelectClass(By locator, String expectedText)
    {
        List<WebElement> allOptions = driver.findElements(locator);
        for (WebElement element: allOptions )
        {
            if (element.getText().equals(expectedText.trim()))
            {
                element.click();
                break;
            }
        }

    }


    public static void main(String[] args) {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.orangehrm.com/en/contact-sales/");

    By locator = By.id("Form_getForm_Country");
    By locator1 = By.id("Form_getForm_No0fEmployees");


//1   WAP to select a value without using select class methods: by index , by value ...
    String expectedText = "Canada";
    Select sel = new Select(driver.findElement(locator));
    List<WebElement> listOptions = sel.getOptions();

    for (WebElement element: listOptions )
    {
        if (element.getText().equals(expectedText.trim()))
        {
            element.click();
            break;
        }
    }

//2 WAP to select a value without using select class
    locator=By.xpath("//select[@name= 'Country']//option");
    List<WebElement> allOptions = driver.findElements(locator);
        for (WebElement element: allOptions )
        {
            if (element.getText().equals(expectedText.trim()))
            {
                element.click();
                break;
            }
        }
        List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
        WebElement firstSelectedOption = sel.getFirstSelectedOption();



    }
}

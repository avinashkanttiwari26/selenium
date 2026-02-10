package seleniumSessionsPractice.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SelectDropDownHandling {

    WebDriver driver;

    public void doSelectByValue(By locator, String att)
    {
        Select sel = new Select(driver.findElement(locator));
        sel.selectByValue(att);

    }
    public void doSelectByIndex(By locator, int index)
    {
        Select sel = new Select(driver.findElement(locator));
        sel.selectByIndex(1);

    }

    public void doSelectByVisibleText(By locator, String att)
    {
        Select sel = new Select(driver.findElement(locator));
        sel.selectByValue(att);

    }

    public List<String> getOptionsText(By locator)
    {
        Select sel = new Select(driver.findElement(locator));
        List<WebElement> dropDownOptions = sel.getOptions();

        List<String> dropDownOptionsText =new ArrayList<String>();// List.of()

        for(WebElement option : dropDownOptions)
        {
            String text = option.getText();
            dropDownOptionsText.add(text);
        }

        return dropDownOptionsText;
    }

    public int dropDownSize(By locator)
    {
        Select sel = new Select(driver.findElement(locator));
        return sel.getOptions().size();
    }







    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("");

        By country = By.name("country");
        By region = By.name("india");

        Select countryDropDown = new Select(driver.findElement(country));

        //**************************** SelectBy *************************//
        countryDropDown.selectByVisibleText("United States");
        countryDropDown.selectByIndex(1);
        countryDropDown.selectByValue("ind"); //value and text might be different
        countryDropDown.selectByContainsVisibleText("United");

        //**************************** DeSelectBy *************************//
        // only works for multi select options
        countryDropDown.deselectByVisibleText("United States");
        countryDropDown.deselectByIndex(1);
        countryDropDown.deselectByValue("United States");
        countryDropDown.deselectByIndex(1);
        countryDropDown.deselectAll();

        //**************************** GetAllOptions *************************//
        Select sel = new Select(driver.findElement(country));
        List<WebElement> dropDownOptions = sel.getOptions();

        List<String> dropDownOptionsText =new ArrayList<String>();// List.of()

        for(WebElement option : dropDownOptions)
        {
            String text = option.getText();
            dropDownOptionsText.add(text);
        }

        //**************************** Multiple *************************//
        // 'multiple' attribute will be present inside select tag

        By locator2= By.xpath("");

        Select selDropDown = new Select(driver.findElement(locator2));
        boolean isMultiple = selDropDown.isMultiple();
        if (isMultiple)
        {
            selDropDown.selectByValue("United States");
            selDropDown.deselectByVisibleText("India");
        }








    }

}

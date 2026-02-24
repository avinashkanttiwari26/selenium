package seleniumSessionsPractice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtils {
    private WebDriver driver; // null session id
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    private void nullCheck(String value){
        if (value == null) { throw new NullPointerException("value is null");}
    }
    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void doSendKeys(By locator, String value)
    {
        nullCheck(value);
        getElement(locator).sendKeys(value);
    }
    public void doClick(By locator)
    {
        getElement(locator).click();
    }

    public WebElement getElement(By locator)
    {
        try
            {
                return driver.findElement(locator);
            }
        catch (NoSuchElementException ex)
        {
            System.out.println(locator + " not found");
            ex.printStackTrace();
        }
        return null;
    }

    public  String doGetText(By locator)
    {
        return getElement(locator).getText();
    }

    public  String doGetAttribute(By locator, String attribute)
    {
        return getElement(locator).getAttribute(attribute);
    }

    public List<WebElement> getElements(By locator)
    {
        return driver.findElements(locator);
    }

    public int  getElementsSize(By locator)
    {
        return driver.findElements(locator).size();
    }


    public  List<String> getElementTextLinks(By locator)
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

    public List<String> getAttributeList(By locator, String att)
    {
        List<WebElement> attList = driver.findElements(locator);
        List<String> listAtt = new ArrayList<String>();

        for(WebElement e: attList)
        {
            String attValue = e.getAttribute(att).trim();
            if(attValue != null && !attValue.isEmpty()) {
                System.out.println(attValue);
                listAtt.add(attValue);
            }
        }
        return listAtt;
    }



    //************************************* Select Class Util *******************************//
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

    public void clickSuggesetions(By searchbox, By searchSuggestions, String searchText, String clickSuggestion)
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

    //************************************* isDisplayed *******************************//
    public  boolean isElementDisplayed(By locator)
    {
        try {
            boolean flag =  getElement(locator).isDisplayed();
            return flag;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public  boolean isElementDisplayedOnce(By locator)
    {
        List<WebElement> eleList = driver.findElements(locator);
        if (eleList.size()==1)
        {
            System.out.println("element is displayed once");
            return true;
        }
        else if(eleList.size()>1)
        {
            System.out.println("element is displayed multiple times");
            return false;
        }
        else if(eleList.size()==0)
        {
            System.out.println("element is not present");
            return false;
        }
        return false;
    }

    public int elementDisplayedCount(By locator)
    {
        int displayedCount = driver.findElements(locator).size();
        return displayedCount;
    }

    //************************************* isEnabled *******************************//
    public  boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }
    //************************************* isSelected *******************************//
    public  boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    //************************************* isSelected *******************************//

    //************************************* Actions *******************************//

    public  void handleSubMenu(By parentLocator, By childLocator){
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(parentLocator)).perform();
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(childLocator)
        );
        driver.findElement(childLocator).click();
    }

    public void hover(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        new Actions(driver)
                .moveToElement(element)
                .pause(Duration.ofMillis(200))
                .perform();
    }

    public void dragAndDrop( By source, By dest) {
        Actions act= new Actions(driver);
        act.dragAndDrop(driver.findElement(source), driver.findElement(dest)).perform();
        // or
/*
        act.dragAndDropBy(driver.findElement(source), 100,0 ).release().perform();
*/
        //  or
   /*     act.
                clickAndHold(driver.findElement(source)).
                moveToElement(driver.findElement(dest)).
                release().build().perform();*/
    }

    public void doActionsSendKeys(By locator, String text)
    {
        Actions act= new Actions(driver);
        act.sendKeys(driver.findElement(locator), text).perform();
    }

    public void doActionsClick(By locator)
    {
        Actions act= new Actions(driver);
        act.click(driver.findElement(locator)).perform();
    }
    public void doSendKeysWithPause(By locator, String text)
    {
        Actions act= new Actions(driver);
        char[] ch =text.toCharArray();
        for (char c: ch)
        {
            act.sendKeys(driver.findElement(locator), String.valueOf(c)).pause(500).perform();
        }

    }
    public  void multiLevelhover(By ele1, By ele2, By ele3, By ele4) throws InterruptedException {
        Actions act= new Actions(driver);
        Thread.sleep(1000);

        act.moveToElement(driver.findElement(ele1)).click().pause(Duration.ofMillis(500)).perform();
        act.moveToElement(driver.findElement(ele2)).pause(Duration.ofMillis(500)).perform();
        act.moveToElement(driver.findElement(ele3)).pause(Duration.ofMillis(500)).perform();
        act.moveToElement(driver.findElement(ele4)).click().perform();
    }


}
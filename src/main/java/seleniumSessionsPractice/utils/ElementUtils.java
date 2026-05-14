package seleniumSessionsPractice.utils;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtils {
    private WebDriver driver; // null session id
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    private void nullCheck(String value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }
    }

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void doSendKeys(By locator, String value) {
        nullCheck(value);
        getElement(locator).sendKeys(value);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public WebElement getElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException ex) {
            System.out.println(locator + " not found");
            ex.printStackTrace();
        }
        return null;
    }

    public String doGetText(By locator) {
        return getElement(locator).getText();
    }

    public String doGetAttribute(By locator, String attribute) {
        return getElement(locator).getAttribute(attribute);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public int getElementsSize(By locator) {
        return driver.findElements(locator).size();
    }


    public List<String> getElementTextLinks(By locator) {
        List<WebElement> ele = driver.findElements(locator);
        List<String> eleList = new ArrayList<String>();
        for (WebElement el1 : ele) {
            if (!el1.getText().isEmpty()) {
                eleList.add(el1.getText());
            }
        }
        return eleList;

    }

    public List<String> getAttributeList(By locator, String att) {
        List<WebElement> attList = driver.findElements(locator);
        List<String> listAtt = new ArrayList<String>();

        for (WebElement e : attList) {
            String attValue = e.getAttribute(att).trim();
            if (attValue != null && !attValue.isEmpty()) {
                System.out.println(attValue);
                listAtt.add(attValue);
            }
        }
        return listAtt;
    }


    //************************************* Select Class Util *******************************//
    public void doSelectByValue(By locator, String att) {
        Select sel = new Select(driver.findElement(locator));
        sel.selectByValue(att);

    }

    public void doSelectByIndex(By locator, int index) {
        Select sel = new Select(driver.findElement(locator));
        sel.selectByIndex(1);

    }

    public void doSelectByVisibleText(By locator, String att) {
        Select sel = new Select(driver.findElement(locator));
        sel.selectByValue(att);

    }

    public List<String> getOptionsText(By locator) {
        Select sel = new Select(driver.findElement(locator));
        List<WebElement> dropDownOptions = sel.getOptions();

        List<String> dropDownOptionsText = new ArrayList<String>();// List.of()

        for (WebElement option : dropDownOptions) {
            String text = option.getText();
            dropDownOptionsText.add(text);
        }

        return dropDownOptionsText;
    }

    public int dropDownSize(By locator) {
        Select sel = new Select(driver.findElement(locator));
        return sel.getOptions().size();
    }

    public void selectValue(By locator, String expectedText) {
        Select sel = new Select(driver.findElement(locator));
        List<WebElement> listOptions = sel.getOptions();

        for (WebElement element : listOptions) {
            if (element.getText().equals(expectedText.trim())) {
                element.click();
                break;
            }
        }
    }

    public void selectWithoutSelectClass(By locator, String expectedText) {
        List<WebElement> allOptions = driver.findElements(locator);
        for (WebElement element : allOptions) {
            if (element.getText().equals(expectedText.trim())) {
                element.click();
                break;
            }
        }

    }

    public List<String> searchSuggesetions(By searchbox, By searchSuggestions, String searchText) {
        driver.findElement(searchbox).sendKeys(searchText);
        List<WebElement> searchSuggestion = driver.findElements(searchSuggestions);

        List<String> list = new ArrayList<String>();

        for (WebElement e : searchSuggestion) {
            System.out.println(e.getText());
            list.add(e.getText());
        }

        return list;

    }

    public void clickSuggesetions(By searchbox, By searchSuggestions, String searchText, String clickSuggestion) {
        driver.findElement(searchbox).sendKeys(searchText);
        List<WebElement> searchSuggestion = driver.findElements(searchSuggestions);

        List<String> list = new ArrayList<String>();

        for (WebElement e : searchSuggestion) {
            if (e.getText().contains(clickSuggestion))  //(e.getText().equals(clickSuggestion)
            {
                e.click();
                break;
            }
        }

    }

    //************************************* isDisplayed *******************************//
    public boolean isElementDisplayed(By locator) {
        try {
            boolean flag = getElement(locator).isDisplayed();
            return flag;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementDisplayedOnce(By locator) {
        List<WebElement> eleList = driver.findElements(locator);
        if (eleList.size() == 1) {
            System.out.println("element is displayed once");
            return true;
        } else if (eleList.size() > 1) {
            System.out.println("element is displayed multiple times");
            return false;
        } else if (eleList.size() == 0) {
            System.out.println("element is not present");
            return false;
        }
        return false;
    }

    public int elementDisplayedCount(By locator) {
        int displayedCount = driver.findElements(locator).size();
        return displayedCount;
    }

    //************************************* isEnabled *******************************//
    public boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    //************************************* isSelected *******************************//
    public boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    //************************************* isSelected *******************************//

    //************************************* Actions *******************************//

    public void handleSubMenu(By parentLocator, By childLocator) {
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

    public void dragAndDrop(By source, By dest) {
        Actions act = new Actions(driver);
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

    public void doActionsSendKeys(By locator, String text) {
        Actions act = new Actions(driver);
        act.sendKeys(driver.findElement(locator), text).perform();
    }

    public void doActionsClick(By locator) {
        Actions act = new Actions(driver);
        act.click(driver.findElement(locator)).perform();
    }

    public void doSendKeysWithPause(By locator, String text) {
        Actions act = new Actions(driver);
        char[] ch = text.toCharArray();
        for (char c : ch) {
            act.sendKeys(driver.findElement(locator), String.valueOf(c)).pause(500).perform();
        }

    }

    public void multiLevelhover(By ele1, By ele2, By ele3, By ele4) throws InterruptedException {
        Actions act = new Actions(driver);
        Thread.sleep(1000);

        act.moveToElement(driver.findElement(ele1)).click().pause(Duration.ofMillis(500)).perform();
        act.moveToElement(driver.findElement(ele2)).pause(Duration.ofMillis(500)).perform();
        act.moveToElement(driver.findElement(ele3)).pause(Duration.ofMillis(500)).perform();
        act.moveToElement(driver.findElement(ele4)).click().perform();
    }

    //************************************* Wait Utils *******************************//

    /*
        doesn't care about visibility; once element is present in dom it proceeds
    */
    public WebElement waitForElementPresence(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));//sel 4.x
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementVisibility(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));//sel 4.x
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /*
        checks for visibility, enability, clickability
    */
    public WebElement waitForElementClickable(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));//sel 4.x
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void doClickWait(By locator, int timeOut) {
        waitForElementClickable(locator, timeOut).click();
    }

    public void doSendKeysWait(By locator, int timeOut, String text) {
        waitForElementVisibility(locator, timeOut).sendKeys(text);
    }

    public String getTitleWait(String value) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (wait.until(ExpectedConditions.titleContains(value))) {
                @Nullable String title = driver.getTitle();
            }
            return value;
        } catch (TimeoutException e) {
            System.out.println("title not found");
        }
        return driver.getTitle();
    }

    public String getURLPartialWait(String value) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (wait.until(ExpectedConditions.urlContains(value))) {
                @Nullable String title = driver.getTitle();
            }
            return value;
        } catch (TimeoutException e) {
            System.out.println("URL not found");
        }
        return driver.getTitle();
    }

    public String getURLFullWait(String value) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (wait.until(ExpectedConditions.urlToBe(value))) {
                @Nullable String title = driver.getTitle();
            }
            return value;
        } catch (TimeoutException e) {
            System.out.println("URL not found");
        }
        return driver.getTitle();
    }

    //************************************* Handle JS Alert Wait Utils *******************************//

    //below function automatically switches to js popup. no need to switch explicitly.
    public Alert getJsAlertWait(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return alert;
    }

    public void jsAlertAcceptWait(int timeout) {
        getJsAlertWait(timeout).accept();
    }

    public void jsAlertDismisstWait(int timeout) {
        getJsAlertWait(timeout).dismiss();
    }

    public String jsAlertgetTextAndAcceptWait(int timeout) {
        Alert alert = getJsAlertWait(timeout);
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void jsAlertSendKeysWait(int timeout, String value) {
        getJsAlertWait(timeout).sendKeys(value);
    }

    public Boolean isPageLoaded(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        String flag = wait.until(ExpectedConditions.jsReturnsValue("return doucment.readyState==='complete'")).toString();
        return Boolean.parseBoolean(flag);
    }

    public void waitElementVisibilityFluentWait(int timeout, int pollingTime, By locator) {
        Wait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("element not found");

        waitFluent.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
// below is example that same features can be used with WebDriverWait
/*        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
                                                wait.withTimeout(Duration.ofSeconds(timeout)).
                                                    pollingEvery(Duration.ofSeconds(pollingTime)).
                                                    ignoring(NoSuchElementException.class).
                                                    ignoring(StaleElementReferenceException.class).
                                                    withMessage("element not found");*/
    }

    //************************************* Handle frame Wait Utils *******************************//

    public void frameToBePresentAndSwitchWait(By frameLocator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebDriver el = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

    }

    public boolean waitForBrowserWindow(int timeout, int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Boolean flag = wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
        return flag;
    }
    //************************************* ?? presence of all elements by locator*******************************//
    //add here

    //************************************* ?? presence of all elements by locator*******************************//


}
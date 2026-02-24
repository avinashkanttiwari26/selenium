package seleniumSessionsPractice.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class JSUtils {

    private JSUtils() {
        // Prevent instantiation
    }

    private static JavascriptExecutor getJS(WebDriver driver) {
        return (JavascriptExecutor) driver;
    }

    /* ===================== PAGE INFO ===================== */

    public static String getTitle(WebDriver driver) {
        return (String) getJS(driver).executeScript("return document.title;");
    }

    public static String getCurrentURL(WebDriver driver) {
        return (String) getJS(driver).executeScript("return window.location.href;");
    }

    public static String getReadyState(WebDriver driver) {
        return (String) getJS(driver).executeScript("return document.readyState;");
    }

    public static Long getPageHeight(WebDriver driver) {
        return (Long) getJS(driver).executeScript("return document.body.scrollHeight;");
    }

    public static String getEntirePageText(WebDriver driver) {
        return (String) getJS(driver).executeScript("return document.body.innerText;");
    }

    /* ===================== SCROLLING ===================== */

    public static void scrollToBottom(WebDriver driver) {
        getJS(driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollToTop(WebDriver driver) {
        getJS(driver).executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        getJS(driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void smoothScrollToBottom(WebDriver driver) {
        getJS(driver).executeScript(
                "window.scrollTo({top: document.body.scrollHeight, behavior: 'smooth'});"
        );
    }

    /* ===================== ELEMENT INTERACTIONS ===================== */

    public static void clickByJS(WebDriver driver, WebElement element) {
        getJS(driver).executeScript("arguments[0].click();", element);
    }

    public static void setValueByJS(WebDriver driver, WebElement element, String value) {
        getJS(driver).executeScript("arguments[0].value=arguments[1];", element, value);
        //js.executeScript("document.querySelector(cssPath).value=tom");
    }

    public static void clearValueByJS(WebDriver driver, WebElement element) {
        getJS(driver).executeScript("arguments[0].value='';", element);
    }

    public static void removeDisabledAttribute(WebDriver driver, WebElement element) {
        getJS(driver).executeScript("arguments[0].removeAttribute('disabled');", element);
    }
    public static void triggerChangeEvent(WebDriver driver, WebElement element) {
        getJS(driver).executeScript(
                "arguments[0].dispatchEvent(new Event('change'));", element
        );
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        getJS(driver).executeScript(
                "arguments[0].style.border='3px solid red';", element
        );
    }

    public static boolean isElementVisible(WebDriver driver, WebElement element) {
        return (Boolean) getJS(driver)
                .executeScript("return arguments[0].offsetParent !== null;", element);
    }

    public static String getComputedCSS(WebDriver driver, WebElement element, String property) {
        return (String) getJS(driver)
                .executeScript(
                        "return window.getComputedStyle(arguments[0])[arguments[1]];",
                        element, property
                );
    }

    /* ===================== BROWSER NAVIGATION ===================== */

    public static void refreshPage(WebDriver driver) {
        getJS(driver).executeScript("location.reload();");
    }

    public static void navigateBack(WebDriver driver) {
        getJS(driver).executeScript("history.back();");
    }

    public static void openNewTab(WebDriver driver, String url) {
        getJS(driver).executeScript("window.open(arguments[0],'_blank');", url);
    }

    /* ===================== DATA EXTRACTION ===================== */

    @SuppressWarnings("unchecked")
    public static List<String> getAllLinks(WebDriver driver) {
        return (List<String>) getJS(driver).executeScript(
                "return Array.from(document.querySelectorAll('a')).map(a => a.href);"
        );
    }

    @SuppressWarnings("unchecked")
    public static List<String> getAllInputValues(WebDriver driver) {
        return (List<String>) getJS(driver).executeScript(
                "return Array.from(document.querySelectorAll('input')).map(i => i.value);"
        );
    }

    /* ===================== VALIDATION TESTING ===================== */

    public static void removeMaxLength(WebDriver driver, WebElement element) {
        getJS(driver).executeScript(
                "arguments[0].removeAttribute('maxlength');", element
        );
    }

    public static void removePatternValidation(WebDriver driver, WebElement element) {
        getJS(driver).executeScript(
                "arguments[0].removeAttribute('pattern');", element
        );
    }
}
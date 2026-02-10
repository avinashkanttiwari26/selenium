package seleniumSessionsPractice.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
    WebDriver driver;

    public WebDriver launchBrowser(String browser) {
        switch (browser.trim().toLowerCase())
        {
            case
                    "chrome": driver = new ChromeDriver();         break;
            case
                    "firefox": driver = new FirefoxDriver();       break;
            case
                    "edge": driver = new EdgeDriver();             break;

            default:
                System.out.println("Browser Not Found");
                throw new BrowserException("Browser Not Found");
            //break; -- unreachable when exception is there
        }
        return driver;
    }

    public void getURL(String url) {
        if (url== null) {
            throw new BrowserException("url is null");
        }
        else if (url.isEmpty()) {
            throw new BrowserException("url is empty");
        }
        else if (url.indexOf("http")!=0) {
            throw new BrowserException("prefix- 'http(s)' not found: "+url);// https is automatically covered
        }
        driver.get(url);
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public String getPageCurrentURL()
    {
        return driver.getCurrentUrl();
    }

    public void quitBrowser()
    {
        driver.quit();
    }

    public void closeBrowser()
    {
        driver.close();
    }

}

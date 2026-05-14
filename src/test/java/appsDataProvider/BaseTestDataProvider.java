package appsDataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import seleniumsessions.BrowserException;

public class BaseTestDataProvider {
    public WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void setup(String browser, String url) {

        switch (browser.trim().toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("invalid browser: " + browser);
                throw new BrowserException("invalid browser name.");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterTest
    public void teardown() throws InterruptedException {
        //  driver.quit();
    }

}

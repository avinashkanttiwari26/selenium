package appsParametrisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    /*    @AfterMethod
        public void teardown() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "(function() {" +
                            "let shouldClose = true;" +
                            "let timer = setTimeout(function() {" +
                            "if (shouldClose) { window.close(); }" +
                            "}, 10000);" +
                            "if (confirm('This window will close in 10 seconds.\\nClick OK to cancel.')) {" +
                            "shouldClose = false;" +
                            "clearTimeout(timer);" +
                            "}" +
                            "})();"
            );
            Thread.sleep(10);
            driver.quit();
        }*/
    @AfterMethod
    public void teardown() throws InterruptedException {
        driver.quit();
    }

}

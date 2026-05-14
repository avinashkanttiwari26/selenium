package adhoc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRun_A {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");
        driver = new ChromeDriver();
        driver.close();
        // driver.get("https://www.yahoo.com");

/*
        new FirefoxDriver();
        new SafariDriver();
*/
    }

}

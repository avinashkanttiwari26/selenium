package testNGSessions;

import appsParametrisation.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartLoginTest extends BaseTest {
    //  WebDriver driver;

/*

    @BeforeTest
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

    }
*/

    @Test(description = "========validate title===========")
    public void loginPageTitleTest() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        String expTitle = "Google";
        String actTitle = driver.getTitle();
        //msg prints only in case of fail
        Assert.assertEquals(actTitle, expTitle, "Fail:Case Assert Title. ActualTitle: " + actTitle);
    }

    @Test(description = "========validate URL===========")
    public void loginPageURLTest() throws InterruptedException {
        driver.get("https://www.google.com");

        Thread.sleep(3000);

        String expURL = "flipkart";
        String actURL = driver.getTitle();
        //msg prints only in case of fail
        Boolean flag = actURL.contains(expURL);
        Assert.assertTrue(flag, "Fail:Case Assert Title. ActualTitle: " + actURL);
    }

  /*
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
*/


}

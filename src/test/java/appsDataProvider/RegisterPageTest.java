package appsDataProvider;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTestDataProvider {

    public static String randomEmail() {
        String randomEmail = "openkart" + System.currentTimeMillis() + "@opencart.com";
        return randomEmail;
    }

    @DataProvider
    public Object[][] getRegTestData() {
        return new Object[][]{
                {"AviA", "seleniumA", "8888999901", "Kavi@123"},
                {"AviB", "seleniumB", "8888999902", "Kavi@123"},
                /* {"AviC", "seleniumC", "avif@gmail.com", "8888999903", "Kavi@123"},*/
                /* {"AviD", "seleniumD", "aviD@gmail.com", "8888999904", "Kavi@123"}*/
        };
    }

    @Test(dataProvider = "getRegTestData")
    public void registerTest(String firstName, String lastName, String telephone, String password) throws InterruptedException {

        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(randomEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);
        driver.findElement(By.name("agree")).click();
        Thread.sleep(8000);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String text = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(text);
        Thread.sleep(8000);
        Assert.assertEquals(text, "Your Account Has Been Created!");
        Thread.sleep(8000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(8000);
        driver.findElement(By.linkText("Register")).click();
    }
}
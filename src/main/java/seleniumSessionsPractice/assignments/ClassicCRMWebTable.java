package seleniumSessionsPractice.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ClassicCRMWebTable {
    static WebDriver driver;

    public static void clickContacts(By locator) throws InterruptedException
    {
        Thread.sleep(2000);
        driver.switchTo().frame("mainpanel");
        driver.findElement(locator).click();
    }

    public static void clickCheckbox(String name) throws InterruptedException {
        By eleCheckbox = By.xpath("//a[text() ='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']");
        driver.findElement(eleCheckbox).click();
    }

    public static String getCompanyName(String name) throws InterruptedException {
        By eleCompany = By.xpath("//a[text() ='" + name + "']/parent::td/following-sibling::td/a[@context='company']");
        return driver.findElement(eleCompany).getText();
    }

    public static void clickMultiNames(String name)
    {
        By eleCheckbox = By.xpath("//a[text() ='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']");
        List<WebElement> names = driver.findElements(eleCheckbox);
        for(WebElement n: names)
        {
            n.click();
        }
    }

    public static void selectLastMathcingName(String name) throws InterruptedException {
        By eleCheckbox = By.xpath("(//a[text() ='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox'])[last()]");
        driver.findElement(eleCheckbox).click();

        //a[text()='Raman patil']/parent::td/preceding-sibling::td/child::input[@type='checkbox'])[last()]
        //a[text() ='Raman patil']/parent::td/preceding-sibling::td/input[@type='checkbox'][last()])
    }

    public static void main(String[] args) throws InterruptedException {

        driver=new ChromeDriver();
        By username = By.name("username");
        By password = By.name("password");
        By btnLogin= By.xpath("//input[@value='Login']");
        By btnContact= By.linkText("CONTACTS");

        String url = "https://classic.freecrm.com/";

        driver.get(url);
        Thread.sleep(2000);

        driver.findElement(username).sendKeys("apiautomation");
        driver.findElement(password).sendKeys("Selenium@12345");
        driver.findElement(btnLogin).click();

        Thread.sleep(5000);
        driver.switchTo().frame("mainpanel");
        driver.findElement(btnContact).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(4000);

        //click checkbox
        String name="Raju Rastogi";
/*      By eleCheckbox = By.xpath("//a[text() ='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']");
        driver.findElement(eleCheckbox).click();*/

        //clickCheckbox(name);

        // find company
/*      By eleCompany = By.xpath("//a[text() ='" + name + "']/parent::td/following-sibling::td/a[@context='company']");
        String companyName = driver.findElement(eleCompany).getText();*/
        System.out.println(getCompanyName(name));

        //select multi
        //clickMultiNames(name);

        //select last
        //By eleCheckbox = By.xpath("//a[text() ='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox'][last()]");
        String lastName="Raman patil";
        selectLastMathcingName(lastName);

    }


}

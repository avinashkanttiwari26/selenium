package seleniumSessionsPractice.Popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {

    static WebDriver driver;
     public void uploadFile(By locator, String filepath) {
         driver.findElement(locator).sendKeys(filepath);
     }

    public static void main(String[] args) {
    driver = new ChromeDriver();
    driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

    By locator= By.name("upfile");
    //String filepath="filepath/filename.txt";
    String filepath="C:\\Users\\avina\\IdeaProjects\\Selenium\\src\\main\\resources\\sampletext.txt";
    driver.findElement(locator).sendKeys(filepath);

    }

}

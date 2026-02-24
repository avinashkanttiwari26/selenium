package seleniumSessionsPractice.windowHandle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowTabConcept {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//parent
        String parentWindowHandle= driver.getWindowHandle();
        Thread.sleep(3000);

        //sel 4.0





    }


}

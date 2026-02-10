package seleniumSessionsPractice;

import org.openqa.selenium.WebDriver;
import seleniumSessionsPractice.utils.BrowserUtils;
import seleniumSessionsPractice.utils.ReadProperty;

import java.util.Properties;

public class OpenCartTest {
    public static void main(String[] args) {
        //String browser = "chrome";

        ReadProperty readProp = new ReadProperty();
        Properties prop = readProp.initProp();
        String browser = prop.get("browser").toString();
        String url = prop.get("url").toString();


        BrowserUtils brUtil = new BrowserUtils();
        WebDriver driver = brUtil.launchBrowser(browser);

        brUtil.getURL(url);
        String actTitle = brUtil.getPageTitle();
        //validation
        if (actTitle.trim().equals("Google Search")) {
            System.out.println("page title: pass");
        } else {
            System.out.println("page title: fail");
        }
        brUtil.quitBrowser();

        System.out.println("success");
    }

}

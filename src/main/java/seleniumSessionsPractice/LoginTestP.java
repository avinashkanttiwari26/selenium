package seleniumSessionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import seleniumSessionsPractice.utils.BrowserUtils;
import seleniumSessionsPractice.utils.ElementUtils;
import seleniumSessionsPractice.utils.ReadProperty;

import java.util.Properties;

public class LoginTestP {

    public static void main(String[] args) {
        BrowserUtils brUtils = new BrowserUtils();
        ReadProperty readProp = new ReadProperty();
        Properties prop = readProp.initProp();

        String browser = prop.get("browser").toString();
        String urlNaveen = prop.get("urlNaveen").toString();

        WebDriver driver =brUtils.launchBrowser(browser);
        ElementUtils eleUtil = new ElementUtils(driver);

        brUtils.getURL(urlNaveen);
        System.out.println("title: "+brUtils.getPageTitle());
        System.out.println("url: "+brUtils.getPageCurrentURL());

        By emailId = By.id("input-email");
        By password = By.id("input-password");

        eleUtil.doSendKeys(emailId, "email");
        eleUtil.doSendKeys(password, "password");

        brUtils.closeBrowser();




    }

}

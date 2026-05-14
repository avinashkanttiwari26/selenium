package seleniumSessionsPractice.waits;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitJSAlert {

    static WebDriver driver;

    //below function automatically switches to js popup. no need to switch explicitly.
    public static Alert getJsAlertWait(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return alert;
    }

    public static void jsAlertAcceptWait(int timeout) {
        getJsAlertWait(timeout).accept();
    }

    public static void jsAlertDismisstWait(int timeout) {
        getJsAlertWait(timeout).dismiss();
    }

    public static String jsAlertgetTextAndAcceptWait(int timeout) {
        Alert alert = getJsAlertWait(timeout);
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public static void jsAlertSendKeysWait(int timeout, String value) {
        getJsAlertWait(timeout).sendKeys(value);
    }


    public static void main(String[] args) {

    }


}

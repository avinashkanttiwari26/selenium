package a_IQs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {
    private ScreenShotUtil() {
        // Utility class – prevent instantiation
    }

    public static String takeScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir")
                + "/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            FileHandler.createDir(new File(System.getProperty("user.dir") + "/screenshots"));
            FileHandler.copy(src, new File(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }

        return screenshotPath;
    }
}

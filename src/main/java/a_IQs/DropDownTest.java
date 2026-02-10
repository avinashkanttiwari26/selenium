package a_IQs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {

    public static boolean isOptionAlreadySelected(WebElement dropdown) {
        Select select = new Select(dropdown);

        WebElement selectedOption = select.getFirstSelectedOption();
        String value = selectedOption.getAttribute("value");

        return value != null &&
                !value.trim().isEmpty() &&
                !value.equals("0") &&
                !value.equalsIgnoreCase("NONE");
    }

}

package a_IQs;

import org.openqa.selenium.WebElement;
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

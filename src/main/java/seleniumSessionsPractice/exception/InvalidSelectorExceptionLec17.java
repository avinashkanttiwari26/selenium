package seleniumSessionsPractice.exception;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidSelectorExceptionLec17 {
/*
- syntax is correct:  NoSuchElementException
- incorrect syntax: InvalidSelector OR JavaScriptException
    Or InvalidSelectorException*/


    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.findElement(By.xpath("//@@2"));


    }

}

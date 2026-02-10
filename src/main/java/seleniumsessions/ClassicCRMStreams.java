package seleniumsessions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassicCRMStreams {
static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
//		List<WebElement> headerList = driver.findElements(By.cssSelector("section#details h3"));
//		
//		headerList.stream().forEach(e -> System.out.println(e.getText()));
//		
		By headers = By.cssSelector("section#details h3");
		printHeadersList(headers);
		
		if(getHeadersList(headers).contains("Reports")) {
			System.out.println("PASS");
		}
		
	}
	
	
	public static List<String> getHeadersList(By locator) {
		//return List<String>
		List<WebElement> headerList = driver.findElements(locator);
		return headerList.stream().map(e -> e.getText()).collect(Collectors.toList());

	}
	
	public static void printHeadersList(By locator) {
		List<WebElement> headerList = driver.findElements(locator);
		headerList.stream().forEach(e -> System.out.println(e.getText()));
	}
	
	
	

}

package seleniumsessions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartStreams {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		//linksList.stream().forEach(e -> System.out.println(e.getText()));
		
		List<String> flipkartList = new ArrayList<String>();
//		
//		linksList
//			.stream()
//				.filter(e -> !e.getText().isEmpty())
//					.filter(e -> e.getText().startsWith("Flipkart"))
//						.forEach(e -> flipkartList.add(e.getText()));
//		
//		System.out.println(flipkartList);
		
		//
		List<WebElement> flipkartElementList = linksList
		.stream()
			.filter(e -> !e.getText().isEmpty())
				.filter(e -> e.getText().startsWith("Flipkart"))
					.collect(Collectors.toList());
		
		flipkartElementList.forEach(e -> flipkartList.add(e.getText()));
		System.out.println(flipkartList);
		
		//use with limited data
		//debugging is hard
		
		
	}

}

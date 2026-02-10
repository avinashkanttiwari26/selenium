package seleniumsessions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLabsStreams {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> prices = driver.findElements(By.cssSelector("div.inventory_item_price"));
		
		prices.stream().forEach(e -> System.out.println(e.getText()));
		
		System.out.println("-----");
		
//		List<Double> prices_desc_sorted = prices.
//											stream().
//													map(e -> Double.parseDouble(e.getText().substring(1)))
//															.sorted(Comparator.reverseOrder())
//																	.collect(Collectors.toList());
//		
//		System.out.println(prices_desc_sorted);
//		
//		System.out.println("max price: " + prices_desc_sorted.get(0));
//		System.out.println("min price: " + prices_desc_sorted.get(prices_desc_sorted.size()-1));
		
		System.out.println("-----");

		double firstPrice = prices.stream().map(e -> Double.parseDouble(e.getText().substring(1)))
							.findFirst().get();
		
		System.out.println(firstPrice);
		
		System.out.println("-----");
		double lastPrice = prices.stream().map(e -> Double.parseDouble(e.getText().substring(1)))
										.reduce((first,  second) -> second).get();
		System.out.println(lastPrice);
		
		System.out.println("-----");

		double maxPrice = 
				prices.stream().map(e -> Double.parseDouble(e.getText().substring(1))).max(Double :: compareTo).get();
		System.out.println(maxPrice);

		double minPrice = 
				prices.stream().map(e -> Double.parseDouble(e.getText().substring(1))).min(Double :: compareTo).get();
		System.out.println(minPrice);
		
		
		//
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		double maxStockPrice = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"))
										.stream()
												.map(e -> Double.parseDouble(e.getText()))
														.max(Double :: compareTo)
																.get();
		System.out.println(maxStockPrice);					
		
		
	}

}

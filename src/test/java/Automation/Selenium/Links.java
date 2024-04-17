package Automation.Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Links {

	public static void main(String[] args) 
	{
		//Headless running browse
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//Get all the links
		int allLinks = driver.findElements(By.tagName("a")).size();
		System.out.println(allLinks);
		
		//Get the footer links
		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
		int footerLnks = footer.findElements(By.tagName("a")).size();
		System.out.println(footerLnks);
		
		//Get the first column links
		WebElement colHeader = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int colLinks = colHeader.findElements(By.tagName("a")).size();
		System.out.println(colLinks);
		
		//Click the first column links
		for(int i=1;i<colLinks;i++)
		{
			String click = Keys.chord(Keys.CONTROL,Keys.ENTER);
			colHeader.findElements(By.tagName("a")).get(i).sendKeys(click);
		}
		
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String wtitle = it.next();
			driver.switchTo().window(wtitle);
			System.out.println(driver.getTitle());
		}
		
		driver.quit();
	}
}

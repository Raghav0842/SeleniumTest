package Automation.Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li"));
		System.out.println(ele.size());
		for (int i = 0; i < ele.size(); i++) 
		{
			String url = (ele.get(i).findElement(By.tagName("a")).getAttribute("href"));
			URL finalurl = new URL(url);
			HttpURLConnection http = (HttpURLConnection)finalurl.openConnection();
			int statusCode = http.getResponseCode();
			if(statusCode>400)
			{
				System.out.printf("Broken link is %s,%d\n",url,statusCode);
			}
			
		}
		
	}

}

package Automation.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingWindow {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3);
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,200)");
		
		//Sum the number form the dropdown
		List<WebElement> listAll = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr"));
		int row = listAll.size();
		int totalAmount = 0;
		for (int i = 0; i < row; i++) 
		{
			String amount = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]")).get(i).getText();
			totalAmount = totalAmount + Integer.parseInt(amount);
		}
		
		Assert.assertEquals(totalAmount, 296, "Wrong sum");

	}

}

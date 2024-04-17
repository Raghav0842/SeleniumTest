package Automation.Selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Sorting_table {

	public static void main(String[] args) throws InterruptedException 
	{
		//Top Deals
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Thread.sleep(5);
		Set<String> wind = driver.getWindowHandles();
		Iterator<String> it = wind.iterator();
		String p1 = it.next();
		String p2 = it.next();
		
		driver.switchTo().window(p2);
		
		/*List<WebElement> lst = driver.findElements(By.xpath("//table[@class ='table table-bordered']/tbody/tr"));
		int row = lst.size();
		ArrayList<String> default_vegies = null;
		ArrayList<String> sorted_vegies = null;
		for (int i = 1; i <= row; i++) 
		{
			String veg = driver.findElement(By.xpath("//table[@class ='table table-bordered']/tbody/tr["+ i +"]/td[1]")).getText();	
			default_vegies.add(veg);
			
		}*/
		
		driver.findElement(By.xpath("//table[@class ='table table-bordered']/thead/tr/th[1]")).click();
		
		 List<WebElement> lst = driver.findElements(By.xpath("//table[@class ='table table-bordered']/tbody/tr/td[1]"));
		 
		 List<String> original = lst.stream().map(s->s.getText()).collect(Collectors.toList());
		 List<String> sortedlist =  lst.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		 
		 Assert.assertEquals(original, sortedlist);
		 
		 //==============================================Print the price for the selected vegies===============================
		 
		 List<WebElement> listOfVegies = driver.findElements(By.xpath("//table[@class ='table table-bordered']/tbody/tr/td[1]"));
		 String vegname="Rice";
		 int price=0;
		 
		//List<String> expectedVeg = listOfVegies.stream().map(s->s.getText()).filter(s-> s.contains("Rice")).collect(Collectors.toList());
		 
		 for (int i = 1; i < listOfVegies.size(); i++) 
		{
			 String vegName = driver.findElement(By.xpath("//table[@class ='table table-bordered']/tbody/tr[" + i + "]/td[1]")).getText();
			 if(vegName.equalsIgnoreCase(vegname))
			 {
				 price = Integer.parseInt(driver.findElement(By.xpath("//table[@class ='table table-bordered']/tbody/tr[" + i + "]/td[2]")).getText());
				 break;
			 }
			 else
			 {
				 System.out.println(vegname + " not found in the table list");
			 }
			
		}
		 
		 System.out.printf("%s %d",vegname,price );
		 
		  
		 
		
	}

}

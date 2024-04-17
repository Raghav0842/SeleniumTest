package Automation.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsActivity {

	public static void main(String[] args) 
	{
		//driver.get -> it will wait until page get loaded automatically (Preferred one)
		//driver.navigate().to() -> Selenium will not wait until page loaded completely 
		                //          and move to next page.
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		//driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
		System.out.printf("Chrome %s\n",driver.getTitle());
		driver.close();
	}

}

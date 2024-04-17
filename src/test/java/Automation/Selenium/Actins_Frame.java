package Automation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actins_Frame {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Login']")))
		.build()
		.perform();
		
		act.moveToElement(driver.findElement(By.xpath("//input[@name='q']"))).click()
		    .keyDown(Keys.SHIFT).sendKeys("motorola").build().perform();
	}

}

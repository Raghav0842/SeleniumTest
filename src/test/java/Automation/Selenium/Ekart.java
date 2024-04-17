package Automation.Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Ekart {

	//public static void main(String[] args) throws InterruptedException 
	@Test
	public void eKart_E2E()
	{
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String[] expectedVeg = { "Brocolli", "Apple", "Corn", "Potato" };
		List<String> neededVeg = Arrays.asList(expectedVeg);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> produts = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < produts.size(); i++)
		{
			String str = produts.get(i).getText().split(" ")[0];
			if (neededVeg.contains(str)) 
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}
		
		//Click on Cart button.
		driver.findElement(By.cssSelector("img[alt=Cart]")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		//Enter promo code.
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		Assert.assertEquals("Code applied ..!", driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		
	}

}

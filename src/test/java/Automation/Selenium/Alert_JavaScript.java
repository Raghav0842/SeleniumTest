package Automation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_JavaScript {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input[value='Alert']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); // Click ok button

		driver.findElement(By.cssSelector("input[value='Confirm']")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.cssSelector("input[value='Confirm']")).click();
		driver.switchTo().alert().accept();

		driver.close();

	}

}

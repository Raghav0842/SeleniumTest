package Automation.Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// https://rahulshettyacademy.com/loginpagePractise/#/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		String mail = driver.findElement(By.cssSelector("p.im-para.red")).getText();
		String fMail = mail.split("at")[1].split(" ")[1];
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(fMail);
		
		//Frames
		//driver.switchTo().frame("id or locator");
		//driver.switchTo().defaultContent();
	}

}

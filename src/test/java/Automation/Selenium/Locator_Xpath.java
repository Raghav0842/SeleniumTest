package Automation.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locator_Xpath {

	public static void main(String[] args) throws InterruptedException {
		// XPath=//tagname[@attribute='value']

		WebDriver driver = new ChromeDriver();
		String userName = "Raghav";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Assert.assertEquals(driver.getTitle(), "Rahul Shetty Academy - Login page");
		System.out.printf("Landed on %s page \n", driver.getTitle());
		// Forgot Password Scenario
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(userName);
		driver.findElement(By.xpath("//form/input[2]")).sendKeys("Raghav@gmail.com");
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Phone Number' ]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[(@class='reset-pwd-btn')]")).click();
		String fPassword = driver.findElement(By.xpath("//*[@class='infoMsg']")).getText();
		Assert.assertEquals(fPassword, "Please use temporary password 'rahulshettyacademy' to Login.");

		// Get the reset password
		String rstPwd = fPassword.split("'")[1].split("'")[0];
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();

		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(rstPwd);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		// Verify login
		String header = driver.findElement(By.xpath("//div/h2")).getText();
		Assert.assertEquals(header, "Hello " + userName + ",");

		driver.close();

	}

}

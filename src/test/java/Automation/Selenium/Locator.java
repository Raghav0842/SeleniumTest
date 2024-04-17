package Automation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Locator {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		System.out.printf("Landed on %s page \n", driver.getTitle());

		// Home page
		driver.findElement(By.id("menu-toggle")).click();
		driver.findElement(By.linkText("Login")).click();

		// Login page
		driver.findElement(By.xpath("//input[@id ='txt-username']")).sendKeys("John Doe");
		driver.findElement(By.xpath("//input[@id ='txt-password']")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();

		// Appointment page
		Select sel = new Select(driver.findElement(By.id("combo_facility")));
		sel.selectByValue("Hongkong CURA Healthcare Center");
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		driver.findElement(By.id("radio_program_medicaid")).click();
		driver.findElement(By.id("txt_visit_date")).sendKeys("10/03/2024");
		driver.findElement(By.id("txt_comment")).sendKeys("My First Comments");
		driver.findElement(By.id("btn-book-appointment")).click();

		// Confirmation Page
		String confirm = driver.findElement(By.xpath("//div/h2")).getText();
		System.out.println(confirm);

	}

}

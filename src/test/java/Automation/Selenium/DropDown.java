package Automation.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// https://rahulshettyacademy.com/dropdownsPractise/
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Static dropDown
		// =============================================================================
		WebElement statdrop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sel = new Select(statdrop);
		sel.selectByIndex(3);
		System.out.println(sel.getFirstSelectedOption().getText());
		sel.selectByValue("AED");
		System.out.println(sel.getFirstSelectedOption().getText());
		sel.selectByVisibleText("INR");
		System.out.println(sel.getFirstSelectedOption().getText());

		// Adding drop down
		// ===================================================
		driver.findElement(By.id("divpaxinfo")).click();

		// Add two adults,two kids,1 infant
		WebElement parent_div = driver.findElement(By.id("divpaxOptions"));
		WebElement adult_sel = parent_div.findElement(By.id("divAdult"));
		WebElement child_sel = parent_div.findElement(By.id("divChild"));
		WebElement infant_sel = parent_div.findElement(By.id("divInfant"));

		for (int i = 1; i < 2; i++) {
			adult_sel.findElement(By.cssSelector("div.ad-row-right span#hrefIncAdt")).click();
		}

		for (int i = 1; i < 3; i++) {
			child_sel.findElement(By.cssSelector("div.ad-row-right span#hrefIncChd")).click();
		}

		for (int i = 1; i <= 1; i++) {
			infant_sel.findElement(By.cssSelector("div.ad-row-right span#hrefIncInf")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// Auto Suggestive drop down
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("Germany");
		List<WebElement> auto = driver.findElements(By.cssSelector("#ui-id-1 li.ui-menu-item"));
		for (WebElement x : auto) {
			if (x.getText().equalsIgnoreCase("Germany")) {
				x.submit();
				break;
			}
		}

		// From and To drop Down(Dynamic drop down)
		// ============================================================

		WebElement fromDdown = driver.findElement(By.cssSelector("input[id*='originStation1']"));
		WebElement toDDdown = driver.findElement(By.cssSelector("input[id*='destinationStation1']"));

		fromDdown.click();
		fromDdown.findElement(By.xpath("//a[@value='IXG']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement destElement = wait
				.until(ExpectedConditions.elementToBeClickable(toDDdown.findElement(By.xpath("//a[@value='BLR']"))));
		destElement.click();

		// Select the current date from calendar
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();

		// Click Search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}

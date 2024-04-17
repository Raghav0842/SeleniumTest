package Automation.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokigBrowser {

	public static void main(String[] args) {
		// Two Way to invoke brwser
		// 1. By setting system properties and download the .exe file
		// System.setProperty("webdriver.chrome.driver", "Path of the .exe file");

		// 2. Making use of Selenium manager.(by default it will invoke the compatible
		// browser)

		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://katalon-demo-cura.herokuapp.com/");
		System.out.printf("Chrome %s\n", chromeDriver.getTitle());
		chromeDriver.close();

		WebDriver fireFoxDriver = new FirefoxDriver();
		fireFoxDriver.get("https://www.orangehrm.com/");
		System.out.printf("FireFox %s\n", fireFoxDriver.getTitle());
		fireFoxDriver.close();

		WebDriver IEDriver = new EdgeDriver();
		IEDriver.get("https://sdet.live/L6Ke");
		System.out.printf("IE %s\n", IEDriver.getTitle());
		IEDriver.quit();

	}

}

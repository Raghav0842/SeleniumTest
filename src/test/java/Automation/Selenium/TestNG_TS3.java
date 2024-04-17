package Automation.Selenium;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNG_TS3 
{
 
	@Test
	public void Test1()
	{
		System.out.println("My Nine method");
	}
	
	@Test
	public void Test2()
	{
		System.out.println("My ten method");
	}
	
	@Test
	public void Test3()
	{
		System.out.println("My  method");
	}
	
	@Test
	public void Test4()
	{
		System.out.println("My fourth method");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeMethod()
	{
		System.out.println("I will run before every method");
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterMethod()
	{
		System.out.println("I will run after every method");
	}
	
}

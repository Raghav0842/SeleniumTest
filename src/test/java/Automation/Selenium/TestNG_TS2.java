package Automation.Selenium;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_TS2 
{
 
	@Test
	public void Test1()
	{
		System.out.println("My fifth method");
	}
	
	@Test(groups = "Regression")
	public void Test2()
	{
		System.out.println("My Sixth method");
	}
	
	@Test(groups = "Smoke")
	public void Test3()
	{
		System.out.println("My Seventh method");
	}
	
	@Test(groups = "Regression")
	public void Test4()
	{
		System.out.println("My Eighth method");
	}
	
	@BeforeTest(alwaysRun = true)
	public void BTest()
	{
		System.out.println("I am Before test Menthod");
	}
		
}

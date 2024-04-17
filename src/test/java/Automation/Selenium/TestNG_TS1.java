package Automation.Selenium;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNG_TS1 
{
 
	@Test(groups = "Smoke")
	public void Test1()
	{
		System.out.println("My first method");
	}
	
	@Test
	public void Test2()
	{
		System.out.println("My Second method");
	}
	
	@Test(groups = "Smoke")
	public void Test3()
	{
		System.out.println("My third method");
	}
	
	@Test(groups = "Smoke")
	public void Test4()
	{
		System.out.println("My fourth method");
		Assert.assertTrue(false);
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest()
	{
		System.out.println("I will run after all test");
	}
	
	
}

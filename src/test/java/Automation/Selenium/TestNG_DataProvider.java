package Automation.Selenium;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider 
{
	
	@Test(dataProvider = "data")
	public void TestMethod1(HashMap<String,String> maps)
	{
		System.out.println("Hi my name is : " + maps.get("name"));
		System.out.println("Hi last my name is : "+ maps.get("lName"));
		System.out.println(System.getProperty("user.dir"));
	}
	
	// Normal data provider
/*	@DataProvider
	public Object[][] data()
	{
       Object[][] a = new Object[2][2];
       a[0][0] = "Raghav";
       a[0][1] = "Metri";
       a[1][0] = "Ashwnini";
       a[1][1] = "Metri";
       return a;
	} */
	
	// data provider using HashMaps
	@DataProvider
	public Object[][] data()
	{
		HashMap<Object, Object> maps = new HashMap<Object, Object>();
		maps.put("name", "Raghav");
		maps.put("lName", "Metri");
		
		HashMap<Object, Object> maps1 = new HashMap<Object, Object>();
		maps1.put("name", "Ved");
		maps1.put("lName", "Metri");
				
		return new Object[][] {{maps},{maps1}};
	}

}
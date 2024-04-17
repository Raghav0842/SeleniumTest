package Automation.Selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG
{

	public static ExtentReports getReporter()
	{
		String path = System.getProperty("user.dir")+"//Reporter//TestReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Run Results");
		reporter.config().setReportName("Web Automation");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
		
	}
}

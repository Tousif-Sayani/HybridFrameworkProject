package com.qatools.qa.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	
	public static ExtentReports generateExtentReports() {
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".\\ExtentReports\\ExtentReports.html");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		
		sparkReporter.config().setDocumentTitle("Extent Reports");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TOOLS QA Extent Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReports.setSystemInfo("User Name", "Tousif Sayani");
		extentReports.setSystemInfo("OS", "Windows 11");
		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("Java Version", "22.0.2");
		extentReports.setSystemInfo("Selenium Version", "4.22.0");
		extentReports.setSystemInfo("Extent Report Version", "5.1.2");
		
		return extentReports;
	}
	
}

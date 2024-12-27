package com.qatools.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qatools.qa.utility.ExtentReporter;
import com.qatools.qa.utility.Utilities;

public class MyListeners implements ITestListener {

	ExtentReports extentReports;
	ExtentTest extentTest;
		
	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReporter.generateExtentReports();		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("This TestCase" + result.getName() + "is Success");
		Utilities.captureScreenShot(result.getName());
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.PASS, MarkupHelper.createLabel("Test case "+result.getName(), ExtentColor.GREEN));
		extentTest.pass(result.getName());
		extentTest.addScreenCaptureFromPath(Utilities.screenShotPath);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("This TestCase" + result.getName() + "is Failed");
		Utilities.captureScreenShot(result.getName());
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test case "+result.getName(), ExtentColor.RED));
		extentTest.fail(result.getName());
		extentTest.addScreenCaptureFromPath(Utilities.screenShotPath);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("This TestCase" + result.getName() + "is Skipped");
		Utilities.captureScreenShot(result.getName());
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test case "+result.getName(), ExtentColor.YELLOW));
		extentTest.skip(result.getName());
		extentTest.addScreenCaptureFromPath(Utilities.screenShotPath);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finish executing project test");
		extentReports.flush();
	}

}

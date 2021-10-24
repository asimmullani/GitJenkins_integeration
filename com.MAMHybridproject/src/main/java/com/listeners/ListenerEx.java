package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.testBase.TestBase;

public class ListenerEx extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		log.info("Test case is redy to start with name: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test case passed sucessfully with name :" + result.getName());
		test.log(Status.PASS, "Test case Passed Sucessfully");
	}

	public void onTestFailure(ITestResult result) {
		log.info("TestCase Failed With name:" + result.getName());
		log.info(result.getThrowable());
		test.log(Status.FAIL, "TestCase failed");
		test.log(Status.FAIL, result.getThrowable());
		String path = takeScreenShot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test Case Skipped with Name:" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		log.info("Test suit is started");

	}

	public void onFinish(ITestContext context) {
		log.info("Test Suit is Finished");
		report.flush(); // all test case results get Stored in to report.
	}

}

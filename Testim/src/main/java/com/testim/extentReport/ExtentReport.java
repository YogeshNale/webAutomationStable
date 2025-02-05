package com.testim.extentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testim.TestBase.TestBase;
import com.testim.utility.CapturedScreenShot;

public class ExtentReport extends TestBase implements ITestListener {
	private ExtentReports extent;
	private ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.startTest(result.getName());
		log.info(result.getName() + " scenario execution start");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName());
		log.info(result.getName() + " scenario execute successfully.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String captureScreenShotOnTestFail = CapturedScreenShot.captureScreenShot(result.getName());

		String attchedToExtentReport = test.addScreenCapture(captureScreenShotOnTestFail);

		test.log(LogStatus.FAIL, attchedToExtentReport);
		log.info(result.getName() + " scenario execution fail.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName());
		log.info(result.getName() + " scenario get Skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		extent = new ExtentReports("./Reports/ExtentReport.html", true);
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.endTest(test);
		extent.flush();
		extent.close();
	}

}

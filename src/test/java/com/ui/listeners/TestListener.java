package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.ui.utilities.BrowserUtility;
import com.ui.utilities.ExtentReporterUtility;
import com.ui.utilities.LoggerUtililty;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtililty.getLoger(getClass());

	ExtentSparkReporter extentSparkreporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onStart(ITestContext context) {
		logger.info("============Staring the Test Suite============");
		ExtentReporterUtility.setupSparkreporter("report.html");

	}

	public void onTestStart(ITestResult result) {
		logger.info("============Staring the Test Start============");
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));

		ExtentReporterUtility.creatTestentryinReport(result.getMethod().getMethodName());


	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");
		ExtentReporterUtility.getTestentryinReport().log(Status.PASS, result.getMethod().getMethodName()+"PASSED");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName()+ " FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTestentryinReport().log(Status.FAIL, result.getMethod().getMethodName()+"FAILED");
		ExtentReporterUtility.getTestentryinReport().log(Status.FAIL, result.getThrowable().getMessage());
		
		Object testclass = result.getInstance();
		BrowserUtility browserUtility =((TestBase)testclass).getInstance();
		String screenshotpath =browserUtility.takeScreenshot(result.getMethod().getMethodName());
		ExtentReporterUtility.getTestentryinReport().addScreenCaptureFromPath(screenshotpath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " SKIPPED");
		ExtentReporterUtility.getTestentryinReport().log(Status.SKIP,result.getMethod().getMethodName()+"SKIPPED");

	}

	public void onFinish(ITestContext context) {
		logger.info("============End the Test Suite============");
		ExtentReporterUtility.flushReport();
	}

}
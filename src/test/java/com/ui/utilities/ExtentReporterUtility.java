package com.ui.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

	private static ExtentReports extentreports;
	private static ThreadLocal<ExtentTest> extentTests = new ThreadLocal<ExtentTest>();

	public static void setupSparkreporter(String fileName) {
		if (extentreports == null) {
			ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "/" + fileName);
			extentreports = new ExtentReports();
			extentreports.attachReporter(extentsparkreporter);
		}
	}

	public static void creatTestentryinReport(String testName) {
		ExtentTest test = extentreports.createTest(testName);
		extentTests.set(test);
	}

	public static ExtentTest getTestentryinReport() {
		return extentTests.get();
	}

	public static void flushReport() {
		extentreports.flush();
	}
}

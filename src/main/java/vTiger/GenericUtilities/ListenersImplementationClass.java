package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * @author Chaitra M
 *
 */
public class ListenersImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, "-> "+methodName+" - Test Execution started <-");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "-> "+methodName+" - Test is Passed <-");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "-> "+methodName+" - Test is Failed <-");
		test.log(Status.WARNING, result.getThrowable());
		
		/*Take Screen shot for the failed test scripts*/
		
		String screenShotName = methodName+"-"+new JavaUtility().getSystemDateinFormat();
		
		WebDriverUtility wUtil = new WebDriverUtility();
		try {
			String path = wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path); //attach screen shot to report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "-> "+methodName+" - Test is Skipped <-");
		test.log(Status.WARNING, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-> Suite execution Started <-");
		
		/*Configure the extent reports here*/
		                                                                          //Report-20 Aprl 2023 - 08-23-56.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateinFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("QCO-SJEADD-M1-Automation Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Platform", "Windows 10");
		report.setSystemInfo("Reporter Name", "Chaitra");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-> Suite execution finished <-");
		
		/*Extent report should get generated*/
		report.flush();
		
	}
   
}

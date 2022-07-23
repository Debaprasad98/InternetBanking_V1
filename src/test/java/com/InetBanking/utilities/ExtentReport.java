package com.InetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;//By help of this object we can add extra information
	public ExtentTest test;
	
	

	public void onStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config5.xml");
		

		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("TesterName", "Deba");
		extent.setSystemInfo("Browser", "Chrome");
	
	}
	public void onTestSuccess(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in the report
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in the report
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in the report
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish() {
		extent.flush();
	}
}
		

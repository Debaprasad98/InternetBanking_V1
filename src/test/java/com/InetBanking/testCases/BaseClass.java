package com.InetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.InetBanking.utilities.ReadConfig;
import com.google.common.io.Files;

public class BaseClass {
	  ReadConfig readconfig=new ReadConfig();
		
		public String baseURL=readconfig.getappurl();
		public String UN=readconfig.getusername();
		public String PD=readconfig.getpassword();
		public String br=readconfig.browser();
		public static WebDriver driver;
		public static Logger logger;
		
	//Lunch the browser	
		@BeforeMethod
		
		
		public void setup() {
			if(br.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getchropath());
			 driver=new ChromeDriver();	
			}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			 driver=new FirefoxDriver();		
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseURL);
		logger=Logger.getLogger("InternetBanking");
		PropertyConfigurator.configure("log4j.properties");
			
		}
	//Close the browser
		@AfterMethod
		public void exist() {
//			driver.quit();
		}	
		public void CaptureScreenshot(WebDriver driver,String tname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File(System.getProperty("user.dir")+"/Screenshot"+tname+".png");
			Files.copy(src, dst);
		}
}

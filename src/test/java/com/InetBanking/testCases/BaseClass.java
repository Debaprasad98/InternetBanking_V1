package com.InetBanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.InetBanking.utilities.ReadConfig;

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

		logger=Logger.getLogger("InternetBanking");
		PropertyConfigurator.configure("log4j.properties");
			
		}
	//Close the browser
		@AfterMethod
		public void exist() {
//			driver.quit();
		}	
}

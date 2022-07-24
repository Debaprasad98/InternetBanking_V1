package com.InetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;



public class TC_LoginTest_1 extends BaseClass {
	@Test
	public void Logintest() throws Throwable {
		LoginPage lp=new LoginPage(driver);
		driver.get(baseURL);

		logger.info("URL Opened");
		
		lp.setUsername(UN);
		logger.info("Username entered");

		lp.setPassword(PD);
		logger.info("Password entered");
		
		lp.clicklgn();
		logger.info("Clicked on login button");

		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
		logger.info("Title verified-->Log in Test Passed");

		}else {
			CaptureScreenshot(driver,"Logintest");
			Assert.assertTrue(false);
			logger.info("Title not verified-->Log in Test Failed");

		}
	}
	@Test
	public void Demo() {
		System.out.println("Demo Test");
	}
}


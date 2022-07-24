package com.InetBanking.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;
import com.InetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String un,String pwd) {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(un);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clicklgn();
		
		if (isAlertpresent()==true) {
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();//Focus on login-page
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clicklogout();
			driver.switchTo().alert().accept();//close alert logout 
			driver.switchTo().defaultContent();//Focus on login-page
		}
	}
	
	//This method will check Alert window is present or not 
	public boolean isAlertpresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	//Data-provider method will read the data from excel file and store those data in two dimension array
	@DataProvider(name="LoginData")
	String [][] getData() throws Throwable{
		String path=System.getProperty("user.dir")+"/src/test/java/com/InetBanking/testData/Book1.xlsx";
		int rowcount=XLUtils.getrowcount(path,"Sheet1");
		int cellcount=XLUtils.getcellcount(path, "Sheet", 1);
		String logindata[][]=new String[rowcount][cellcount];
		for (int i = 1; i <=rowcount; i++) {
			for (int j = 0; j <cellcount; j++) {
			logindata[i-1][j]=XLUtils.getcelldata(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}


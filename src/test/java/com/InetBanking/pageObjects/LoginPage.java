package com.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver ldriver){
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pawd;
	
	@FindBy(name="btnLogin")
	WebElement lgnbttn;
	
	
	public void setUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		pawd.sendKeys(pwd);
	}
	public void clicklgn() {
		lgnbttn.click();
	}
}

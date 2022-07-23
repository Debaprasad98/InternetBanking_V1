package com.InetBanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties prop;
	
	public ReadConfig() {
		
		try {
		FileInputStream fis=new FileInputStream("./Configurations/config.properties");
		prop=new Properties();
		prop.load(fis);
		
		}catch (Exception e) {
			System.out.println("exception is"+e.getMessage());
		}
	}
	
	public  String getappurl() {
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getusername() {
		String username=prop.getProperty("username");
		return username;
	}
	public String getpassword() {
		String password=prop.getProperty("password");
		return password;
	}
	public String getchropath() {
		String chropath=prop.getProperty("chromepath");
		return chropath;
	}
	public String getfirefoxpath() {
		String firefoxpath=prop.getProperty(getfirefoxpath());
		return firefoxpath;
	}
	public String browser() {
		String browser=prop.getProperty("browser");
		return browser;
	}
}

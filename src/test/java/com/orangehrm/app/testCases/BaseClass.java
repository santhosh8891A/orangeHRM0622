package com.orangehrm.app.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.app.utitlities.ReadConfig;

public class BaseClass {

	public ReadConfig readconfig;
	public static WebDriver driver=null;
	public String applicationURL;
	public String userName;
	public String password;
	public String title;

	@BeforeSuite
	public void setUp() {
		//Reading data from properties file
		//Add a new code
		readconfig=new ReadConfig();
		applicationURL=readconfig.getFromConfingFile("ApplicationURL");
		userName=readconfig.getFromConfingFile("username");
		password=readconfig.getFromConfingFile("password");
		title=readconfig.getFromConfingFile("Title");
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get(applicationURL);

	}

	@AfterSuite
	public void tearDown() {

	}

}

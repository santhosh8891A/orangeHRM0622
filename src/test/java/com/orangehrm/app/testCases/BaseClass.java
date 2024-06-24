package com.orangehrm.app.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.orangehrm.app.utitlities.ReadConfig;
import com.orangehrm.app.utitlities.Webdriverutils;

public class BaseClass {

	public ReadConfig readconfig;
	public static WebDriver driver = null;
	public String applicationURL;
	public String userName;
	public String password;
	public String title;
	public Webdriverutils webdrutils;
    public static Logger logger;
	@Parameters("browser")
	@BeforeSuite
	public void setUp(String browser) {
		// Reading data from properties file
		// Add a new code
		readconfig = new ReadConfig();
		applicationURL = readconfig.getFromConfingFile("ApplicationURL");
		userName = readconfig.getFromConfingFile("username");
		password = readconfig.getFromConfingFile("password");
		title = readconfig.getFromConfingFile("Title");
		webdrutils=new Webdriverutils();
		if (browser.contentEquals("Chrome"))

		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else {
			driver = new EdgeDriver();
		}
		logger = Logger.getLogger("orangeHRM");
		PropertyConfigurator.configure("Log4j.properties");

		driver.get(applicationURL);

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		System.out.println("Test Execution Completed");

	}

}

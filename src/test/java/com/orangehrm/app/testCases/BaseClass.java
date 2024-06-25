package com.orangehrm.app.testCases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.app.pageobjects.LoginPage;
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
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;
    public static SimpleDateFormat simpleDate;

	@Parameters("browser")
	@BeforeSuite
	public void setUp(String browser) {
		//Reading data from properties file
		//Add a new code
		readconfig = new ReadConfig();
		applicationURL = readconfig.getFromConfingFile("ApplicationURL");
		userName = readconfig.getFromConfingFile("username");
		password = readconfig.getFromConfingFile("password");
		title = readconfig.getFromConfingFile("Title");
		webdrutils=new Webdriverutils();
		
		//Extent Report Basic Configurations
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");
		String strDate = formatter.format(date);
		htmlReporter = new ExtentHtmlReporter("test-output\\ExtentReportResults" + strDate + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		
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
		LoginPage lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.login(userName,password);

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		System.out.println("Test Execution Completed");

	}
	
	@AfterMethod
	public void extenrWriting() {
		 extent.flush();

	}

}

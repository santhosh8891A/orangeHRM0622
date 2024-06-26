package com.orangehrm.app.testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.app.pageobjects.LoginPage;
import com.orangehrm.app.utitlities.Webdriverutils;

import junit.framework.Assert;

public class LoginPageTC_001 extends BaseClass {
	
	@Test
	public void loginValidation() throws IOException, InterruptedException
	{
		//Created the login page object
	{
		 LoginPage lp=new LoginPage(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 lp.login(userName,password);
		 String expectedTitle=driver.getTitle();
		 Assert.assertEquals(title, expectedTitle);
		 test= extent.createTest("Login Test Case");
		 logger.info("Entered User name");
		 test.log(Status.PASS, "Entered User name Sucessfully");
		 logger.info("Entered Password");
		 test.log(Status.PASS, "Entered Password Sucessfully");
		 String expectedTitle1=driver.getTitle();
		 
		 if(title.contentEquals(expectedTitle1))
		 {
		 test.log(Status.PASS, "Validated Title Sucessfully");
		 logger.info("Validated Title");
		 Thread.sleep(5000);		 
		 webdrutils.captureScreen(driver, "Login Funcationality");
		 }
		 else
		 {
			 test.log(Status.FAIL, "Title did not match");
			 logger.info("Title did not match");
			 Thread.sleep(5000);		 
			 String path=webdrutils.captureScreen(driver, "Login Funcationality");
			 test.fail ("Test Failed"+test.addScreenCaptureFromPath(path));

		 }
		 
		
	}
	
	}
}
package com.orangehrm.app.testCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.orangehrm.app.pageobjects.LoginPage;
import com.orangehrm.app.utitlities.Webdriverutils;

import junit.framework.Assert;

public class LoginPageTC_001 extends BaseClass {
	
	@Test
	public void loginValidation() throws IOException, InterruptedException
	{
		//Created the login page object
		 LoginPage lp=new LoginPage(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 lp.login(userName,password);
		 logger.info("Entered User name");
		 logger.info("Entered Password");
		 String expectedTitle=driver.getTitle();
		 logger.info("Validated Title");
		 Thread.sleep(5000);		 
		 webdrutils.captureScreen(driver, "Login Funcationality");
		 Assert.assertEquals(title, expectedTitle);
		 
		 
	}
	

}

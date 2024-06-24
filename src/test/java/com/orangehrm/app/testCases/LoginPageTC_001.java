package com.orangehrm.app.testCases;

import java.time.Duration;

import org.testng.annotations.Test;

import com.orangehrm.app.pageobjects.LoginPage;

import junit.framework.Assert;

public class LoginPageTC_001 extends BaseClass {
	
	@Test
	
	public void loginValidation()
	{
		//Updated Code
		 LoginPage lp=new LoginPage(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 lp.login(userName,password);
		 String expectedTitle=driver.getTitle();
		 Assert.assertEquals(title, expectedTitle);
		 
	}
	

}

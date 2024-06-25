package com.orangehrm.app.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.app.pageobjects.MyinfoPage;

public class Myinfo extends BaseClass {
	
	@Test(priority=0)
	public void validatePersonalDetailsScreen() throws IOException, InterruptedException
	{
		MyinfoPage myinfo=new MyinfoPage(driver);
		test= extent.createTest("Validate Personal Details Screen display");
		if(myinfo.validatedpersonalDetailsdisplay())
		{
			 logger.info("Navigated to Personal Details Screen");
			 test.log(Status.PASS, "Navigated to Personal Details Screen");
		}
		else
		{
			 test.log(Status.FAIL, "Navigation is not successful to Personal Details Screen");
			 logger.info("Navigation is not successful to Personal Details Screen");
			 Thread.sleep(5000);
			 String path=webdrutils.captureScreen(driver, "PersonalDetailsScreen");
			 test.fail ("Test Failed"+test.addScreenCaptureFromPath(path));
		}
		
	}
	
	@Test(priority=1)
	public void validateEditPersonalDetails() throws IOException, InterruptedException
	{
		MyinfoPage myinfo=new MyinfoPage(driver);
		test= extent.createTest("Validate Edit Personal Details");
		myinfo.editPersonalDetails("123456");
		 logger.info("Navigated to Personal Details Screen");
		 test.log(Status.PASS, "Navigated to Personal Details Screen");
		 logger.info("Edited  Personal Details");
		 test.log(Status.PASS, "Edited Personal Details");
		 String path=webdrutils.captureScreen(driver, "EditPersonalDetailsScreen");
		 test.pass ("Test Passed "+test.addScreenCaptureFromPath(path));
		 Thread.sleep(5000);
		
	}
	

}

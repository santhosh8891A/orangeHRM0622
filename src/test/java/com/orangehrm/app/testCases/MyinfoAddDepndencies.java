package com.orangehrm.app.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.app.pageobjects.MyinfoPage;
import com.orangehrm.app.utitlities.DataProviderClass;

public class MyinfoAddDepndencies extends BaseClass {
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviderClass.class)
	public void validateAddDependencies(String name,String relation,String dob) throws IOException, InterruptedException
	{
		test= extent.createTest("Add Dependency");
		MyinfoPage myinfo=new MyinfoPage(driver);
		System.out.println(name);
		System.out.println(relation);
		System.out.println(dob);
		myinfo.addDepndendents(name, relation, dob);
		
		Thread.sleep(5000);
		 String path=webdrutils.captureScreen(driver, "Add Dependency");
		 test.pass ("Test passed"+test.addScreenCaptureFromPath(path));
	}

}

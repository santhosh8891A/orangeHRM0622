package com.orangehrm.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyinfoPage {
	
	WebDriver ldriver;

	//Parameterized constructor
	public MyinfoPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Personal Details']") WebElement personalDetailsLink;
	
	//This method will return true if the Personal details page is displayed.
	public boolean validatedpersonalDetailsdisplay()
	{
		boolean displayValue=false;
		try {
		if(personalDetailsLink.isDisplayed())
		{
			displayValue=true;
		}
		}
		catch(Exception e)
		{
			System.out.println("Personal Details Element Not Dipsplayed");
		}
		return displayValue;
	}
	
	@FindBy(xpath="//*[text()='My Info']") WebElement myInfoLink;	
	@FindBy(xpath="//*[text()='Employee Id']//parent::div//following-sibling::div/input") WebElement empIDInput;
	
	public void editPersonalDetails(String text) throws InterruptedException
	{
		myInfoLink.click();
		personalDetailsLink.click();
		Thread.sleep(5000);
		empIDInput.clear();
		empIDInput.sendKeys(text);
		
	}
	

}

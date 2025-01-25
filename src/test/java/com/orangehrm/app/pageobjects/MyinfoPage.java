package com.orangehrm.app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyinfoPage {
	
	//This the test commit 0125
	//This is the to test pull request
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
	
	@FindBy(xpath="//a[text()='Dependents']") WebElement dependentsLink;
	@FindBy(xpath="//*[text()='Assigned Dependents']/following::button[text()=' Add ']") WebElement addButton;
	@FindBy(xpath="//label[text()='Name']/parent::div/following-sibling::div/input") WebElement nameInput;
	@FindBy(xpath="//*[text()='-- Select --']") WebElement relationshipDrpDwn;	
	@FindBy(xpath="//*[@placeholder='yyyy-dd-mm']") WebElement dateInput;
	@FindBy(xpath="//*[text()=' Save ']") WebElement saveButton;
	
	//Reusable Method to add dependencies
	public void addDepndendents(String name,String relationship,String dob) throws InterruptedException

	{
		myInfoLink.click();		
		dependentsLink.click();
		addButton.click();
		nameInput.sendKeys(name);
		relationshipDrpDwn.click();
		WebElement option = null;
		Actions action= new Actions(ldriver);
		if(relationship.contentEquals("Child")) {
			 option=ldriver.findElement(By.xpath("//*[@role='option']/span[text()='Child']"));
		
		}
		else if(relationship.contentEquals("Other"))
		{
			 option=ldriver.findElement(By.xpath("//*[@role='option']/span[text()='Other']"));
		}
		
		action.moveToElement(option).click().build().perform();
		dateInput.sendKeys(dob);
		Thread.sleep(5000);
		saveButton.click();
	}
}

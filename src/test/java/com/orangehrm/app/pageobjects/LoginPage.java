package com.orangehrm.app.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jdk.jfr.internal.Logger;

public class LoginPage {
	WebDriver ldriver;

	//Parameterized constructor
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name="username") WebElement userNameInput;
	@FindBy(xpath="//input[@type='password']") WebElement passwordInput;
	@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
	
	//This Method is used to perfrom login and chages done on 0910
	public void login(String userName,String password)
	{
		
		userNameInput.sendKeys("Admin");
		passwordInput.sendKeys("admin123");
		loginButton.click();
	}

}

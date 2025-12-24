package com.orangehrm.app.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Jenkinstest {
	@Test
	public void testmethod()
	{
		WebDriver driver = new ChromeDriver();// This will help us to open chrome browser
		driver.navigate().to("https://demo.guru99.com/test/facebook.html");// This is a method to open application
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testemail.com");
		driver.findElement(By.xpath("//*[contains(@type,'password')]")).sendKeys("password");
		driver.findElement(By.xpath("//a[contains(text(),'Bank Project')]")).click();
		
	}

}

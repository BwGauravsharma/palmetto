package com.palmetto.testautomation.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalmettoLoginPageObject {
	
	WebDriver driver;
	static FileInputStream in;
	File file;
	Properties prop;
	
	public PalmettoLoginPageObject(WebDriver driver) throws IOException
	{
		this.driver = driver;
		PalmettoTestAutomationUtilities util = new PalmettoTestAutomationUtilities();
		prop = util.readFromPropertiesFile();
		
	}
	
	public void GoToLogInPage(){
		
		driver.findElement(By.linkText(prop.getProperty("PatientAndGuestHelpLink"))).click();
		driver.findElement(By.linkText(prop.getProperty("BillingLink"))).click();
		
	}
	
	public void LogIn(String username, String password)
	{
		driver.findElement(By.id(prop.getProperty("userNameFieldID"))).sendKeys(username);
		driver.findElement(By.id(prop.getProperty("passwordFieldID"))).sendKeys(password);
		driver.findElement(By.id(prop.getProperty("loginButtonID"))).click();
	}
			

}

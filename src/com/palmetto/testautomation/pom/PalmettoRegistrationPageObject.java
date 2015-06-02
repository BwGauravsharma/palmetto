package com.palmetto.testautomation.pom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalmettoRegistrationPageObject {
	
	WebDriver driver;
	Properties prop;
	
	
	public PalmettoRegistrationPageObject(WebDriver driver) throws FileNotFoundException, IOException{
		
		this.driver = driver;
		PalmettoTestAutomationUtilities util = new PalmettoTestAutomationUtilities();
		prop = util.readFromPropertiesFile();
	}

	public void GoToRegistrationPage(){
		
		driver.findElement(By.linkText(prop.getProperty("PatientAndGuestHelpLink"))).click();
		driver.findElement(By.linkText(prop.getProperty("BillingLink"))).click();
		driver.findElement(By.id(prop.getProperty("createAnAccountLink"))).click();
		
		
	}
	public void EnterDetailsCreateAccount(String Email, String Pass, String ConfPass, String Fname, String Lname, String PrimaryPhone, String MobPhone, String DOB) throws Exception{
		
		driver.findElement(By.id(prop.getProperty("EmailFieldID"))).sendKeys(Email);
		driver.findElement(By.id(prop.getProperty("PassFieldID"))).sendKeys(Pass);
		driver.findElement(By.id(prop.getProperty("ConfirmPassFieldID"))).sendKeys(ConfPass);
		driver.findElement(By.id(prop.getProperty("RegFirstNameFieldID"))).sendKeys(Fname);
		driver.findElement(By.id(prop.getProperty("RegLastNameFieldID"))).sendKeys(Lname);
		driver.findElement(By.id(prop.getProperty("RegPrimaryPhoneNumFieldID"))).sendKeys(PrimaryPhone);
		driver.findElement(By.id(prop.getProperty("RegMobilePhoneNumFieldID"))).sendKeys(MobPhone);
		driver.findElement(By.id(prop.getProperty("RegDOBFieldID"))).sendKeys(DOB);
				
	}
	
	public void EnterDetailsMailingAddress(String Address1, String city, String State, String zip){
		
		driver.findElement(By.id(prop.getProperty("MailingAddress1FieldID"))).sendKeys(Address1);
		driver.findElement(By.id(prop.getProperty("MailingCityFieldID"))).sendKeys(city);
		Select drpMailingstate = new Select(driver.findElement(By.id(prop.getProperty("MailingStateDrpID"))));
		drpMailingstate.selectByValue(State);
		driver.findElement(By.id(prop.getProperty("MailingZipFieldID"))).sendKeys(zip);
		
	}
	
	public void EnterDetailsBillingAddress(String Address1, String city, String State, String zip){
		
		driver.findElement(By.id(prop.getProperty("BillingAddress1FieldID"))).sendKeys(Address1);
		driver.findElement(By.id(prop.getProperty("BillingCityFieldID"))).sendKeys(city);
		Select drpBillingstate = new Select(driver.findElement(By.id(prop.getProperty("BillingStateDrpID"))));
		drpBillingstate.selectByValue(State);
		driver.findElement(By.id(prop.getProperty("BillingZipFieldID"))).sendKeys(zip);
			
	}
	
	public void SubmitForm(){
		
		driver.findElement(By.id(prop.getProperty("SubmitButtonID"))).click();
		
	}
	
	public void BillingAddressIsSameAsMailingAddress(){
		
		driver.findElement(By.id(prop.getProperty("BillingAddressIsSameAsMailingAddressChkbox"))).click();
	}
	
	
	
	
}

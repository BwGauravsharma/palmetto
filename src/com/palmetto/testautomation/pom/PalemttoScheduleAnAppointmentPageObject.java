package com.palmetto.testautomation.pom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalemttoScheduleAnAppointmentPageObject {
	
	WebDriver driver;
	Properties prop;
	
	public PalemttoScheduleAnAppointmentPageObject(WebDriver driver) throws FileNotFoundException, IOException{
		
		this.driver = driver;
		PalmettoTestAutomationUtilities util = new PalmettoTestAutomationUtilities();
		prop = util.readFromPropertiesFile();
		
	}
	
	public void GoToRequestAppointmentPage(){
	
		driver.findElement(By.linkText(prop.getProperty("PatientGuestHelplinktext"))).click();
		driver.findElement(By.linkText(prop.getProperty("ScheduleAnAppointmentlinktext"))).click();
		
	}
	
	public void EnterDetailOnRequestAppointmentForm(String Title, String FirstName, String LastName,
			String DOB, String EmailAddress, String Address, String City, String State, String Zip, 
			String County, String PrimaryPhone1st, String PrimaryPhone2nd, String PrimaryPhone3rd, String Ext, 
			String Date, String Time, String WhatWouldYouLikeToSchedule, String Reason){
		
		Select TitleddnID = new Select(driver.findElement(By.id(prop.getProperty("SAPTitleddnID"))));
		TitleddnID.selectByValue(Title);
		
		driver.findElement(By.id(prop.getProperty("SAPFirstNameFieldID"))).sendKeys(FirstName);
		driver.findElement(By.id(prop.getProperty("SAPLastnameFieldID"))).sendKeys(LastName);
		driver.findElement(By.id(prop.getProperty("SAPDOBFieldID"))).sendKeys(DOB);
		driver.findElement(By.id(prop.getProperty("SAPEmailAddressFieldID"))).sendKeys(EmailAddress);
		driver.findElement(By.id(prop.getProperty("SAPAddressFieldID"))).sendKeys(Address);
		driver.findElement(By.id(prop.getProperty("SAPCityFieldID"))).sendKeys(City);
		
		Select Stateddn = new Select(driver.findElement(By.id(prop.getProperty("SAPStateDdnID"))));
		Stateddn.selectByValue(State);
		
		driver.findElement(By.id(prop.getProperty("SAPZipFieldID"))).sendKeys(Zip);
		
		Select Countyddn = new Select(driver.findElement(By.id(prop.getProperty("SAPCountyDdnID"))));
		Countyddn.selectByValue(County);
		
		driver.findElement(By.id(prop.getProperty("SAPPrimaryPhonetxt1stFieldID"))).sendKeys(PrimaryPhone1st);
		driver.findElement(By.id(prop.getProperty("SAPPrimaryPhonetxt2ndFieldID"))).sendKeys(PrimaryPhone2nd);
		driver.findElement(By.id(prop.getProperty("SAPPrimaryPhonetxt3rdFieldID"))).sendKeys(PrimaryPhone3rd);
		driver.findElement(By.id(prop.getProperty("SAPPrimaryPhoneExtFieldID"))).sendKeys(Ext);
		driver.findElement(By.id(prop.getProperty("SAPDateFieldID"))).sendKeys(Date);
		
		Select Timeddn = new Select(driver.findElement(By.id(prop.getProperty("SAPTimeDdnID"))));
		Timeddn.selectByValue(Time);
		Select WhatWouldYouLikeddn = new Select(driver.findElement(By.id(prop.getProperty("WhatWouldYouLikeToScheduleDdnID"))));
		WhatWouldYouLikeddn.selectByValue(WhatWouldYouLikeToSchedule);
		
		driver.findElement(By.id(prop.getProperty("SAPPreferredLocationRadioButtonID"))).click();
		driver.findElement(By.id(prop.getProperty("SAPReasonForAppointmentFieldID"))).sendKeys(Reason);
		driver.findElement(By.id(prop.getProperty("SAPSubmitButtonID"))).click();
		
		
	}
	

}

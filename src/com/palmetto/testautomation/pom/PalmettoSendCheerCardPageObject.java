package com.palmetto.testautomation.pom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalmettoSendCheerCardPageObject {
	
	WebDriver driver;
	Properties prop;
	
	public PalmettoSendCheerCardPageObject(WebDriver driver) throws FileNotFoundException, IOException{
		
		this.driver = driver;
		PalmettoTestAutomationUtilities util = new PalmettoTestAutomationUtilities();
		prop = util.readFromPropertiesFile();
	}
	
	public void GoToSendCheerCardPage(){
		
		
		driver.findElement(By.linkText("Patients / Guests")).click();
		driver.findElement(By.linkText("Contact A Patient")).click();
		
	}
	
	public void SelectCardDesignAndClickNext(){
		
		driver.findElement(By.id(prop.getProperty("CardDesignRadioButtonID"))).click();
		driver.findElement(By.id(prop.getProperty("CheerCardSelectDesignNextButtonID"))).click();
	}
	
	public void SelectNoCardDesignAndClickNext(){
				
		driver.findElement(By.id(prop.getProperty("NoCardDesignRadioButtonID"))).click();
		driver.findElement(By.id(prop.getProperty("CheerCardSelectDesignNextButtonID"))).click();
		
	}
	
	public void SendCardToHospitalForDelivery(String sendername, 
			String senderemail,String phoneNum, String ext, String hospitals, 
			String patientfirstName, String patientlastName, String patientRoomNum){
		
		WebElement HospitalForDelivery = driver.findElement(By.id(prop.getProperty("HospitalForDeliveryRadioButtonID")));
		if(HospitalForDelivery.isSelected()){
			
			driver.findElement(By.id(prop.getProperty("SenderNameFieldID"))).sendKeys(sendername);
			driver.findElement(By.id(prop.getProperty("SenderEmailFieldID"))).sendKeys(senderemail);
			driver.findElement(By.id(prop.getProperty("PhoneNumFieldID"))).sendKeys(phoneNum);
			driver.findElement(By.id(prop.getProperty("ExtFieldID"))).sendKeys(ext);
			Select drpHospitals = new Select(driver.findElement(By.id(prop.getProperty("HospitalsDrpID"))));
			drpHospitals.selectByValue(hospitals);
			driver.findElement(By.id(prop.getProperty("PatientsFNameFieldID"))).sendKeys(patientfirstName);
			driver.findElement(By.id(prop.getProperty("PatientsLNameFieldID"))).sendKeys(patientlastName);
			driver.findElement(By.id(prop.getProperty("PatientsRoomNumFieldID"))).sendKeys(patientRoomNum);
			driver.findElement(By.id(prop.getProperty("PreviewButtonID"))).click();
			driver.findElement(By.id(prop.getProperty("SendButtonID"))).click();
			
		}
		
	}
	
	
	public void SendCardToPatientPersonalEmail(String sendername, 
			String senderemail,String phoneNum, String ext, String hospitals, 
			String patientfirstName, String patientlastName, String patientemail, String patientRoomNum){
		
		WebElement PatientPersonalEmail = driver.findElement(By.id(prop.getProperty("PatientsPersonalEmailRadioButtonID")));
		PatientPersonalEmail.click();
		if(PatientPersonalEmail.isSelected()){
			
			driver.findElement(By.id(prop.getProperty("SenderNameFieldID"))).sendKeys(sendername);
			driver.findElement(By.id(prop.getProperty("SenderEmailFieldID"))).sendKeys(senderemail);
			driver.findElement(By.id(prop.getProperty("PhoneNumFieldID"))).sendKeys(phoneNum);
			driver.findElement(By.id(prop.getProperty("ExtFieldID"))).sendKeys(ext);
			Select drpHospitals = new Select(driver.findElement(By.id(prop.getProperty("HospitalsDrpID"))));
			drpHospitals.selectByValue(hospitals);
			driver.findElement(By.id(prop.getProperty("PatientsFNameFieldID"))).sendKeys(patientfirstName);
			driver.findElement(By.id(prop.getProperty("PatientsLNameFieldID"))).sendKeys(patientlastName);
			driver.findElement(By.id(prop.getProperty("PatientsEmailFieldID"))).sendKeys(patientemail);
			driver.findElement(By.id(prop.getProperty("PatientsRoomNumFieldID"))).sendKeys(patientRoomNum);
			driver.findElement(By.id(prop.getProperty("PreviewButtonID"))).click();
			driver.findElement(By.id(prop.getProperty("SendButtonID"))).click();
			
		}
		
	}
	
}

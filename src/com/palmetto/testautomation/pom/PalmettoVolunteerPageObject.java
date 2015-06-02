package com.palmetto.testautomation.pom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;


public class PalmettoVolunteerPageObject {

	WebDriver driver;
	Properties prop;
	
	public PalmettoVolunteerPageObject(WebDriver driver) throws FileNotFoundException, IOException{
		
		this.driver = driver;
		PalmettoTestAutomationUtilities util = new PalmettoTestAutomationUtilities();
		prop = util.readFromPropertiesFile();
	}
	
	public void GoToVolunteerApplicationPage(){
		
		driver.findElement(By.linkText(prop.getProperty("GivingLinkText"))).click();
		driver.findElement(By.linkText(prop.getProperty("VolunteerProgramLinkText"))).click();
		driver.findElement(By.xpath(prop.getProperty("VolunteerApplicationLinkText"))).click();
	}
	
	
	public void SelectInitialPreference(String VolunteerProgramPreference){
		
		Select drpVolunteerProgramPreference = new Select(driver.findElement(By.id(prop.getProperty("VolunteerProgramPreferenceDrpID"))));
		drpVolunteerProgramPreference.selectByValue(VolunteerProgramPreference);
		driver.findElement(By.id(prop.getProperty("AreYouAbleToWorkRadioButtonID"))).click();
	}
	
	public void EnterPersonalInformation(String Title, String FirstName, String LastName, String PrimaryPhone,
			String EmailAddress, String DOBYear, String DOBMonth, String DOBDate, String CompletemailingAddress, 
			String City, String State, String Zip, String HowWereYouReferred){
		
			Select ddnTitle = new Select(driver.findElement(By.id(prop.getProperty("TitleDrpID"))));
			ddnTitle.selectByValue(Title);
			
			driver.findElement(By.id(prop.getProperty("LegalFirstNameFieldID"))).sendKeys("FirstName");
			driver.findElement(By.id(prop.getProperty("LastNameFieldID"))).sendKeys(LastName);
			driver.findElement(By.id(prop.getProperty("PrimaryPhoneFieldID"))).sendKeys(PrimaryPhone);
			driver.findElement(By.id(prop.getProperty("EmailAddressFieldID"))).sendKeys(EmailAddress);
			
			Select drpDOBYear = new Select(driver.findElement(By.id(prop.getProperty("DOBYearDrpID"))));
			drpDOBYear.selectByValue(DOBYear);
			
			Select drpDOBMonth = new Select(driver.findElement(By.id(prop.getProperty("DOBMonthDrpID"))));
			drpDOBMonth.selectByValue(DOBMonth);
			
			Select drpDOBDate = new Select(driver.findElement(By.id(prop.getProperty("DOBDateDrpID"))));
			drpDOBDate.selectByValue(DOBDate);
			
			driver.findElement(By.id(prop.getProperty("CompletemailingAddressFieldID"))).sendKeys(CompletemailingAddress);
			driver.findElement(By.id(prop.getProperty("CityFeildID"))).sendKeys(City);
			
			Select drpState = new Select(driver.findElement(By.id(prop.getProperty("StateDrpID"))));
			drpState.selectByValue(State);
			
			driver.findElement(By.id(prop.getProperty("ZipFieldID"))).sendKeys(Zip);
			
			Select drpHowWereYouReferred = new Select(driver.findElement(By.id(prop.getProperty("HowWereYouReferredDrpID"))));
			drpHowWereYouReferred.selectByValue(HowWereYouReferred);
		
		
	}
	
	public void EnterEmergencyContact(String FirstName, String LastName, String PhoneNum, String RelationShipToApplicant){
		
		driver.findElement(By.id(prop.getProperty("FirstNameEmerFiledID"))).sendKeys(FirstName);
		driver.findElement(By.id(prop.getProperty("LastNameEmerFiledID"))).sendKeys(LastName);
		driver.findElement(By.id(prop.getProperty("PhoneNumEmerFiledID"))).sendKeys(PhoneNum);
		driver.findElement(By.id(prop.getProperty("RelationShipToApplicantEmerFieldID"))).sendKeys(RelationShipToApplicant);
		
	}
	
	public void FillEducationDetailsAndClickNextButton(String UnderGraguateSchool, String UnderGraguateDegree,
			String GraguateSchool, String GraguateDegree, String CurrentlicensesOrCertification){
		
		driver.findElement(By.id(prop.getProperty("HighSchoolStudentChkBoxID"))).click();
		driver.findElement(By.id(prop.getProperty("HighSchoolGraduateChkBoxID"))).click();
		driver.findElement(By.id(prop.getProperty("UndergraduateChkBoxID"))).click();
		driver.findElement(By.id(prop.getProperty("UnderGraguateSchoolFieldID"))).sendKeys(UnderGraguateSchool);
		driver.findElement(By.id(prop.getProperty("UnderGraguateDegreeFieldID"))).sendKeys(UnderGraguateDegree);
		driver.findElement(By.id(prop.getProperty("GraduateChkBoxID"))).click();
		driver.findElement(By.id(prop.getProperty("GraguateSchoolFieldID"))).sendKeys(GraguateSchool);
		driver.findElement(By.id(prop.getProperty("GraguateDegreeFieldID"))).sendKeys(GraguateDegree);
		driver.findElement(By.id(prop.getProperty("CurrentlicensesOrCertificationFieldID"))).sendKeys(CurrentlicensesOrCertification);
		driver.findElement(By.id(prop.getProperty("Step1NextButtonID"))).click();
		
	}
	
	public void EnterEmploymentStatus(String Employer, String EmployerPhone, String Position){
		
		driver.findElement(By.id(prop.getProperty("VolunteersEmploymentStatusChkBxID"))).click();
		driver.findElement(By.id(prop.getProperty("VolunteersEmployerFieldID"))).sendKeys(Employer);
		driver.findElement(By.id(prop.getProperty("VolunteersEmployerPhoneFieldID"))).sendKeys(EmployerPhone);
		driver.findElement(By.id(prop.getProperty("VolunteersPositionFieldID"))).sendKeys(Position);
		
	}
	
	public void EnterReference1(String FirstName, String LastName, String mailingAddress, String City,
			String State, String ZIP, String Phone, String Email, String YearsKnown){
		
		driver.findElement(By.id(prop.getProperty("Reference1FirstNamefieldID"))).sendKeys(FirstName);
		driver.findElement(By.id(prop.getProperty("Reference1lastNamefieldID"))).sendKeys(LastName);
		driver.findElement(By.id(prop.getProperty("Reference1CompleteMailingAddressFieldID"))).sendKeys(mailingAddress);
		driver.findElement(By.id(prop.getProperty("Reference1CityFieldID"))).sendKeys(City);
		Select Stateddn = new Select(driver.findElement(By.id(prop.getProperty("Reference1StateDdnID"))));
		Stateddn.selectByValue(State);
		driver.findElement(By.id(prop.getProperty("Reference1ZipFieldID"))).sendKeys(ZIP);
		driver.findElement(By.id(prop.getProperty("Reference1phoneFieldID"))).sendKeys(Phone);
		driver.findElement(By.id(prop.getProperty("Reference1EmailFieldID"))).sendKeys(Email);
		Select YearsKnownddn = new Select(driver.findElement(By.id(prop.getProperty("Reference1YearsKnownDdnID"))));
		YearsKnownddn.selectByValue(YearsKnown);
		
	}
	
	public void EnterReference2(String FirstName, String LastName, String mailingAddress, String City,
			String State, String ZIP, String Phone, String Email, String YearsKnown){
		
		driver.findElement(By.id(prop.getProperty("Reference2FirstNamefieldID"))).sendKeys(FirstName);
		driver.findElement(By.id(prop.getProperty("Reference2lastNamefieldID"))).sendKeys(LastName);
		driver.findElement(By.id(prop.getProperty("Reference2CompleteMailingAddressFieldID"))).sendKeys(mailingAddress);
		driver.findElement(By.id(prop.getProperty("Reference2CityFieldID"))).sendKeys(City);
		Select Stateddn = new Select(driver.findElement(By.id(prop.getProperty("Reference2StateDdnID"))));
		Stateddn.selectByValue(State);
		driver.findElement(By.id(prop.getProperty("Reference2ZipFieldID"))).sendKeys(ZIP);
		driver.findElement(By.id(prop.getProperty("Reference2phoneFieldID"))).sendKeys(Phone);
		driver.findElement(By.id(prop.getProperty("Reference2EmailFieldID"))).sendKeys(Email);
		Select YearsKnownddn = new Select(driver.findElement(By.id(prop.getProperty("Reference2YearsKnownDdnID"))));
		YearsKnownddn.selectByValue(YearsKnown);
		
	}
	
	public void EnterPhysicianReference(String PhysicianName, String mailingAddress, String City,
			String State, String ZIP, String Phone, String Fax){
		
		driver.findElement(By.id(prop.getProperty("PhysicianNameFieldID"))).sendKeys(PhysicianName);
		driver.findElement(By.id(prop.getProperty("PhysicanReferenceMailingAddressFieldID"))).sendKeys(mailingAddress);
		driver.findElement(By.id(prop.getProperty("PhysicanReferenceCityFieldID"))).sendKeys(City);
		Select Stateddn = new Select(driver.findElement(By.id(prop.getProperty("PhysicanReferenceStateDdnID"))));
		Stateddn.selectByValue(State);
		driver.findElement(By.id(prop.getProperty("PhysicanReferenceZipFieldID"))).sendKeys(ZIP);
		driver.findElement(By.id(prop.getProperty("PhysicanReferencePhoneFieldID"))).sendKeys(Phone);
		driver.findElement(By.id(prop.getProperty("PhysicanReferenceFaxFieldID"))).sendKeys(Fax);
		
	}
	
	public void SelectDisclaimers(){
		
		
		driver.findElement(By.id(prop.getProperty("DisclaimersIcertifythattheinformationChkboxID"))).click();
		driver.findElement(By.id(prop.getProperty("DisclaimersIunderstandthatanyfalsificationChkboxID"))).click();
		driver.findElement(By.id(prop.getProperty("DisclaimersAllpersonsororganizationsnamedChkboxID"))).click();
		driver.findElement(By.id(prop.getProperty("DisclaimersPalmettoHealthprovidesopportunitiesforvolunteersChkboxID"))).click();
		driver.findElement(By.id(prop.getProperty("DisclaimersIfacceptedIwillcomplywithallstandardsandpoliciesChkBxID"))).click();
		driver.findElement(By.id(prop.getProperty("DisclaimersfelonyormisdemeanorRadioBtnID"))).click();
		
	}
	
	public void EnterElectronicSignatureandClickNextButton(String LegalName, String Date) throws InterruptedException{
		
		driver.findElement(By.id(prop.getProperty("ElecttronicSignatureLegalNameFieldID"))).sendKeys(LegalName);
		driver.findElement(By.id(prop.getProperty("ElecttronicSignatureDateFieldID"))).click();
		Thread.sleep(5000);
		driver.findElement(By.id(prop.getProperty("Step2NextButtonID"))).click();
		
	}
	public void ClickOnVolunteerFormSubmitButton(){
		
		driver.findElement(By.id(prop.getProperty("FormSubmitButtonID"))).click();
		
	}
}

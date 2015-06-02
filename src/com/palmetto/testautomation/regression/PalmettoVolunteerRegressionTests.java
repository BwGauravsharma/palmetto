package com.palmetto.testautomation.regression;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.palmetto.testautomation.pom.PalmettoVolunteerPageObject;
import com.palmetto.testautomation.properties.PalmettoTestAutomationProperties;
import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalmettoVolunteerRegressionTests {

	WebDriver driver;
	PalmettoVolunteerPageObject Volunteer;
	PalmettoTestAutomationUtilities util;
	
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty(PalmettoTestAutomationProperties.CHROME_DRIVER, PalmettoTestAutomationProperties.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PalmettoTestAutomationProperties.URL);
		Volunteer = new PalmettoVolunteerPageObject(driver);
		util = new PalmettoTestAutomationUtilities();
	}

	@Test
	public void ApplyForVolunteerProgram() throws InterruptedException {
		
		Volunteer.GoToVolunteerApplicationPage();
		Volunteer.SelectInitialPreference("PH Hospice");
		Volunteer.EnterPersonalInformation("Mr.", "TestAutomation FirstName", "TestAutomation LastName", "123-456-7858",
				"TestAutomation@test.com", "1990", "April", "11", "TestAutomation CompletemailingAddress",
				"TestAutomation City", "Alabama", "90021", "Employee");
		Volunteer.EnterEmergencyContact("TestAutomation FirstName", "TestAutomation LastName", "113-213-2131", "colleague");
		Volunteer.FillEducationDetailsAndClickNextButton("UnderGraguateSchool", "UnderGraguateDegree", "GraguateSchool",
				"GraguateDegree", "CurrentlicensesOrCertification");
		Volunteer.EnterEmploymentStatus("TestAutomation Employer", "123-456-8758", "TestAutomation Position");
		Volunteer.EnterReference1("TestAutomation FirstName", "TestAutomation LastName", "TestAutomation Address",
				"TestAutomation City", "Alabama", "90012", "123-545-6789", "TestAutomation@test.com", "1");
		Volunteer.EnterReference2("TestAutomation FirstName1", "TestAutomation LastName1", "TestAutomation Address",
				"TestAutomation City", "Alabama", "90012", "123-852-7898", "TestAutomation@test.com", "1");
		Volunteer.EnterPhysicianReference("TestAutomation PhysicianName", "TestAutomation Address",
				"TestAutomation City", "Alabama", "90012", "789-852-4568", "785-457-9547");
		Volunteer.SelectDisclaimers();
		Volunteer.EnterElectronicSignatureandClickNextButton("TestAutomation Fname", "5/19/2015");
		Volunteer.ClickOnVolunteerFormSubmitButton();
		
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/form/section/div[2]/div[3]/div[2]/div/div/div/div/p")).getText().contains("Thank you for applying!!!"));
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		util.closeBrowser(driver);
	}

}

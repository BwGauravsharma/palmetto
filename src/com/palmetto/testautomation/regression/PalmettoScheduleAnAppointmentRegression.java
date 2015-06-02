package com.palmetto.testautomation.regression;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.palmetto.testautomation.pom.PalemttoScheduleAnAppointmentPageObject;
import com.palmetto.testautomation.pom.PalmettoLoginPageObject;
import com.palmetto.testautomation.properties.PalmettoTestAutomationProperties;
import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalmettoScheduleAnAppointmentRegression {

	WebDriver driver;
	PalemttoScheduleAnAppointmentPageObject ScheduleAnAppointment;
	PalmettoTestAutomationUtilities util;
	PalmettoLoginPageObject LogIn;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty(PalmettoTestAutomationProperties.CHROME_DRIVER, PalmettoTestAutomationProperties.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PalmettoTestAutomationProperties.URL);
		ScheduleAnAppointment = new PalemttoScheduleAnAppointmentPageObject(driver);
		util = new PalmettoTestAutomationUtilities();
		LogIn = new PalmettoLoginPageObject(driver);
	}

	@Test
	public void ScheduleAnAppointment() {
		
		ScheduleAnAppointment.GoToRequestAppointmentPage();
		LogIn.LogIn("Chandarani.kale@bluespiremarketing.com", "test@123");
		ScheduleAnAppointment.EnterDetailOnRequestAppointmentForm("Mr.", "TestAutomation FirstName", "TestAutomation LastName", "7/1/1981",
				"Jyoti.gutte@bluespiremarketing.com", "TestAutomation Address", "City", "13",
				"90012", "Anderson", "123", "785","8548", "852456", "5/13/2015",
				"10:30", "Mammogram", "Test Reason");
		//Assertion to check whether "Thank You" message is displayed
		Assert.assertTrue(driver.findElement(By.className("prer-content-wrap")).getText().contains("Thank you for requesting an appointment."));
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		util.closeBrowser(driver);
	}

}

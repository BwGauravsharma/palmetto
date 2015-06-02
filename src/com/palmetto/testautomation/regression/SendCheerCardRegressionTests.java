package com.palmetto.testautomation.regression;

import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import com.palmetto.testautomation.pom.PalmettoSendCheerCardPageObject;
import com.palmetto.testautomation.properties.PalmettoTestAutomationProperties;
import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class SendCheerCardRegressionTests {
	
	WebDriver driver;
	PalmettoSendCheerCardPageObject SendCheerCard;
	PalmettoTestAutomationUtilities util;
	int num;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty(PalmettoTestAutomationProperties.CHROME_DRIVER, PalmettoTestAutomationProperties.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PalmettoTestAutomationProperties.URL);
		SendCheerCard = new PalmettoSendCheerCardPageObject(driver);
		util = new PalmettoTestAutomationUtilities();
		
	}
	
	@Test
	public void SendCheerCardwithDesignCardToHospital()throws Exception {
		
		SendCheerCard.GoToSendCheerCardPage();
		SendCheerCard.SelectCardDesignAndClickNext();
		SendCheerCard.SendCardToHospitalForDelivery("Test sender name", "Chandarani.kale@bluespiremarketing.com", 
				"123-456-7897", "12344", "Palmetto Health Baptist", "test Fname", "Test Lname", "25");
		
	}
	
	@Test
	public void SendCheerCardwithOutDesignCardToHospital()throws Exception {
		
		SendCheerCard.GoToSendCheerCardPage();
		SendCheerCard.SelectNoCardDesignAndClickNext();
		SendCheerCard.SendCardToHospitalForDelivery("Test sender name", "Chandarani.kale@bluespiremarketing.com", 
				"123-456-7897", "12345", "Palmetto Health Baptist", "test Fname", "Test Lname", "25");
		
	}
	
	@Test
	public void SendCheerCardwithDesignCardToPateintEmail()throws Exception {
		
		SendCheerCard.GoToSendCheerCardPage();
		SendCheerCard.SelectCardDesignAndClickNext();
		SendCheerCard.SendCardToPatientPersonalEmail("Test sender name", "Chandarani.kale@bluespiremarketing.com", 
				"123-456-7897", "12345", "Palmetto Health Baptist", "test Fname", "Test Lname",
				"Jyoti.gutte@bluespiremarketing.com", "25");
		
	}
	
	@Test
	public void SendCheerCardwithoutDesignCardToPateintEmail()throws Exception {
		
		SendCheerCard.GoToSendCheerCardPage();
		SendCheerCard.SelectNoCardDesignAndClickNext();
		SendCheerCard.SendCardToPatientPersonalEmail("Test sender name", "Chandarani.kale@bluespiremarketing.com", 
				"123-456-7897", "1234", "Palmetto Health Baptist", "test Fname", "Test Lname",
				"Jyoti.gutte@bluespiremarketing.com", "25");
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		
		util.closeBrowser(driver);
		
		}
	
}

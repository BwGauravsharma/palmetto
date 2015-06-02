package com.palmetto.testautomation.regression;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.palmetto.testautomation.pom.PalmettoRegistrationPageObject;
import com.palmetto.testautomation.properties.PalmettoTestAutomationProperties;
import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalmettoRegistrationRegressionTests {

	WebDriver driver;
	PalmettoRegistrationPageObject Register;
	PalmettoTestAutomationUtilities Utill;
	int num;
	@Before
	public void setUp() throws Exception {
		
		System.setProperty(PalmettoTestAutomationProperties.CHROME_DRIVER, PalmettoTestAutomationProperties.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PalmettoTestAutomationProperties.URL);
		Register = new PalmettoRegistrationPageObject(driver);
		Utill = new PalmettoTestAutomationUtilities();
		
		Random random = new Random();
		num = random.nextInt();
		
	}

	@Test
	public void RegisterWhenBillingAndMailingAddressDifferent()throws Exception {
		
		Register.GoToRegistrationPage();
		Register.EnterDetailsCreateAccount("TestAutomationUser"+num+"@gmail.com", "Testpass123@", "Testpass123@", "Test Fname",
				"Test Lname", "123-456-9879", "123-456-7885", "05/06/1990");
		Register.EnterDetailsMailingAddress("Test Address1", "Test City", "6", "90012");
		Register.EnterDetailsBillingAddress("Test Address1", "Test City", "11", "90012");
		Register.SubmitForm();
		Assert.assertTrue(driver.findElement(By.id("p_lt_ctl02_pageplaceholder_p_lt_ctl05_PalmettoSign_Up_lblText")).getText().contains("A e-mail has been sent to the registered e-mail. Click on the link in the e-mail to confirm your registration."));
		
	}
	
	@Test
	public void RegisterWhenBillingAndMailingAddressSame()throws Exception {
		
		Register.GoToRegistrationPage();
		Register.EnterDetailsCreateAccount("TestAutomationUser"+num+"@gmail.com", "Testpass123@", "Testpass123@", "Test Fname",
				"Test Lname", "123-456-9879", "123-456-7885", "05/06/1990");
		Register.EnterDetailsMailingAddress("Test Address1", "Test City", "6", "90012");
		Register.BillingAddressIsSameAsMailingAddress();
		Register.SubmitForm();
		Assert.assertTrue(driver.findElement(By.id("p_lt_ctl02_pageplaceholder_p_lt_ctl05_PalmettoSign_Up_lblText")).getText().contains("A e-mail has been sent to the registered e-mail. Click on the link in the e-mail to confirm your registration."));
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		Utill.closeBrowser(driver);
	}

}

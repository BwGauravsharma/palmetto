package com.palmetto.testautomation.regression;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.palmetto.testautomation.pom.PalmettoLoginPageObject;
import com.palmetto.testautomation.properties.PalmettoTestAutomationProperties;
import com.palmetto.testautomation.utilities.PalmettoTestAutomationUtilities;

public class PalmettoLoginRegressionTests {

	WebDriver driver;
	PalmettoLoginPageObject LoginPage;
	PalmettoTestAutomationUtilities utill;

	@Before
	public void setUp() throws Exception {

		System.setProperty(PalmettoTestAutomationProperties.CHROME_DRIVER,
				PalmettoTestAutomationProperties.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PalmettoTestAutomationProperties.URL);
		LoginPage = new PalmettoLoginPageObject(driver);
		utill = new PalmettoTestAutomationUtilities();

	}

	@Test
	public void LogInToPalmetto() throws Exception {

		LoginPage.GoToLogInPage();
		HashMap<String, HashMap<String, String>> excelData = utill.readFromDataSheet("LogIn");
		for (String eachKey : excelData.keySet()) {
			HashMap<String, String> eachVal = excelData.get(eachKey);
			LoginPage.LogIn(eachVal.get("username"), eachVal.get("password"));
		}

		// Assertion to check whether "Sign Out" link is displayed
		Assert.assertTrue(driver.findElement(By.id("p_lt_ctl01_pageplaceholder3_p_lt_ctl00_SignOutButton_btnSignOutLink")).getText().contains("Sign Out"));

	}

	@After
	public void tearDown() throws Exception {

		utill.closeBrowser(driver);
	}

}

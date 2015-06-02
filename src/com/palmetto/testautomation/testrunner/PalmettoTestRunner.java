package com.palmetto.testautomation.testrunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.palmetto.testautomation.regression.PalmettoLoginRegressionTests;

public class PalmettoTestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	      Result result = JUnitCore.runClasses(PalmettoLoginRegressionTests.class);
	      
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	         
	      }
	      
	        System.out.println(result.wasSuccessful());
	   }

}

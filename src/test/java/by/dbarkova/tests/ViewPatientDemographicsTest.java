package by.dbarkova.tests;

import org.testng.annotations.Test;

import by.dbarkova.entities.Patient;
import by.dbarkova.steps.NavigationSteps;
import by.dbarkova.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ViewPatientDemographicsTest {
	
	private Steps steps;
	private NavigationSteps navigation;
	private static final String COMPANY_CODE = "DEMO01";
	private static final String LOGIN = "bdw89@mail.ru";
	private static final String PASSWORD = "P@ssw0rd";

	@BeforeMethod
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		navigation = new NavigationSteps();
		navigation.initBrowser();
		
	}

	@Test
	public void checkPatientDemographics() {
		steps.login(COMPANY_CODE, LOGIN, PASSWORD);
		navigation.navigateToCareCoordination();
		navigation.navigateToPatientsList();
		Patient listPatient = steps.getListPatientDemographics();
		navigation.navigateToPatientDetails();
		Patient detailsPatient = steps.getDetailsPatientDemographics();
		Assert.assertTrue(listPatient.equals(detailsPatient));
	}

	@AfterMethod
	public void stopBrowser() {
		steps.closeDriver();
	}

}

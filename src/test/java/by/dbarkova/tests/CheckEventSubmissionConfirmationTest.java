package by.dbarkova.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.dbarkova.steps.NavigationSteps;
import by.dbarkova.steps.Steps;

public class CheckEventSubmissionConfirmationTest {
 
	private Steps steps;
	private NavigationSteps navigation;
	private static final String COMPANY_CODE = "";
	private static final String LOGIN = "";
	private static final String PASSWORD = "";
	private static final String EVENT_SUBMISSION_CONFIRMATION = "Event has been successfully created";

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
		navigation.navigateToPatientDetails();
		String confirmationText = steps.extractEventSubmissionConfirmation();
		Assert.assertEquals(confirmationText, EVENT_SUBMISSION_CONFIRMATION);
	}

	@AfterMethod
	public void stopBrowser() {
		steps.closeDriver();
	}
	
}

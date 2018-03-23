package by.dbarkova.tests;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.dbarkova.entities.Event;
import by.dbarkova.steps.NavigationSteps;
import by.dbarkova.steps.Steps;

public class EventSubmissionTest {

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
	public void checkEventSubmission() throws ParseException {
		steps.login(COMPANY_CODE, LOGIN, PASSWORD);
		navigation.navigateToCareCoordination();
		navigation.navigateToPatientsList();
		navigation.navigateToPatientDetails();
		Event eventCreation = steps.submitNewEvent();
		steps.refreshPage();
		navigation.navigateToPatientDetails();
		navigation.navigateToPatientEventsList();
		navigation.viewLatestEventDetails();
		Event eventCreated = steps.getSubmittedEventDetails();
 		Assert.assertTrue(eventCreation.equals(eventCreated));
	}

	@AfterMethod
	public void stopBrowser() {
		steps.closeDriver();
	}

}

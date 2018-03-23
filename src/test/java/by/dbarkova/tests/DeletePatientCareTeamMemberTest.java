package by.dbarkova.tests;

import org.testng.annotations.Test;

import by.dbarkova.entities.CareTeamMember;
import by.dbarkova.steps.NavigationSteps;
import by.dbarkova.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DeletePatientCareTeamMemberTest {
	
	private Steps steps;
	private NavigationSteps navigation;
	private CareTeamMember careTeamMember;
	
	private static final String COMPANY_CODE = "DEMO01";
	private static final String LOGIN = "bdw89@mail.ru";
	private static final String PASSWORD = "P@ssw0rd";

	@BeforeMethod
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		navigation = new NavigationSteps();
		navigation.initBrowser();
		
		careTeamMember = new CareTeamMember();
		careTeamMember.setFirstName("Patrick");
		careTeamMember.setLastName("Edwards");
		careTeamMember.setCareTeamRole("Service Provider");
		careTeamMember.setRelatedOrganization("Demonstration");
	}

	@Test
	public void deletePatientCareTeamMember() {
		steps.login(COMPANY_CODE, LOGIN, PASSWORD);
		navigation.navigateToCareCoordination();
		navigation.navigateToPatientsList();
		navigation.navigateToPatientDetails();
		steps.clickDeletePatientCareTeamMemberButton(careTeamMember);
		steps.getPatientCTMembersList();
		
		Assert.assertTrue(!steps.getPatientCTMembersList().contains(careTeamMember));
	}

	@AfterMethod
	public void afterMethod() {
		steps.closeDriver();
	}
}

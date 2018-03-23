package by.dbarkova.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.dbarkova.entities.CareTeamMember;
import by.dbarkova.steps.NavigationSteps;
import by.dbarkova.steps.Steps;

public class AddPatientCareTeamMemberTest {
	
	private Steps steps;
	private NavigationSteps navigation;
	private CareTeamMember careTeamMember;
	private static final String COMPANY_CODE = "";
	private static final String LOGIN = "";
	private static final String PASSWORD = "";
	private static final String PATIENT_CARE_TEAM_MEMBER_NAME = "Patrick Edwards";
	private static final String PATIENT_CARE_TEAM_MEMBER_ROLE = "Case Manager";
	private static final String PATIENT_CARE_TEAM_MEMBER_ORGANIZATION = "Demonstration";

	@BeforeTest
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		navigation = new NavigationSteps();
		navigation.initBrowser();
		
		careTeamMember = new CareTeamMember();
		careTeamMember.setFirstName(PATIENT_CARE_TEAM_MEMBER_NAME.split(" ")[0]);
		careTeamMember.setLastName(PATIENT_CARE_TEAM_MEMBER_NAME.split(" ")[1]);
		careTeamMember.setCareTeamRole(PATIENT_CARE_TEAM_MEMBER_ROLE);
		careTeamMember.setRelatedOrganization(PATIENT_CARE_TEAM_MEMBER_ORGANIZATION);
	}

	@Test
	public void addPatientCareTeamMember() {
		steps.login(COMPANY_CODE, LOGIN, PASSWORD);
		navigation.navigateToCareCoordination();
		navigation.navigateToPatientsList();
		navigation.navigateToPatientDetails();
		steps.openAddNewPatientCareTeamMemberForm();
		steps.setCTMemberName(PATIENT_CARE_TEAM_MEMBER_NAME);
		steps.setCTMemberRole(PATIENT_CARE_TEAM_MEMBER_ROLE);
		steps.submitCareTeamMemberForm();
		List<CareTeamMember> patientCTMembers = steps.getPatientCTMembersList();
		
		System.out.println("Added CT Member is: " + careTeamMember);
		
		System.out.println("CT Members list is: " + patientCTMembers);
		
		Assert.assertTrue(patientCTMembers.contains(careTeamMember));
	}

	@AfterTest
	public void stopBrowser() {
		steps.closeDriver();
	}
}

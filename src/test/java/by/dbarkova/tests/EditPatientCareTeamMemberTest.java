package by.dbarkova.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.dbarkova.entities.CareTeamMember;
import by.dbarkova.steps.NavigationSteps;
import by.dbarkova.steps.Steps;

public class EditPatientCareTeamMemberTest {

	private Steps steps;
	private NavigationSteps navigation;
	private CareTeamMember careTeamMember;
	int index;
	private static final String COMPANY_CODE = "";
	private static final String LOGIN = "";
	private static final String PASSWORD = "";
	private static final String PATIENT_CARE_TEAM_MEMBER_NAME = "Patrick Edwards";
	private static final String PATIENT_CARE_TEAM_MEMBER_ROLE = "Service Provider";
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
		careTeamMember.setCareTeamRole("Case Manager");
		careTeamMember.setRelatedOrganization(PATIENT_CARE_TEAM_MEMBER_ORGANIZATION);

		steps.login(COMPANY_CODE, LOGIN, PASSWORD);
		navigation.navigateToCareCoordination();
		navigation.navigateToPatientsList();
		navigation.navigateToPatientDetails();
		
	}

	@Test(priority = 0)
	public void checkPatientCareTeamMemberContactNameState() {
		steps.openEditPatientCareTeamMemberForm(careTeamMember);
		Assert.assertTrue(steps.checkDropDownContactNameIsDisabled());
	}

	@Test(priority = 1)
	public void editPatientCareTeamMemberRole() {
		steps.setCTMemberRole(PATIENT_CARE_TEAM_MEMBER_ROLE);
		steps.submitCareTeamMemberForm();
		careTeamMember.setCareTeamRole(PATIENT_CARE_TEAM_MEMBER_ROLE);
		Assert.assertTrue(steps.getPatientCTMembersList().contains(careTeamMember));
	}

	@AfterTest
	public void stopBrowser() {
		steps.closeDriver();
	}
}

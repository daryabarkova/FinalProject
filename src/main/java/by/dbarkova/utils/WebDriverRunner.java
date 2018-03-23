package by.dbarkova.utils;

import by.dbarkova.entities.CareTeamMember;
import by.dbarkova.steps.NavigationSteps;
import by.dbarkova.steps.Steps;

public class WebDriverRunner {
	
	private static final String PATIENT_CARE_TEAM_MEMBER_NAME = "Patrick Edwards";
	private static final String PATIENT_CARE_TEAM_MEMBER_ROLE = "Case Manager";
	private static final String PATIENT_CARE_TEAM_MEMBER_ORGANIZATION = "Demonstration";

	public static void main(String[] args) {
		
		CareTeamMember careTeamMember = new CareTeamMember();
		careTeamMember.setFirstName(PATIENT_CARE_TEAM_MEMBER_NAME.split(" ")[0]);
		careTeamMember.setLastName(PATIENT_CARE_TEAM_MEMBER_NAME.split(" ")[1]);
		careTeamMember.setCareTeamRole(PATIENT_CARE_TEAM_MEMBER_ROLE);
		careTeamMember.setRelatedOrganization(PATIENT_CARE_TEAM_MEMBER_ORGANIZATION);
		
		Steps steps = new Steps();
		NavigationSteps navigation = new NavigationSteps();
		steps.initBrowser();
		navigation.initBrowser();
		steps.login("demo01", "bdw89@mail.ru", "P@ssw0rd");
		navigation.navigateToCareCoordination();
		navigation.navigateToPatientsList();
		navigation.navigateToPatientDetails();
		steps.openAddNewPatientCareTeamMemberForm();
		steps.setCTMemberName(PATIENT_CARE_TEAM_MEMBER_NAME);

		System.out.println();
	
		
	}

}

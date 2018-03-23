package by.dbarkova.steps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.dbarkova.driver.DriverSingleton;
import by.dbarkova.entities.CareTeamMember;
import by.dbarkova.entities.Event;
import by.dbarkova.entities.Patient;
import by.dbarkova.pages.CareTeamMemberPage;
import by.dbarkova.pages.CreateNewEventPage;
import by.dbarkova.pages.LoginPage;
import by.dbarkova.pages.MainPage;
import by.dbarkova.pages.ModalDialog;
import by.dbarkova.pages.PatientDetailsPage;
import by.dbarkova.pages.PatientEventsListPage;
import by.dbarkova.pages.PatientsListPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	private void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void login(String companyCode, String login, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.populateCompanyCode(companyCode);
		loginPage.populateLogin(login);
		loginPage.populatePassword(password);
		loginPage.clickLoginButton();
		MainPage mainPage = new MainPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(mainPage.checkCareCoordinationMenuTab()));
		System.out.println("User has logged in!");
	}

	public String getLoggedUserName() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		String userName = mainPage.extractLoggedUserNameWait();
		return userName;
	}

	public Patient getListPatientDemographics() {
		Patient patient = new Patient();
		PatientsListPage patientsPage = new PatientsListPage(driver);
		patient.setFirstName(patientsPage.getFirstListItemFirstName());
		patient.setLastName(patientsPage.getFirstListItemLastName());
		patient.setGender(patientsPage.getFirstListItemGender());
		patient.setBirthDate(patientsPage.getFirstListItemBirthDate());
		patient.setSSN(patientsPage.getFirstListItemSSN());
		patient.setRelatedCommunity(patientsPage.getFirstListItemCommunity());

		System.out.println("List patient demographics have been gathered!");
		System.out.println(patient);

		return patient;
	}

	public Patient getDetailsPatientDemographics() {
		Patient patient = new Patient();
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		patient.setFirstName(patientDetailsPage.getPatientFirstName());
		patient.setLastName(patientDetailsPage.getPatientLastName());
		patient.setSSN(patientDetailsPage.getPatientSSN());
		patient.setBirthDate(patientDetailsPage.getPatientBirthDate());
		patient.setGender(patientDetailsPage.getPatientGenger());
		patient.setRelatedCommunity(patientDetailsPage.getPatientRelatedCommunity());

		System.out.println("Details patient demographics have been gathered!");
		System.out.println(patient);

		return patient;
	}

	public String extractEventSubmissionConfirmation() {
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		CreateNewEventPage createNewEventPage = new CreateNewEventPage(driver);
		patientDetailsPage.clickAddNewEventButton();
		waitForElement(createNewEventPage.checkHeaderCreateNewEvent());
		createNewEventPage.showCareTeamRoleList();
		createNewEventPage.selectCMCareTeamRole();
		createNewEventPage.submitNewEvent();
		ModalDialog modalDialog = new ModalDialog(driver);
		waitForElement(modalDialog.checkDialogEventSubmissionConfirmation());
		String text = modalDialog.extractDialogEventBodyText();
		modalDialog.clickCloseButton();
		System.out.println("New Event has been submitted and confirmation text has been extracted!");
		return text;
	}

	public Event submitNewEvent() throws ParseException {
		MainPage mainPage = new MainPage(driver);
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		CreateNewEventPage createNewEventPage = new CreateNewEventPage(driver);
		patientDetailsPage.clickAddNewEventButton();
		waitForElement(createNewEventPage.checkHeaderCreateNewEvent());
		createNewEventPage.showCareTeamRoleList();
		createNewEventPage.selectCMCareTeamRole();
		createNewEventPage.submitNewEvent();
		ModalDialog modalDialog = new ModalDialog(driver);
		waitForElement(modalDialog.checkDialogEventSubmissionConfirmation());
		modalDialog.clickOkButton();
		System.out.println("New Event has been submitted!");
		Event event = new Event();
		event.setEventCreator(mainPage.extractLoggedUserName());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentDateWithoutSeconds = sdf.parse(sdf.format(new Date()));
		event.setDate(currentDateWithoutSeconds);
		event.setCreatorCareTeamRole("Case Manager");
		event.setEventType("Accident requiring treatment");
		System.out.println("Event details:" + event);
		return event;
	}

	public Event getSubmittedEventDetails() {
		PatientEventsListPage patientEventsListPage = new PatientEventsListPage(driver);
		Event event = new Event();
		event.setEventCreator(patientEventsListPage.extractEventCreatorName());
		event.setCreatorCareTeamRole(patientEventsListPage.extractEventCreatorRole());
		String date = patientEventsListPage.extractEventSubmissionDateAndTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		try {
			event.setDate(formatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		event.setEventType(patientEventsListPage.extractEventType());
		System.out.println("Event details that are displayed as description:" + event);
		return event;
	}

	public void openAddNewPatientCareTeamMemberForm() {
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		CareTeamMemberPage careTeamMemberPage = new CareTeamMemberPage(driver);
		patientDetailsPage.clickAddNewMemberButton();
		waitForElement(careTeamMemberPage.checkCareTeamMemberFormHeader());
	}

	public void setCTMemberName(String careTeamMemberName) {
		CareTeamMemberPage careTeamMemberPage = new CareTeamMemberPage(driver);
		careTeamMemberPage.showContactNameList();
		careTeamMemberPage.populateInputDropDownField(careTeamMemberName);
	}

	public void setCTMemberRole(String careTeamMemberRole) {
		CareTeamMemberPage careTeamMemberPage = new CareTeamMemberPage(driver);
		careTeamMemberPage.showRoleList();
		careTeamMemberPage.populateInputDropDownField(careTeamMemberRole);
		waitForElement(careTeamMemberPage.checkEmergencySectionHeader());
	}

	public void submitCareTeamMemberForm() {
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		CareTeamMemberPage addNewPatientCareTeamMemberPage = new CareTeamMemberPage(driver);
		addNewPatientCareTeamMemberPage.clickSaveButton();
		waitForElement(patientDetailsPage.checkPatientCTMembersTableBody());
	}

	public List<CareTeamMember> getPatientCTMembersList() {
		List<CareTeamMember> patientCTMembers = new ArrayList<CareTeamMember>();
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		List<WebElement> patientCTMembersList = patientDetailsPage.checkPatientCTMembersList();
		Iterator<WebElement> it = patientCTMembersList.iterator();
		while (it.hasNext()) {
			WebElement patientCTMListItem = it.next();
			List<WebElement> patientCTMembersDetails = patientCTMListItem.findElements(By.xpath(".//td"));
			String patientCTMemberFirstName = patientCTMembersDetails.get(0).getText().split(" ")[0];
			String patientCTMemberLastName = patientCTMembersDetails.get(0).getText().split(" ")[1];
			String patientCTMemberRole = patientCTMembersDetails.get(1).getText();
			String patientCTMemberDescription = patientCTMembersDetails.get(2).getText();
			String patientCTMemberOrganization = patientCTMembersDetails.get(3).getText();
			patientCTMembers.add(new CareTeamMember(patientCTMemberFirstName, patientCTMemberLastName,
					patientCTMemberRole, patientCTMemberDescription, patientCTMemberOrganization));
		}
		return patientCTMembers;
	}

	public void openEditPatientCareTeamMemberForm(CareTeamMember careTeamMember) {
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		CareTeamMemberPage careTeamMemberPage = new CareTeamMemberPage(driver);
		int index = getPatientCTMembersList().indexOf(careTeamMember);
		WebElement editedCTMember = patientDetailsPage.checkPatientCTMembersList().get(index);
		WebElement buttonEdit = editedCTMember.findElement(By.xpath(".//td[5]/div/a[2]"));
		buttonEdit.click();
		waitForElement(careTeamMemberPage.checkCareTeamMemberFormHeader());
	}
	
	public boolean checkDropDownContactNameIsDisabled() {
		CareTeamMemberPage careTeamMemberPage = new CareTeamMemberPage(driver);
		String elementClass = careTeamMemberPage.checkDropDownContactNameClass();
		return elementClass.split(" ")[2]=="select2-container--disabled";	
	}
	
	public void clickDeletePatientCareTeamMemberButton(CareTeamMember careTeamMember) {
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		ModalDialog modalDialog = new ModalDialog(driver);
		int index = getPatientCTMembersList().indexOf(careTeamMember);
		WebElement deletedCTMember = patientDetailsPage.checkPatientCTMembersList().get(index);
		WebElement buttonDelete = deletedCTMember.findElement(By.xpath(".//td[5]/div/a[3]"));
		buttonDelete.click();
		waitForElement(modalDialog.checkDialogCTMemberDelete());
		modalDialog.clickDeleteCTMemberButton();
		waitForElement(patientDetailsPage.checkPatientCTMembersTableBody());
	}
	
}

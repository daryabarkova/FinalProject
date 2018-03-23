package by.dbarkova.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.dbarkova.driver.DriverSingleton;
import by.dbarkova.pages.CareCoordinationPage;
import by.dbarkova.pages.MainPage;
import by.dbarkova.pages.PatientDetailsPage;
import by.dbarkova.pages.PatientEventsListPage;
import by.dbarkova.pages.PatientsListPage;

    public class NavigationSteps {
	
	private WebDriver driver;
	
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}
	
	public void closeDriver() {
		DriverSingleton.closeDriver(); 
	}
	
	private void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void navigateToCareCoordination() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickCareCoordinationMenuTab();
		CareCoordinationPage careCoordinationPage = new CareCoordinationPage(driver);
		waitForElement(careCoordinationPage.checkEventsListHeader());
		System.out.println("User has navigated to Care Coordination.");
	}
	
	public void navigateToPatientsList() {
		CareCoordinationPage careCoordinationPage = new CareCoordinationPage(driver);
		careCoordinationPage.clickPatientsListSubmenuTab();
		PatientsListPage patientsPage = new PatientsListPage(driver);
		waitForElement(patientsPage.checkPatientListFirstItem());
		System.out.println("User has navigated to Patients List.");
	}
	
	public void navigateToPatientDetails() {
		PatientsListPage patientsListPage = new PatientsListPage(driver);
		waitForElement(patientsListPage.checkPatientListFirstItem());
		patientsListPage.clickPatientsListFirstItem();
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		waitForElement(patientDetailsPage.checkSubtabPatientDetails());
		System.out.println("User has navigated to Patient Details.");
	}
	
	public void navigateToPatientEventsList() {
		PatientDetailsPage patientDetailsPage = new PatientDetailsPage(driver);
		waitForElement(patientDetailsPage.checkPatientEventsSubMenu());
		patientDetailsPage.clickPatientEventsSubMenu();
		PatientEventsListPage patientEventsListPage = new PatientEventsListPage(driver);
		waitForElement(patientEventsListPage.checkHeaderPatientEventsList());
		System.out.println("User has navigated to Patient Events List!");
	}
	
	public void viewLatestEventDetails() {
		PatientEventsListPage patientEventsListPage = new PatientEventsListPage(driver);
		waitForElement(patientEventsListPage.getLatestEventsListItem());
		patientEventsListPage.clickLatestEventsListItem();
		System.out.println("Latest list item is clicked.");
		waitForElement(patientEventsListPage.checkEventDescriptionTab());
	}

}

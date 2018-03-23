package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientEventsListPage {
	
	private WebDriver driver;

	public PatientEventsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//*[@id='patientEventsContent']/div/div[1]/span")
	private WebElement headerPatientEventsList;
	
	@FindBy(xpath = "//*[@id='patientEventList']/tbody/tr[1]")
	private WebElement latestEventsListItem;
	
	@FindBy(id = "patientEventsDescriptionTab")
	private WebElement tabEventDescription;
	
	@FindBy(xpath = "//*[@id='essentials_patientTab']/div[1]/p[2]")
	private WebElement eventCreator;
	
	@FindBy(xpath = "//*[@id='essentials_patientTab']/div[2]/p[2]")
	private WebElement eventCreatorCareTeamRole;
	
	@FindBy(id = "eventDetailsDateTime")
	private WebElement eventSubmissionDateandTime;
	
	@FindBy(xpath = "//*[@id='essentials_patientTab']/b/div/p[2]")
	private WebElement eventType;
	
	public WebElement checkHeaderPatientEventsList() {
		return headerPatientEventsList;
	}
	
	public void clickLatestEventsListItem() {
		latestEventsListItem.click();
	}
	
	public WebElement getLatestEventsListItem() {
		return latestEventsListItem;
	}
	
	public WebElement checkEventDescriptionTab() {
		return tabEventDescription;
	}
	
	public String extractEventCreatorName() {
		String eventCreatorName = eventCreator.getText();
		return eventCreatorName;
	}
	
	public String extractEventCreatorRole() {
		String eventCreatorRole = eventCreatorCareTeamRole.getText();
		return eventCreatorRole;
	}
	
	public String extractEventSubmissionDateAndTime() {
		String eventDateAndTime = eventSubmissionDateandTime.getText();
		return eventDateAndTime;
	}
	
	public String extractEventType() {
		String type = eventType.getText();
		return type;
	}

}

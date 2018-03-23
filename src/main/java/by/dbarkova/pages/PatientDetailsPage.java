package by.dbarkova.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDetailsPage {

	private WebDriver driver;

	public PatientDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "patientDetailsTab")
	private WebElement subMenuTabPatientDetails;
	
	@FindBy(xpath = "//*[@id='patientEventsTab']/a")
	private WebElement subMenuTabPatientEvents;
	
	@FindBy(xpath = "//*[@id='addEventLink']/span")
	private WebElement buttonAddNewEvent;
	
	@FindBy(xpath = "//*[@id='patientDetailsInfoContent']/div[1]/div[4]/div[1]/p[2]")
	private WebElement patientName;
	
	@FindBy(xpath = "//*[@id='patientDetailsInfoContent']/div[1]/div[4]/div[2]/p[2]")
	private WebElement patientSSN;
	
	@FindBy(xpath = "//*[@id='patientDetailsInfoContent']/div[1]/div[4]/div[3]/p[2]")
	private WebElement patientBirthDate;
	
	@FindBy(xpath = "//*[@id='patientDetailsInfoContent']/div[1]/div[4]/div[4]/p[2]")
	private WebElement patientGender;
	
	@FindBy(xpath = "//*[@id='patientDetailsInfoContent']/div[1]/div[4]/div[8]/p[2]")
	private WebElement patientCommunity;
	
	@FindBy(id = "createCareTeamMember")
	private WebElement buttonAddNewMember;
	
	@FindBy(id = "patientCareTeam_info")
	private WebElement bodyPatientCTMembersTable;
	
	@FindBy(xpath = "//*[@id='patientCareTeam']/tbody/tr")
	private List<WebElement> listPatientCTMembers;

	public WebElement checkSubtabPatientDetails() {
		return subMenuTabPatientDetails;
	}
	
	public void clickAddNewEventButton() {
		buttonAddNewEvent.click();
	}
	
	public void clickPatientEventsSubMenu() {
		subMenuTabPatientEvents.click();
	}
	
	public WebElement checkPatientEventsSubMenu() {
		return subMenuTabPatientEvents;
	}
	
	public String getPatientFirstName() {
		String name = patientName.getText();
		String[] arr = name.split(" ");
		String firstName = arr[0];
		return firstName;
	}
	
	public String getPatientLastName() {
		String name = patientName.getText();
		String[] arr = name.split(" ");
		String lastName = arr[1];
		return lastName;
	}
	
	public int getPatientSSN() {
		String stringSSN = patientSSN.getText();
		String[] arr = stringSSN.split("-");
		stringSSN = arr[2];
		int ssn = Integer.parseInt(stringSSN);
		return ssn;
	}
	
	public Date getPatientBirthDate() {
		String stringBirthDate = patientBirthDate.getText();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = new Date();
		try {
			birthDate = formatter.parse(stringBirthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return birthDate;
	}
	
	public String getPatientGenger() {
		String gender = patientGender.getText();
		return gender;
	}
	
	public String getPatientRelatedCommunity() {
		String community = patientCommunity.getText();
		return community;
	}
	
	public void clickAddNewMemberButton() {
		buttonAddNewMember.click();
	}
	
	public WebElement checkPatientCTMembersTableBody() {
		return bodyPatientCTMembersTable;
	}
	
	public List<WebElement> checkPatientCTMembersList(){
		return listPatientCTMembers;
	}
	

}

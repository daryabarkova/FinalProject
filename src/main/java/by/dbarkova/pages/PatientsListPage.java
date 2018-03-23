package by.dbarkova.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientsListPage extends AbstractPage {

	private static final String BASE_URL = "https://dev.simplyhie.com:8081/exchange/#url%5Btemplate%5D=care-coordination/patients";

	public PatientsListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//*[contains(@id,'patientsFilter')]/div[1]/input")
	private WebElement searchInputFirstName;

	@FindBy(xpath = "//*[contains(@id,'patientsFilter')]/div[2]/input")
	private WebElement searchInputLastName;

	@FindBy(xpath = "//*[contains(@id,'patientsFilter')]/div[3]/div/div[2]/label")
	private WebElement searchRadioButtonGenderFemale;

	@FindBy(xpath = "//*[contains(@id,'birthDate')]")
	private WebElement searchInputBirthDate;

	@FindBy(xpath = "//*[contains(@id,'lastFourSsn')]")
	private WebElement searchInputSSN;
	
	@FindBy(xpath = "//*[contains(@id,'patientSearchClear')]")
	private WebElement buttonClear;
	
	@FindBy(xpath = "//*[contains(@id,'patientSearch')]")
	private WebElement buttonSearch;
	
	@FindBy(xpath = "//table[contains(@id,'patientsList')]/tbody/tr/td[1]")
	private WebElement firstPatientsListItem;
	
	@FindBy(xpath = "//table[contains(@id,'patientsList')]/tbody/tr[1]/td[1]")
	private WebElement firstListItemFirstName;
	
	@FindBy(xpath = "//table[contains(@id,'patientsList')]/tbody/tr[1]/td[2]")
	private WebElement firstListItemLastName;
	
	@FindBy(xpath = "//table[contains(@id,'patientsList')]/tbody/tr[1]/td[3]")
	private WebElement firstListItemGender;
	
	@FindBy(xpath = "//table[contains(@id,'patientsList')]/tbody/tr[1]/td[4]")
	private WebElement firstListItemBirthDate;
	
	@FindBy(xpath = "//table[contains(@id,'patientsList')]/tbody/tr[1]/td[5]")
	private WebElement firstListItemSSN;
	
	@FindBy(xpath = "//table[contains(@id,'patientsList')]/tbody/tr[1]/td[7]")
	private WebElement firstListItemCommunity;

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void populateSearchFirstName(String firstName) {
		searchInputFirstName.sendKeys(firstName);
	}

	public void populateSearchLastName(String lastName) {
		searchInputLastName.sendKeys(lastName);
	}

	public void selectSearchGenderFemale(String lastName) {
		searchRadioButtonGenderFemale.click();
	}

	public void populateSearchBirthDate(String birthDate) {
		searchInputBirthDate.sendKeys(birthDate);
	}

	public void populateSearchSSN(String ssn) {
		searchInputSSN.sendKeys(ssn);
	}
	
	public void clickSearchButton() {
		buttonSearch.click();
	}
	
	public String extractFirstName() {
		String patientFirstName = firstPatientsListItem.getText();
		return patientFirstName;
	}
	
	public WebElement checkPatientListFirstItem() {
		return firstPatientsListItem;
	}
	
	public String getFirstListItemFirstName() {
		String firstName = firstListItemFirstName.getText();
		return firstName;
	}
	
	public String getFirstListItemLastName() {
		String lastName = firstListItemLastName.getText();
		return lastName;
	}
	
	public String getFirstListItemGender() {
		String gender = firstListItemGender.getText();
		return gender;
	}
	
	public Date getFirstListItemBirthDate() {
		String stringBirthDate = firstListItemBirthDate.getText();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date birthDate = new Date();
		try {
			birthDate = formatter.parse(stringBirthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return birthDate;
	}
	
	public int getFirstListItemSSN() {
		String stringSSN = firstListItemSSN.getText();
		String[] ar = stringSSN.split("-");
		stringSSN = ar[2];
		int ssn = Integer.parseInt(stringSSN);
		return ssn;
	}
	
	public String getFirstListItemCommunity() {
		String community = firstListItemCommunity.getText();
		return community;
	}
	
	public void clickPatientsListFirstItem() {
		firstPatientsListItem.click();
	}

}


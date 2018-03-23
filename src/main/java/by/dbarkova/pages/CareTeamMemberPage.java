package by.dbarkova.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareTeamMemberPage {
	
	private WebDriver driver;

	public CareTeamMemberPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "careTeamMemberHeader")
	private WebElement headerCareTeamMemberForm;
	
	@FindBy(xpath = "//*[@id='careTeamEmpSelectBox']/span")
	private WebElement dropdownContactName;
	
	@FindBy(xpath = "//*[@id='careTeamRoleSelectBox']/span")
	private WebElement dropdownRole;
	
	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	private WebElement inputDropDownList;
	
	@FindBy(xpath = "//*[@id='careTeamMemberNotificationPreferences']/div[2]")
	private WebElement headerEmergencySection;
	
	@FindBy(id = "saveCareTeamMember")
	private WebElement buttonSave;
	
	public WebElement checkCareTeamMemberFormHeader() {
		return headerCareTeamMemberForm;
	}
	
	public void showContactNameList() {
		dropdownContactName.click();
	}
	
	public void showRoleList() {
		dropdownRole.click();
	}
	
	public void populateInputDropDownField(String value) {
		inputDropDownList.sendKeys(value);
		inputDropDownList.sendKeys(Keys.ENTER);
	}
	
	public WebElement checkEmergencySectionHeader() {
		return headerEmergencySection;
	}
	
	public void clickSaveButton() {
		buttonSave.click();
	}
	
	public String checkDropDownContactNameClass() {
		String elementClass = dropdownContactName.getAttribute("class");
		return elementClass;
	}
	
	public String checkDropDownRoleClass() {
		String elementClass = dropdownRole.getAttribute("class");
		return elementClass;
	}


}

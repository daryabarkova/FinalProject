package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewEventPage {

	private WebDriver driver;

	public CreateNewEventPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "careTeamMemberHeader")
	private WebElement headerCreateNewEvent;

	@FindBy(id = "employee.roleId")
	private WebElement dropdownCareTeamRole;

	@FindBy(xpath = "//*[@id='employee.roleId']/option[2]")
	private WebElement careTeamRoleCM;

	@FindBy(id = "createNewEventBtn")
	private WebElement buttonSubmitNewEvent;
	
	public WebElement checkHeaderCreateNewEvent() {
		return headerCreateNewEvent;
	}

	public void showCareTeamRoleList() {
		dropdownCareTeamRole.click();
	}

	public void selectCMCareTeamRole() {
		careTeamRoleCM.click();
	}

	public void submitNewEvent() {
		buttonSubmitNewEvent.click();
	}

}

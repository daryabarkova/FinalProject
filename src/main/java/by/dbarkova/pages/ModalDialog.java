package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialog {
	
	private WebDriver driver;

	public ModalDialog(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[6]/div/div")
	private WebElement dialogEventSubmissionConfirmation;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div[1]/div")
	private WebElement dialogEventBodyText;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/button")
	private WebElement buttonOkEventConfirmation;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div[1]/button")
	private WebElement buttonCloseEventConfirmation;
	
	@FindBy(id = "command")
	private WebElement dialogCTMemberDelete;
	
	@FindBy(id = "deleteCareTeamMember")
	private WebElement buttonDeleteCTMember;
	
	public WebElement checkDialogEventSubmissionConfirmation() {
		return dialogEventSubmissionConfirmation;
	}
	
	public String extractDialogEventBodyText() {
		String text = dialogEventBodyText.getText();
		return text;
	}
	
	public void clickOkButton() {
		buttonOkEventConfirmation.click();
	}
	
	public void clickCloseButton() {
		buttonCloseEventConfirmation.click();
	}
	
	public WebElement checkDialogCTMemberDelete() {
		return dialogCTMemberDelete;
	}
	
	public void clickDeleteCTMemberButton() {
		buttonDeleteCTMember.click();
	}
	
}

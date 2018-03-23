package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareCoordinationPage extends AbstractPage {
	
	private static final String BASE_URL = "https://dev.simplyhie.com:8081/exchange/#url%5Btemplate%5D=care-coordination";

	public CareCoordinationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//*[contains(@id,'eventsLogTabContent')]/div/div[2]/div[1]/div[1]")
	private WebElement eventsListHeader;
	
	@FindBy(xpath = "//*[contains(@id,'patientsTab')]")
	private WebElement subMenuTabPatients;
	
	public void clickPatientsListSubmenuTab() {
		subMenuTabPatients.click();
	}
	
	public WebElement checkEventsListHeader() {
		return eventsListHeader;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		
	}
	
	

}

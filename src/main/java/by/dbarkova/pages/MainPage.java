package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	private static final String BASE_URL = "https://dev.simplyhie.com:8081/exchange/#url%5Btemplate%5D=care-coordination";
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//*[contains(@id,'userOptionsHead')]/div/label")
	private WebElement loggedUserName;
	
	@FindBy(xpath = "//*[contains(@id,'careCoordination')]")
	private WebElement tabCareCoordination;
	
	public String extractLoggedUserNameWait() throws InterruptedException {
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(loggedUserName));
		String userName = loggedUserName.getText();
		return userName;
	}
	
	public String extractLoggedUserName() {
		String userName = loggedUserName.getText();
		return userName;
	}
	
	public WebElement checkCareCoordinationMenuTab() {
		return tabCareCoordination;
	}
	
	public void clickCareCoordinationMenuTab() {
		tabCareCoordination.click();
		System.out.println("Care Coordination tab has been clicked.");
	}
	
	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}


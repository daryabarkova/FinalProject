package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	
	private static final String BASE_URL = "https://dev.simplyhie.com:8081/exchange/login";
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "company")
	private WebElement inputCompany;
	
	@FindBy(id = "username")
	private WebElement inputLogin;
	
	@FindBy(id = "password")
	private WebElement inputPassword;
	
	@FindBy(id = "loginBtn")
	private WebElement buttonLogin;
	
	@FindBy(linkText = "Forgot Password?")
	private WebElement buttonForgotPassword;
	
	public void populateCompanyCode(String companyCode) {
		inputCompany.sendKeys(companyCode);
	}
	
	public void populateLogin(String login) {
		inputLogin.sendKeys(login);
	}
	
	public void populatePassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	public void clickLoginButton() {
		buttonLogin.click();
	}
	
	public void clickResetPasswordButton() {
		buttonForgotPassword.click();
	}
	

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		
	}

}


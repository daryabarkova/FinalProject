package by.dbarkova.tests;

import org.testng.annotations.Test;

import by.dbarkova.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	private Steps steps;
	private static final String COMPANY_CODE = "DEMO01";
	private static final String LOGIN = "bdw89@mail.ru";
	private static final String PASSWORD = "P@ssw0rd";
	private static final String USER_NAME = "Lorraine Ashley";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void checkLoginPositive() throws InterruptedException {
		steps.login(COMPANY_CODE, LOGIN, PASSWORD);
		String userName = steps.getLoggedUserName();
		Assert.assertEquals(userName, USER_NAME);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}


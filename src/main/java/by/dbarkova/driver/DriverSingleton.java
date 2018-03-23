package by.dbarkova.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {

	private static WebDriver driver;
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String CHROME_EXE_PATH = "src\\main\\resources\\drivers\\chromedriver.exe";

	private DriverSingleton() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROME_EXE_PATH);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void closeDriver() {
		driver.close();
		driver = null;
	}

}

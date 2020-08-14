package core;

import java.io.IOException;
import static core.DriverFactory.killDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;

import core.Properties.Browsers;
import core.Properties.ExecutionTypes;
import core.Properties.Platforms;
import pages.LoginPage;

public class AbstractTest {

	@Rule
	public TestName testName = new TestName();
	
	@Rule
	public TestRule screenshotOnFailure = new ScreenshotOnFailure(this);
  
	private WebDriver driver;
  
	@Before
	public void start() {
		String platform = System.getProperty("platform");
		if (platform != null && !platform.isEmpty()) {
			if (platform.equalsIgnoreCase("WINDOWS")) {
				Properties.PLATFORM = Platforms.WINDOWS;
			} else if (platform.equalsIgnoreCase("MAC")) {
				Properties.PLATFORM = Platforms.MAC;
			} else if (platform.equalsIgnoreCase("LINUX")) {
				Properties.PLATFORM = Platforms.LINUX;
			}
		}
		String browser = System.getProperty("browser");
		if (browser != null && !browser.isEmpty()) {
			if (browser.equalsIgnoreCase("Chrome")) {
				Properties.BROWSER = Browsers.CHROME;
			} else if (browser.equalsIgnoreCase("Firefox")) {
				Properties.BROWSER = Browsers.FIREFOX;
			} else if (browser.equalsIgnoreCase("Internet Explorer")) {
			} else if (browser.equalsIgnoreCase("iPad")) {
			} else if (browser.equalsIgnoreCase("Android")) {
			}
		}
		String execution = System.getProperty("execution");
		if (execution != null) {
			if (execution.equalsIgnoreCase("local")) {
				Properties.EXECUTION_TYPE = ExecutionTypes.LOCAL;
			} else if (execution.equalsIgnoreCase("grid")) {
				Properties.EXECUTION_TYPE = ExecutionTypes.GRID;
			}
		}
		String baseUrl = System.getProperty("baseUrl");
		if (baseUrl != null && !baseUrl.isEmpty()) {
			Properties.BASE_URL = baseUrl;
		}
		String userName = System.getProperty("userName");
		if (userName != null && !userName.isEmpty()) {
			Properties.USER_EMAIL = userName;
		}
		String userPassword = System.getProperty("userPassword");
		if (userPassword != null && !userPassword.isEmpty()) {
			Properties.USER_PASSWORD = userPassword;
		}
		String gridUrl = System.getProperty("gridUrl");
		if (gridUrl != null && !gridUrl.isEmpty()) {
			Properties.GRID_URL = gridUrl;
		}
		driver = core.DriverFactory.getDriver();
		driver.get(Properties.BASE_URL);
		LoginPage loginPage = new LoginPage();
		loginPage.loginCompleto(Properties.USER_EMAIL, Properties.USER_PASSWORD);
	
	}

  @AfterClass
	public static void finish() throws IOException{
		if(Properties.CLOSE_BROWSER) {
			killDriver();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}

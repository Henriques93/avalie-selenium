package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import core.Properties.ExecutionTypes;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		return threadDriver.get();
	}
	
	public static WebDriver initDriver(){
		WebDriver driver = null;
		if(Properties.EXECUTION_TYPE == ExecutionTypes.LOCAL) {
			switch (Properties.BROWSER) {
				case FIREFOX: 
					System.setProperty("webdriver.gecko.driver", Properties.CONF_DIR + "geckodriver.exe");
					driver = new FirefoxDriver(); 
					break;
				case CHROME: 
					System.setProperty("webdriver.chrome.driver", Properties.CONF_DIR + "chromedriver.exe");
					driver = new ChromeDriver(); 
					break;
			}
		} else  if(Properties.EXECUTION_TYPE == ExecutionTypes.GRID) {
			DesiredCapabilities cap = null;
			switch (Properties.BROWSER) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;
			}
			try {
				driver = new RemoteWebDriver(new URL(Properties.GRID_URL), cap);
			} catch (MalformedURLException e) {
				System.err.println("GRID connection fail");
				e.printStackTrace();
			}
		}
		driver.manage().window().setSize(new Dimension(1200, 765));			
		return driver;
	}

	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}
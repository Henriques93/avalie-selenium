package core;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import static core.DriverFactory.getDriver;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenshotOnFailure extends TestWatcher {
	
	AbstractTest abstractTest;

	public ScreenshotOnFailure(AbstractTest abstractTest) {
		super();
		this.abstractTest = abstractTest;
	}

	@Override
	protected void failed(Throwable t, Description description) {
		WebDriver driver = abstractTest.getDriver();
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "failure_screenshots";
		String oldWindow = driver.getWindowHandle();
		try {
			Set<String> windows = driver.getWindowHandles();
			int idx = 0;
			String baseFileName = description.getClassName() + "-" + description.getMethodName();
			for (String guid : windows) {
				StringBuilder fileName = new StringBuilder(baseFileName);
				if (windows.size() > 1) {
					fileName.append("-").append((idx++));
				}
				fileName.append(".png");
				File file = new File(reportDirectory, fileName.toString());
				file.getCanonicalFile().getParentFile().mkdirs();
				try {
					driver.switchTo().window(guid);
					File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
					File destFile = new File((String) reportDirectory + File.separator + fileName.toString());
					FileUtils.copyFile(scrFile, destFile);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new WebDriverException(e);
		} finally {
			driver.switchTo().window(oldWindow); // restore original active window
		}
	}
}

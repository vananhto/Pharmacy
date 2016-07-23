package step_definitions.material;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.AppLogger;
import util.PropertiesStore;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void openBrowser() throws IOException {
		AppLogger.logMessage("Called openBrowser");
		String browserRunner = PropertiesStore.getProperty("browser");
		switch (browserRunner) {
		case "chrome":
			String chromePath = PropertiesStore.getProperty("chrome_path");
			System.setProperty("webdriver.chrome.driver", chromePath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "coccoc":
			break;
//		case "phantom":
//			String phantomPath = PropertiesStore.getProperty("phantom_path");
//			File file = new File(phantomPath);	
//			System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
//			driver = new PhantomJSDriver();
//			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@After
	public void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				// revert byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		driver.quit();

	}

}
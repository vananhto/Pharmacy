package scenarios.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import spec.Specification;
import util.PageStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseScenario {
	// Use the application driver
	WebDriver driver;
	protected Specification user;
	PageStore pageStore;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		pageStore = new PageStore();
		user = new Specification(pageStore);

		// launch the application under test
		driver = pageStore.getDriver();
		driver.get("http://203.190.173.37:8080/kinhdoanhduoc/Pages/login.zul");

	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) throws IOException {
		captureScreenShotInCaseOfFailure(result);
		// close the browser
		// pageStore.destroy();

	}

	protected <T extends Specification> T given(T dsl) {
		return dsl;
	}

	protected <T extends Specification> T when(T dsl) {
		return dsl;
	}

	protected <T extends Specification> T then(T dsl) {
		return dsl;
	}

	protected <T extends Specification> T and(T dsl) {
		return dsl;
	}

	protected void captureScreenShotInCaseOfFailure(ITestResult result) {
		if (result.isSuccess()) {
			return;
		}
		String screenShotFolder = "screenshots";
		File screenShotSourceFile = ((TakesScreenshot) pageStore.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			createFolder(screenShotFolder);
			String fileName = result.getMethod().getMethodName();
			File screenShotTargetFile = getTargetFile(screenShotFolder, fileName, "png");
			FileUtils.copyFile(screenShotSourceFile, screenShotTargetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createFolder(String folderName) throws IOException {
		if (!(new File(folderName).exists()))
			new File(folderName).mkdir();
	}

	private File getTargetFile(String folderName, String fileName, String ext) throws IOException {
		String rootPath = new File(".").getCanonicalPath();
		String fullPath = String.format("%s//%s//%s.%s", rootPath, folderName, fileName, ext);
		return new File(fullPath);
	}

}

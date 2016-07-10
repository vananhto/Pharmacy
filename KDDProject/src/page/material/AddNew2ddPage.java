package page.material;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import domain.detail.material.AddNew2ddDetails;
import domain.detail.material.MaterialDetail;

public class AddNew2ddPage extends AddNewEvent {
	WebDriver driver;

	public AddNew2ddPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterFileNumberFieldAs(String fileNumber)
	{
		fileNumberField = allTextbox.get(0);
		fileNumberField.clear();
		fileNumberField.sendKeys(fileNumber);
	}
	@Override
	public void enterAmountMaterialFieldAs(String amountMaterial)
    {
    	amountMaterialField = allTextbox.get(3);
    	amountMaterialField.clear();
    	amountMaterialField.sendKeys(amountMaterial);
    }
	@Override
	public  void enterQuyCachDongGoiFieldAs(String quyCachDongGoi)
	{}
	
	@Override
	public void enterQualityMaterialFieldAs(String qualityMaterial)
    {
    	qualityMaterialField = allTextbox.get(4);
    	qualityMaterialField.clear();
    	qualityMaterialField.sendKeys(qualityMaterial);
    }

//	public void save2ddWith(AddNew2ddDetails new2ddDetails) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		waitForTextboxFeildAppear();
//		this.clickCopporateCheckBox();
//		this.enterFileNumberFieldAs(new2ddDetails.getFileNumber());
//		this.enterSignWhereFieldAs(new2ddDetails.getSignWhere());
//
//		int i = 1;
//		for (MaterialDetail materialDetail : new2ddDetails.getMaterialDetailList()) {
//			this.enterAmountMaterialFieldAs(materialDetail.getAmountMaterial());
//			this.enterContenMaterialFieldAs(materialDetail.getContenMaterial());
//			this.enterMaterialNameFieldAs(materialDetail.getMaterialName());
//			this.enterUnitMaterialFieldAs(materialDetail.getUnitMaterial());
//			this.enterRegistrationNumberFeildAs(materialDetail.getRegistrationNumber());
//			this.enterContentImportFieldFeildAs(materialDetail.getContentImportl());
//			this.enterContentrationFieldAs(materialDetail.getContentration());
//			this.enterQualityMaterialFieldAs(materialDetail.getQualityMateriall());
//			this.clickCommitedCheckbox();
//			this.focusOnProviderMaterialField();
//			this.chooseProviderMaterialCombobox();
//			this.focusManufacturalMaterialField();
//			this.choosemanufacturalMaterialCombobox();
//			this.clickAddMaterialButton();
//			waitForDataFillOnTableComplete(i);
//			// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".z-listbox-body
//			// table tbody:nth-child(2) tr:nth-child("+ i +")")));
//			i++;
//		}
//		this.clickSaveListMaterialButton();
//		// waitUtilNotificationAppear();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".z-notification")));
//	}

//	private void waitForDataFillOnTableComplete(int i) {
//		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
//		wait.until(visibilityOfElementLocated(
//				By.cssSelector(".z-listbox-body table tbody:nth-child(2) tr:nth-child(" + i + ")")));
//	}
//
//	private void waitUtilNotificationAppear() {
//		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
//		wait.until(visibilityOfElementLocated(By.cssSelector(".z-notification")));
//	}
//
//	private void waitForTextboxFeildAppear() {
//		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
//		wait.until(visibilityOfElementLocated(By.cssSelector(".z-groupbox-cnt .z-textbox")));
//	}
//
//	private ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
//		return new ExpectedCondition<WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				WebElement toReturn = driver.findElement(locator);
//				if (toReturn.isDisplayed()) {
//					return toReturn;
//				}
//				return null;
//			}
//		};
//	}

	@Override
	public void Run() {
		// TODO Auto-generated method stub

	}

}

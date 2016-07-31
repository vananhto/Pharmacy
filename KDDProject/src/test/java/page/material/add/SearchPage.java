package page.material.add;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	//Search
	
		@FindBy(css = ".z-groupbox-cnt .z-select")
		private List<WebElement> comboboxes;
		
		@FindBy(css="tr:nth-child(2) td:nth-child(2) .z-select option:nth-child(2)")
		private WebElement orderTypeSpecialOfNormarl;
		
		@FindBy(css="tr:nth-child(2) td:nth-child(4) .z-select option:nth-child(2)")
		private WebElement statusBeSent;
						
		@FindBy(css="tr:nth-child(6) td:nth-child(4) .z-select option:nth-child(4)")
		private WebElement substanceZiprasidone;
		
		@FindBy(css = ".z-groupbox-cnt .z-textbox")
		private List<WebElement> textBoxes;
		
		@FindBy(css = ".z-groupbox-cnt .z-textbox")
		private List<WebElement> dateBoxes;
		
		@FindBy(css = ".z-groupbox-cnt .z-datebox-btn")
		private List<WebElement> datePicker;
		
		@FindBy(css = ".z-groupbox-cnt .button.z-button-os")
		private List<WebElement> buttons;
		
		@FindBy(css="tr:nth-child(4) td:nth-child(2) i.z-datebox-btn")
		private WebElement dateBoxFromDate;
		
		@FindBy(css="tr:nth-child(4) td:nth-child(4) i.z-datebox-btn")
		private WebElement dateBoxToDate;
		
		@FindBy(css="tr:nth-child(5) td:nth-child(2) i.z-datebox-btn")
		private WebElement dateBoxCreatedDateFrom;
		
		@FindBy(css="tr:nth-child(5) td:nth-child(4) i.z-datebox-btn")
		private WebElement dateBoxCreatedDateTo;
		
		private WebElement cbxOrderType;
		private WebElement cbxStatus;
		private WebElement txtCertificateNumber;
		private WebElement txtMaterialName;
		private WebElement dprIssuedFrom;
		private WebElement dprIssuedTo;
		private WebElement dprCreatedFrom;
		private WebElement dprCreatedTo;
		private WebElement txtOrderNumber;
		private WebElement cbxSubstance;
		
		private WebElement btnSearch;
		private WebElement btnClear;
		
		private int positionOfOrderTypeField;
		private int positionOfStatusField;
		private int positionOfCertificateNumberField;
		private int positionOfMaterialNameField;
		private int positionOfDateFromField;
		private int positionOfDateToField;
		private int positionOfCreatedDateFromField;
		private int positionOfCreatedDateToField;
		private int positionOfOrderNumberField;
		
		private int positionOfSubstanceField;
		
		private int positionOfSearchButton;
		private int positionOfClearButton;
		
		public void enterCertificateNumberFieldAs(String certificateNumber) {
			enterTextBoxField(txtCertificateNumber, positionOfCertificateNumberField, certificateNumber);
		}
		
		public void enterMaterialNameFieldAs(String materialName) {
			enterTextBoxField(txtMaterialName, positionOfMaterialNameField, materialName);
		}
		
		public void enterOrderNumberFieldAs(String orderNumber) {
			enterTextBoxField(txtOrderNumber, positionOfOrderNumberField, orderNumber);
		}
		
		public void enterIssuedDateFromFieldAs(String issuedDateFrom) {
			enterDatePickerField(dprIssuedFrom, positionOfDateFromField, issuedDateFrom);
		}
		
		public void enterIssuedDateToFieldAs(String issuedDateTo) {
			enterDatePickerField(dprIssuedTo, positionOfDateToField, issuedDateTo);
		}
		
		public void enterCreatedDateFromFieldAs(String createdDateFrom) {
			enterDatePickerField(dprCreatedFrom, positionOfCreatedDateFromField, createdDateFrom);
		}
		
		public void enterCreatedDateToFieldAs(String createdDateTo) {
			enterDatePickerField(dprCreatedTo, positionOfCreatedDateToField, createdDateTo);
		}
		
		public void clickSearchButton() {
			clickButton(btnSearch, positionOfSearchButton);
		}
		
		public void clickClearButton() {
			clickButton(btnClear, positionOfClearButton);
		}
		
		protected void enterTextBoxField(WebElement textBox, int position, String content) {
			textBox = textBoxes.get(position);
			textBox.clear();
			textBox.sendKeys(content);
		}
		
		protected void enterDatePickerField(WebElement datePicker, int position, String dateMonth) {
			datePicker = textBoxes.get(position);
			datePicker.clear();
			datePicker.sendKeys(dateMonth);
		}
		
		protected void clickButton(WebElement button, int position) {
			button = buttons.get(position);
			button.click();
		}
		
}
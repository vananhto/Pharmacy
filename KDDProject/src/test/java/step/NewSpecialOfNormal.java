package step;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.builder.account.LoginDetailBuilder;
import domain.builder.material.MaterialDetailBuilder;
import domain.builder.material.PageDetailBuilder;
import domain.detail.account.LoginDetails;
import domain.detail.material.MaterialDetail;
import domain.detail.material.PageDetail;
import scenarios.base.BaseScenario;

public class NewSpecialOfNormal {
	public WebDriver driver;
	public LoginDetailBuilder builder;
	protected BaseScenario baseScenario;

	public NewSpecialOfNormal() throws IOException {
		driver = Hooks.driver;
		builder = new LoginDetailBuilder();
		baseScenario = new BaseScenario(driver);
	}

	@Given("^I open pharmacy website to add$")
	public void i_open_pharmacy_website() throws Throwable {
		driver.get("http://203.190.173.37:8080/kinhdoanhduoc/Pages/login.zul");
	}

	@And("^After I enter username: \"(.*)\" and password: \"(.*)\"$")
	public void i_enter_username_and_password(String username, String password) throws Throwable {
		builder.withUsername(username).withPassword(password);
	}

	@And("After I fill login form")
	public void i_fill_login_form(DataTable loginDataTable) throws Throwable {
		List<List<String>> result = loginDataTable.raw();
		String username = result.get(1).get(0);
		String password = result.get(1).get(1);
		builder.withUsername(username).withPassword(password);
	}

	@And("^I login$")
	public void i_get_homepage() throws Throwable {
		LoginDetails loginDetails = builder.build();
		baseScenario.user.clickLoginWith(loginDetails);
	}

	@When("^I go to specical of nomarl page$")
	public void i_go_to_special_of_normal_page() throws Throwable {
		baseScenario.user.goToAddNew2ddPage();
	}

	PageDetailBuilder pageDetailBuilder = new PageDetailBuilder();

	@When("^I enter file number:\"(.*)\" and Sign where: \"(.*)\"$")
	public void i_enter_file_number(String fileNumber, String signWhere) throws Throwable {
		pageDetailBuilder.withFileNumber(fileNumber).withSignWhere(signWhere);
	}

	MaterialDetailBuilder materialDetailBuilder = new MaterialDetailBuilder();

	List<MaterialDetail> materialDetailList = new ArrayList<MaterialDetail>();

	@And("I fill material info")
	public void i_fill_material_info(DataTable loginDataTable) throws Throwable {
		List<List<String>> result = loginDataTable.raw();

		for (int i = 1; i <= 3; i++) {
			String materialName = result.get(i).get(0);
			String content = result.get(i).get(1);
			String amount = result.get(i).get(2);
			String quality = result.get(i).get(3);
			String unit = result.get(i).get(4);
			String registration = result.get(i).get(5);
			String contrentration = result.get(i).get(6);
			String contenImport = result.get(i).get(7);

			materialDetailBuilder.withMaterialName(materialName).withContenMaterial(content).withAmountMaterial(amount)
					.withQualityMateriall(quality).withUnitMaterial(unit);
			materialDetailBuilder.withContentImportl(contenImport).withRegistrationNumber(registration)
					.withContentration(contrentration);

			materialDetailList.add(materialDetailBuilder.build());
		}
	}

	@And("^I enter material name: \"(.*)\" , ham luong:\"(.*)\", so luong: \"(.*)\", don vi tinh: \"(.*)\" TCCL: \"(.*)\"$")
	public void i_enter_info_material(String materialName, String content, String amount, String quality, String unit)
			throws Throwable {
		materialDetailBuilder.withMaterialName(materialName).withContenMaterial(content).withAmountMaterial(amount)
				.withQualityMateriall(quality).withUnitMaterial(unit);
	}

	@And("^I enter SDK cua thuoc: \"(.*)\" , ham luong cua thuoc: \"(.*)\" , dang bao che cua thuoc: \"(.*)\"$")
	public void i_enter_import_number(String registration, String contenImport, String contrentration)
			throws Throwable {
		materialDetailBuilder.withContentImportl(contenImport).withRegistrationNumber(registration)
				.withContentration(contrentration);
	}

	@Then("^I save infomation$")
	public void i_save_info() throws Throwable {
		pageDetailBuilder.withMaterialDetailList(materialDetailList);
		PageDetail pageDetail = pageDetailBuilder.build();
		baseScenario.user.clickAddNew2ddWith(pageDetail);
	}

}
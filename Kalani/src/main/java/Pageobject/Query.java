package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Query extends BaseClass {
	public Query(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClosePopup() {
		WebElement ClosePopup = driver.findElement(By.id("popup-close"));
		ClosePopup.click();
	}

	public void ClickQueryForm() {
		WebElement QueryForm = driver.findElement(By.xpath("//a[normalize-space()='Query']"));
		QueryForm.click();
	}

	public void EnterName(String abc) {
		WebElement Name = driver.findElement(By.id("name"));
		Name.sendKeys(abc);

	}

	public void EnterEmail(String abc) {
		WebElement Email = driver.findElement(By.id("email"));
		Email.sendKeys(abc);

	}

	public void EnterDesignation(String abc) {
		WebElement Designation = driver.findElement(By.id("designation"));
		Designation.sendKeys(abc);

	}

	public void EnterOrganization(String abc) {
		WebElement Organization = driver.findElement(By.id("organization"));
		Organization.sendKeys(abc);

	}

	public void EnterOfficeAddress(String abc) {
		WebElement OfficeAddress = driver.findElement(By.id("address"));
		OfficeAddress.sendKeys(abc);

	}

	public void EnterCity(String abc) {
		WebElement City = driver.findElement(By.id("city"));
		City.sendKeys(abc);

	}

	public void EnterMobile(String abc) {
		WebElement Mobile = driver.findElement(By.id("mobile"));
		Mobile.sendKeys(abc);

	}

	public void EnterTelephone(String abc) {
		WebElement telephone = driver.findElement(By.xpath("//input[@id='telephone']"));
		telephone.sendKeys(abc);
	}
	// Method to select value from dropdown

	public void selectDropdownValue(String value) {
		WebElement dropdownElement = driver.findElement(By.id("department"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("Advisory- Company Law & Legal Matters");
	}

	public void SelectOtherProfessionalUpdates() {
		WebElement OtherProfessionalUpdates = driver.findElement(By.id("professionalyes"));
		OtherProfessionalUpdates.click();
	}

	public void EnterSubject(String abc) {
		WebElement subject = driver.findElement(By.id("subject"));
		subject.sendKeys(abc);
	}

	public void EnterMessage(String abc) {
		WebElement Message = driver.findElement(By.id("message"));
		Message.sendKeys(abc);
	}

	public void ClickSendMessage() {
		WebElement SendMessage = driver.findElement(By.xpath("//button[@type='submit']"));
		SendMessage.click();
	}

}

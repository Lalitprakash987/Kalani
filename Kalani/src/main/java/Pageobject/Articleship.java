package Pageobject;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Articleship extends BaseClass {
	public Articleship(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClosePopup() {
		WebElement ClosePopup = driver.findElement(By.id("popup-close"));
		ClosePopup.click();
	}

	public void navigateToCareersPage() {
		WebElement careersLink = driver.findElement(By.xpath("//a[normalize-space()='Careers']"));
		careersLink.click();
	}

	public void EnterName(String abc) {
		WebElement Name = driver.findElement(By.id("articalshipname"));
		Name.sendKeys(abc);
	}

	public void EnterEmail(String abc) {
		WebElement Email = driver.findElement(By.id("articalshipemail"));
		Email.sendKeys(abc);
	}

	public void EnterContact(String abc) {
		WebElement Contact = driver.findElement(By.id("articalshipcontact"));
		Contact.sendKeys(abc);
	}

	public void ClickGender() {
		WebElement FemaleGender = driver.findElement(By.id("female"));
		FemaleGender.click();
	}

	public void EnterCity(String abc) {
		WebElement City = driver.findElement(By.id("city"));
		City.sendKeys(abc);
	}

	public void selectDateForITtraining(String date) {
		WebElement dateInput = driver.findElement(By.id("comit_date"));
		dateInput.sendKeys(date);
	}

	public void UploadCertificateMarksheet(String filePath) {
		WebElement uploadInput = driver.findElement(By.id("it_file")); // Replace with actual ID or locator
		uploadInput.sendKeys(new File(filePath).getAbsolutePath());

	}

	public void selectDateForOCtraining(String date) {
		WebElement dateInput = driver.findElement(By.id("cmoc_date"));
		dateInput.sendKeys(date);
	}

	public void UploadMarksheet(String filePath) {
		WebElement uploadInput = driver.findElement(By.id("oc_file")); // Replace with actual ID or locator
		uploadInput.sendKeys(new File(filePath).getAbsolutePath());

	}

	public void EnterIntermediateAggregateScore(String abc) {
		WebElement IntermediateAggregateScore = driver.findElement(By.id("inter_score"));
		IntermediateAggregateScore.sendKeys(abc);
	}

	public void UploadMarksheet2(String filePath) {
		WebElement uploadInput = driver.findElement(By.id("inter_file")); // Replace with actual ID or locator
		uploadInput.sendKeys(new File(filePath).getAbsolutePath());

	}

	public void selectYearOfPassing(String value) {
		WebElement dropdownElement = driver.findElement(By.id("year2"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("2009");
	}

	public void selectMotheOfPassing(String value) {
		WebElement dropdownElement = driver.findElement(By.id("month2"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("January");
	}

	public void EnterFoundationScoreMarks(String abc) {
		WebElement IntermediateAggregateScore = driver.findElement(By.id("foundation_score"));
		IntermediateAggregateScore.sendKeys(abc);
	}

	public void UploadMarksheet3(String filePath) {
		WebElement uploadInput = driver.findElement(By.id("foundationfile")); // Replace with actual ID or locator
		uploadInput.sendKeys(new File(filePath).getAbsolutePath());

	}

	public void UploadProfile(String filePath) {
		WebElement uploadInput = driver.findElement(By.id("articalshipprofile")); // Replace with actual ID or locator
		uploadInput.sendKeys(new File(filePath).getAbsolutePath());

	}
	public void ClickSubmit() {
		WebElement Submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		Submit.click();
	}
}
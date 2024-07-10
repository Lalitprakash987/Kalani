package Pageobject;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CareersProfessionals extends BaseClass {

	public CareersProfessionals(WebDriver driver) {
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
	public void ClickpProfessionals() {
		WebElement Description = driver.findElement(By.id("professionals"));
		Description.click();

	}

	public void EnterName(String abc) {
		WebElement Name = driver.findElement(By.id("name"));
		Name.sendKeys(abc);

	}

	public void EnterEmail(String abc) {
		WebElement Email = driver.findElement(By.id("email"));
		Email.sendKeys(abc);

	}

	public void EnterContact(String abc) {
		WebElement Contact = driver.findElement(By.id("contact"));
		Contact.sendKeys(abc);

	}

	public void uploadCV(String filePath) {
		WebElement uploadInput = driver.findElement(By.id("resumeFile")); // Replace with actual ID or locator
		uploadInput.sendKeys(new File(filePath).getAbsolutePath());

	}

	public void EnterDescription(String abc) {
		WebElement Description = driver.findElement(By.id("description"));
		Description.sendKeys(abc);

	}

	public void ClickSendMessage() {
		WebElement Description = driver.findElement(By.xpath("//button[@form='professionalsform']"));
		Description.click();

	}
}

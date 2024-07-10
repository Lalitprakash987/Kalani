package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CareersFirmCollaborations extends BaseClass {
	public CareersFirmCollaborations(WebDriver driver) {
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
	public void ClickFirmCollaborations() {
		WebElement Description = driver.findElement(By.id("firm"));
		Description.click();

	}
	public void EnterName(String abc) {
		WebElement Name = driver.findElement(By.id("firmname"));
		Name.sendKeys(abc);

	}

	public void EnterEmail(String abc) {
		WebElement Email = driver.findElement(By.id("firmemail"));
		Email.sendKeys(abc);

	}

	public void EnterContact(String abc) {
		WebElement Contact = driver.findElement(By.id("firmcontact"));
		Contact.sendKeys(abc);

	}
	public void EnterNumberofPartners(String abc) {
		WebElement NumberofPartners = driver.findElement(By.id("number_of_partners"));
		NumberofPartners.sendKeys(abc);

	}
	public void EnterNumberofStaffMembers(String abc) {
		WebElement NumberofStaffMembers = driver.findElement(By.id("number_of_staff_members"));
		NumberofStaffMembers.sendKeys(abc);

	}
	public void EnterNumberofLocations(String abc) {
		WebElement NumberofLocations = driver.findElement(By.id("number_of_locations"));
		NumberofLocations.sendKeys(abc);

	}
	public void EnterHeadofficelocation(String abc) {
		WebElement Headofficelocation = driver.findElement(By.id("location_of_head_office"));
		Headofficelocation.sendKeys(abc);

	}
	
}

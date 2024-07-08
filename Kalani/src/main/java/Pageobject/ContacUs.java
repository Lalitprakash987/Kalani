package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContacUs extends BaseClass {

	public ContacUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClosePopup() {
		WebElement ClosePopup = driver.findElement(By.id("popup-close"));
		ClosePopup.click();
	}

	public void ClickContactUs() {
		WebElement ContactUs = driver
				.findElement(By.xpath("//a[contains(@class,'nav-item nav-link')][normalize-space()='Contact Us']"));
		ContactUs.click();

	}

	public void EnterYourName(String abc) {
		WebElement YourName = driver.findElement(By.id("name"));
		YourName.sendKeys(abc);

	}

	public void Enteremail(String abc) {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(abc);

	}

	public void Entersubject(String abc) {
		WebElement subject = driver.findElement(By.id("subject"));
		subject.sendKeys(abc);

	}

	public void Entermessage(String abc) {
		WebElement message = driver.findElement(By.id("message"));
		message.sendKeys(abc);

	}

	public void ClickSubmit() {
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
	}

	

}

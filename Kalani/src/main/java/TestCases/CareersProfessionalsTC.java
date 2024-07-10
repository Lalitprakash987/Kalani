package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.BaseClass;

public class CareersProfessionalsTC extends BaseClass {

	@Test(priority = 1)
	public void testCareersProfessionalsFormSubmission() throws InterruptedException {
		test = extent.createTest("testCareersProfessionalsFormSubmission",
				"Test to submit the careers professionals form");

		Careers.ClosePopup();
		test.info("Closed the popup");

		Careers.scrollPageToBottom();
		test.info("Scrolled to the bottom of the page");

		Thread.sleep(3000); // Wait for elements to load
		Careers.navigateToCareersPage();
		test.info("Navigated to Careers page");

		Thread.sleep(2000); // Wait for elements to load
		Careers.ClickpProfessionals();
		test.info("Clicked on Professionals");

		Careers.EnterName("Lalit Prakash Fatehpuriya");
		test.info("Entered name");

		Careers.EnterEmail("lalitprakash987@gmail.com");
		test.info("Entered email");

		Careers.EnterContact("8769585952");
		test.info("Entered contact number");

		String filePath = "D:\\Downloads\\Prov_list_Pharma (1).docx"; // Replace with the actual file path
		Careers.uploadCV(filePath);
		test.info("Uploaded CV");

		Careers.EnterDescription("Lorem Ipsum is simply dummy text of the printing");
		test.info("Entered description");

		Careers.scrollPage(0, 550);
		test.info("Scrolled the page");

		Thread.sleep(1000); // Wait for elements to load
		Careers.ClickSendMessage();
		test.info("Clicked on Send Message");

		Thread.sleep(2000); // Wait for success message to appear
		String expectedText = "Your application has been successfully submitted. We will review your information and contact you";
		String actualText = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Assert.assertEquals(actualText, expectedText);
		test.pass("Verified the success message, test case passed successfully");

		// Take screenshot and add to Extent report
		String screenshotPath = takeScreenshot("testCareersProfessionalsFormSubmission");
		test.addScreenCaptureFromPath(screenshotPath, "Success Message Verification");
	}

	@Test(priority = 2)
	public void testEmptyCareersProfessionalsFormSubmission() throws InterruptedException {
		test = extent.createTest("testEmptyCareersProfessionalsFormSubmission",
				"Test to submit an empty careers professionals form");

		driver.navigate().refresh();
		test.info("Refreshed the page");
		Thread.sleep(3000);
		Careers.ClickpProfessionals();
		test.info("Clicked on Professionals");
		Careers.scrollPage(0, 550);
		test.info("Scrolled the page");

		Thread.sleep(1000); // Wait for elements to load
		Careers.ClickSendMessage();
		test.info("Clicked on Send Message with empty form");

		Thread.sleep(1000); // Wait for URL verification
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kalani.host4india.in/career";
		Assert.assertEquals(currentUrl, expectedUrl);
		test.pass("Verified the URL remains the same after empty form submission, test case passed successfully");

		// Take screenshot and add to Extent report
		String screenshotPath = takeScreenshot("testEmptyCareersProfessionalsFormSubmission");
		test.addScreenCaptureFromPath(screenshotPath, "Empty Form Submission");
	}
}

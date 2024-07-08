package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pageobject.BaseClass;

public class ContactUsTC extends BaseClass {

	@Test(priority = 1)
	public void testSubmitContactForm() throws InterruptedException {
		test = extent.createTest("testSubmitContactForm", "Test to submit the contact form");

		Thread.sleep(5000);
		test.info("Waited for 5 seconds");

		ContacUs.ClosePopup();
		test.info("Closed the popup");

		ContacUs.ClickContactUs();
		test.info("Clicked on Contact Us");

		ContacUs.EnterYourName("Lalit Fatehpuriya");
		test.info("Entered name");

		ContacUs.Enteremail("lalitprakash987@gmail.com");
		test.info("Entered email");

		ContacUs.Entersubject("Physics");
		test.info("Entered subject");

		ContacUs.Entermessage("Lorem Ipsum is simply dummy text of the printing");
		test.info("Entered message");

		ContacUs.scrollPage(0, 250);
		test.info("Scrolled the page");

		Thread.sleep(1000);
		test.info("Waited for 1 second");

		ContacUs.ClickSubmit();
		test.info("Clicked on Submit");

		Thread.sleep(2000);
		test.info("Waited for 2 seconds");

		String expectedText = "Your message has been successfully submitted. We will get back to soon.";
		String actualText = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Assert.assertEquals(actualText, expectedText);
		test.pass("Verified the success message,test case passed successfully");
		// Take screenshot and add to Extent report
		String screenshotPath = takeScreenshot("testSubmitContactForm");
		test.addScreenCaptureFromPath(screenshotPath, "Success Message Verification");
	}

	@Test(priority = 2)
	public void testEmptyContatusFormSubmission() throws InterruptedException {
		test = extent.createTest("testEmptyFormSubmission", "Test to submit an empty contact form");

		driver.navigate().refresh();
		test.info("Refreshed the page");

		ContacUs.scrollPage(0, 500);
		test.info("Scrolled the page");

		Thread.sleep(1000);
		test.info("Waited for 1 second");

		ContacUs.ClickSubmit();
		test.info("Clicked on Submit with empty form");

		Thread.sleep(1000);
		test.info("Waited for 1 second");

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://kalani.host4india.in/contact";
		Assert.assertEquals(currentUrl, expectedUrl);
		test.pass("Verified the URL remains the same after empty form submission,test case passed successfully");
		// Take screenshot and add to Extent report
		String screenshotPath = takeScreenshot("testEmptyContatusFormSubmission");
		test.addScreenCaptureFromPath(screenshotPath, "Empty Form Submission");
	}
}

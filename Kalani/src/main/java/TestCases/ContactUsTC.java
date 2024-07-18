package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pageobject.BaseClass;
import Pageobject.ContacUs;
import Utility.DataProvider1;

public class ContactUsTC extends BaseClass {

	private static final Logger logger = LogManager.getLogger(ContactUsTC.class);

	@Test(priority = 1, dataProvider = "contactUsData", dataProviderClass = DataProvider1.class)
	public void testSubmitContactForm(String name, String email, String subject, String message)
			throws InterruptedException {
		test = extent.createTest("testSubmitContactForm", "Test to submit the contact form with different data");
		logger.info("Starting test: testSubmitContactForm");

		// Set implicit wait to 10 seconds before interacting with elements
		setImplicitWait(10, TimeUnit.SECONDS);

		ContacUs.ClosePopup();
		test.info("Closed the popup");
		logger.info("Closed the popup");

		ContacUs.ClickContactUs();
		test.info("Clicked on Contact Us");
		logger.info("Clicked on Contact Us");

		ContacUs.EnterYourName(name);
		test.info("Entered name: " + name);
		logger.info("Entered name: " + name);

		ContacUs.Enteremail(email);
		test.info("Entered email: " + email);
		logger.info("Entered email: " + email);

		ContacUs.Entersubject(subject);
		test.info("Entered subject: " + subject);
		logger.info("Entered subject: " + subject);

		ContacUs.Entermessage(message);
		test.info("Entered message: " + message);
		logger.info("Entered message: " + message);

		ContacUs.scrollPage(0, 250);
		test.info("Scrolled the page");
		logger.info("Scrolled the page");
		Thread.sleep(1000);
		ContacUs.ClickSubmit();
		test.info("Clicked on Submit");
		logger.info("Clicked on Submit");
		Thread.sleep(1000);
		String expectedText = "Your message has been successfully submitted. We will get back to soon.";
		String actualText = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		Assert.assertEquals(actualText, expectedText);
		test.pass("Verified the success message, test case passed successfully");
		logger.info("Verified the success message, test case passed successfully");

		// Take screenshot and add to Extent report
		String screenshotPath = takeScreenshot("testSubmitContactForm");
		test.addScreenCaptureFromPath(screenshotPath, "Success Message Verification");
		logger.info("Screenshot taken: " + screenshotPath);
		driver.navigate().refresh();
	}

	/*
	 * @Test(priority = 1) public void testSubmitContactForm() throws
	 * InterruptedException { test = extent.createTest("testSubmitContactForm",
	 * "Test to submit the contact form");
	 * logger.info("Starting test: testSubmitContactForm"); // Set implicit wait to
	 * 10 seconds before interacting with elements setImplicitWait(10,
	 * TimeUnit.SECONDS); Thread.sleep(5000);
	 * 
	 * ContacUs.ClosePopup(); test.info("Closed the popup");
	 * logger.info("Closed the popup");
	 * 
	 * ContacUs.ClickContactUs(); test.info("Clicked on Contact Us");
	 * logger.info("Clicked on Contact Us");
	 * 
	 * ContacUs.EnterYourName("Lalit Fatehpuriya"); test.info("Entered name");
	 * logger.info("Entered name");
	 * 
	 * ContacUs.Enteremail("lalitprakash987@gmail.com"); test.info("Entered email");
	 * logger.info("Entered email");
	 * 
	 * ContacUs.Entersubject("Physics"); test.info("Entered subject");
	 * logger.info("Entered subject");
	 * 
	 * ContacUs.Entermessage("Lorem Ipsum is simply dummy text of the printing");
	 * test.info("Entered message"); logger.info("Entered message");
	 * 
	 * ContacUs.scrollPage(0, 250); test.info("Scrolled the page");
	 * logger.info("Scrolled the page");
	 * 
	 * Thread.sleep(1000);
	 * 
	 * ContacUs.ClickSubmit(); test.info("Clicked on Submit");
	 * logger.info("Clicked on Submit");
	 * 
	 * Thread.sleep(2000);
	 * 
	 * String expectedText =
	 * "Your message has been successfully submitted. We will get back to soon.";
	 * String actualText =
	 * driver.findElement(By.xpath("//div[@role='alert']")).getText();
	 * Assert.assertEquals(actualText, expectedText);
	 * test.pass("Verified the success message, test case passed successfully");
	 * logger.info("Verified the success message, test case passed successfully");
	 * 
	 * // Take screenshot and add to Extent report String screenshotPath =
	 * takeScreenshot("testSubmitContactForm");
	 * test.addScreenCaptureFromPath(screenshotPath,
	 * "Success Message Verification"); logger.info("Screenshot taken: " +
	 * screenshotPath); }
	 * 
	 * @Test(priority = 2) public void testEmptyContatusFormSubmission() throws
	 * InterruptedException { test = extent.createTest("testEmptyFormSubmission",
	 * "Test to submit an empty contact form");
	 * logger.info("Starting test: testEmptyContatusFormSubmission"); // Set
	 * implicit wait to 10 seconds before interacting with elements
	 * setImplicitWait(10, TimeUnit.SECONDS); driver.navigate().refresh();
	 * test.info("Refreshed the page"); logger.info("Refreshed the page");
	 * 
	 * ContacUs.scrollPage(0, 500); test.info("Scrolled the page");
	 * logger.info("Scrolled the page");
	 * 
	 * Thread.sleep(1000);
	 * 
	 * ContacUs.ClickSubmit(); test.info("Clicked on Submit with empty form");
	 * logger.info("Clicked on Submit with empty form");
	 * 
	 * Thread.sleep(1000);
	 * 
	 * String currentUrl = driver.getCurrentUrl(); String expectedUrl =
	 * "https://kalani.host4india.in/contact"; Assert.assertEquals(currentUrl,
	 * expectedUrl); test.
	 * pass("Verified the URL remains the same after empty form submission, test case passed successfully"
	 * ); logger.
	 * info("Verified the URL remains the same after empty form submission, test case passed successfully"
	 * );
	 * 
	 * // Take screenshot and add to Extent report String screenshotPath =
	 * takeScreenshot("testEmptyContatusFormSubmission");
	 * test.addScreenCaptureFromPath(screenshotPath, "Empty Form Submission");
	 * logger.info("Screenshot taken: " + screenshotPath); }
	 */
}

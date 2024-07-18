package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pageobject.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CareersFirmCollaborationsTC extends BaseClass {

    private static final Logger logger = LogManager.getLogger(CareersFirmCollaborationsTC.class);

    @Test(priority = 1)
    public void testCareersCollaborationsFormSubmission() throws InterruptedException {
        test = extent.createTest("testCareersCollaborationsFormSubmission", "Test to submit the Careers Firm Collaborations form");

        Careers1.ClosePopup();
        test.info("Closed the popup");
        logger.info("Closed the popup");

        Careers1.scrollPageToBottom();
        logger.info("Scrolled to bottom of the page");

        Thread.sleep(3000); // Wait for elements to load
        Careers1.navigateToCareersPage();
        test.info("Navigated to Careers page");
        logger.info("Navigated to Careers page");

        Thread.sleep(2000); // Wait for elements to load
        Careers1.ClickFirmCollaborations();
        test.info("Clicked on Firm Collaborations");
        logger.info("Clicked on Firm Collaborations");

        Careers1.EnterName("Lalit Prakash Fatehpuriya");
        test.info("Entered name");
        logger.info("Entered name");

        Careers1.EnterEmail("lalitprakash987@gmail.com");
        test.info("Entered email");
        logger.info("Entered email");

        Careers1.EnterContact("8769585652");
        test.info("Entered contact number");
        logger.info("Entered contact number");

        Careers1.EnterNumberofPartners("10");
        test.info("Entered number of partners");
        logger.info("Entered number of partners");

        Careers1.EnterNumberofStaffMembers("12");
        test.info("Entered number of staff members");
        logger.info("Entered number of staff members");

        Careers1.EnterNumberofLocations("100");
        test.info("Entered number of locations");
        logger.info("Entered number of locations");

        Careers1.EnterHeadofficelocation("22/458, Sector 26, Pratap Nagar, Jaipur, Rajasthan 302033");
        test.info("Entered head office location");
        logger.info("Entered head office location");

        String filePath = "D:\\Downloads\\Prov_list_Pharma (1).docx"; // Replace with the actual file path
        Careers1.uploadProfileofthefirm(filePath);
        test.info("Uploaded profile of the firm");
        logger.info("Uploaded profile of the firm");

        Careers1.EnterDescription("Lorem Ipsum is simply dummy text of the printing");
        test.info("Entered description");
        logger.info("Entered description");

        Careers1.scrollPage(0, 500);
        test.info("Scrolled the page");
        logger.info("Scrolled the page");

        Thread.sleep(2000); // Wait for elements to load
        Careers1.ClickSendMessage();
        test.info("Clicked on Send Message");
        logger.info("Clicked on Send Message");

        Thread.sleep(2000); // Wait for success message to appear
        String expectedText = "Your application has been successfully submitted. We will review your information and contact you";
        String actualText = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(actualText, expectedText);
        test.pass("Verified the success message, test case passed successfully");
        logger.info("Verified the success message, test case passed successfully");

        // Take screenshot and add to Extent report
        String screenshotPath = takeScreenshot("testCareersCollaborationsFormSubmission");
        test.addScreenCaptureFromPath(screenshotPath, "Success Message Verification");
        logger.info("Screenshot taken and added to extent report");
    }

    @Test(priority = 2)
    public void testEmptyCareersCollaborationsFormSubmission() throws InterruptedException {
        test = extent.createTest("testEmptyCareersCollaborationsFormSubmission", "Test to submit an empty careers collaborations form");

        driver.navigate().refresh();
        test.info("Refreshed the page");
        logger.info("Refreshed the page");

        Thread.sleep(3000); // Wait for elements to load
        Careers1.ClickFirmCollaborations();
        test.info("Clicked on Firm Collaborations");
        logger.info("Clicked on Firm Collaborations");

        Careers1.scrollPage(0, 550);
        test.info("Scrolled the page");
        logger.info("Scrolled the page");

        Thread.sleep(1000); // Wait for elements to load
        Careers1.ClickSendMessage();
        test.info("Clicked on Send Message with empty form");
        logger.info("Clicked on Send Message with empty form");

        Thread.sleep(1000); // Wait for URL verification
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://kalani.host4india.in/career";
        Assert.assertEquals(currentUrl, expectedUrl);
        test.pass("Verified the URL remains the same after empty form submission, test case passed successfully");
        logger.info("Verified the URL remains the same after empty form submission, test case passed successfully");

        // Take screenshot and add to Extent report
        String screenshotPath = takeScreenshot("testEmptyCareersCollaborationsFormSubmission");
        test.addScreenCaptureFromPath(screenshotPath, "Empty Form Submission");
        logger.info("Screenshot taken and added to extent report");
    }
}

package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pageobject.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArticleshipTC extends BaseClass {

    private static final Logger logger = LogManager.getLogger(ArticleshipTC.class);

    @Test(priority = 1)
    public void testCareersProfessionalsFormSubmission() throws InterruptedException {
        test = extent.createTest("testCareersProfessionalsFormSubmission", "Test to submit the careers professionals form");

        Articleship.ClosePopup();
        logger.info("Closed the popup");

        Articleship.scrollPageToBottom();
        logger.info("Scrolled to bottom of the page");

        Articleship.navigateToCareersPage();
        test.info("Navigated to Careers page");
        logger.info("Navigated to Careers page");

        Articleship.scrollPage(0, 400);
        logger.info("Scrolled the page by 400 pixels");

        Thread.sleep(2000); // Wait for elements to load
        logger.info("Waited for 2 seconds");

        Articleship.EnterName("Lalit Prakash Fatehpuriya");
        test.info("Entered name");
        logger.info("Entered name");

        Articleship.EnterEmail("lalitprakash987@gmail.com");
        test.info("Entered email");
        logger.info("Entered email");

        Articleship.EnterContact("8769276920");
        test.info("Entered contact number");
        logger.info("Entered contact number");

        Articleship.ClickGender();
        test.info("Selected gender");
        logger.info("Selected gender");

        Articleship.EnterCity("Jaipur");
        test.info("Entered city");
        logger.info("Entered city");

        Articleship.selectDateForITtraining("2017-02-01");
        test.info("Selected IT training date");
        logger.info("Selected IT training date");

        String filePath = "D:\\Downloads\\Prov_list_Pharma (1).docx"; // Replace with the actual file path
        Articleship.UploadCertificateMarksheet(filePath);
        test.info("Uploaded IT training certificate");
        logger.info("Uploaded IT training certificate");

        Articleship.selectDateForOCtraining("2017-02-01");
        test.info("Selected OC training date");
        logger.info("Selected OC training date");

        Articleship.UploadMarksheet(filePath);
        test.info("Uploaded OC training marksheet");
        logger.info("Uploaded OC training marksheet");

        Articleship.EnterIntermediateAggregateScore("100");
        test.info("Entered intermediate aggregate score");
        logger.info("Entered intermediate aggregate score");

        Articleship.UploadMarksheet2(filePath);
        test.info("Uploaded intermediate marksheet");
        logger.info("Uploaded intermediate marksheet");

        Articleship.selectYearOfPassing("2009");
        test.info("Selected year of passing");
        logger.info("Selected year of passing");

        Articleship.selectMotheOfPassing("January");
        test.info("Selected month of passing");
        logger.info("Selected month of passing");

        Articleship.EnterFoundationScoreMarks("100");
        test.info("Entered foundation score marks");
        logger.info("Entered foundation score marks");

        Articleship.UploadMarksheet3(filePath);
        test.info("Uploaded foundation marksheet");
        logger.info("Uploaded foundation marksheet");

        Articleship.UploadProfile(filePath);
        test.info("Uploaded profile");
        logger.info("Uploaded profile");

        Articleship.scrollPage(0, 500);
        logger.info("Scrolled the page by 500 pixels");

        Thread.sleep(2000); // Wait for elements to load
        logger.info("Waited for 2 seconds");

        Articleship.ClickSubmit();
        test.info("Clicked on Submit");
        logger.info("Clicked on Submit");

        Thread.sleep(2000); // Wait for success message to appear
        logger.info("Waited for 2 seconds");

        String expectedText = "Your application has been successfully submitted. We will review your information and contact you";
        String actualText = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(actualText, expectedText);
        test.pass("Verified the success message, test case passed successfully");
        logger.info("Verified the success message, test case passed successfully");

        // Take screenshot and add to Extent report
        String screenshotPath = takeScreenshot("testSubmitContactForm");
        test.addScreenCaptureFromPath(screenshotPath, "Success Message Verification");
        logger.info("Screenshot taken and added to extent report");
    }

    @Test(priority = 2)
    public void testEmptyArticleshipFormSubmission() throws InterruptedException {
        test = extent.createTest("testEmptyFormSubmission", "Test to submit an empty contact form");

        driver.navigate().refresh();
        test.info("Refreshed the page");
        logger.info("Refreshed the page");

        Articleship.scrollPage(0, 1000);
        logger.info("Scrolled the page by 1000 pixels");

        Thread.sleep(2000); // Wait for elements to load
        logger.info("Waited for 2 seconds");

        Articleship.ClickSubmit();
        test.info("Clicked on Submit with empty form");
        logger.info("Clicked on Submit with empty form");

        Thread.sleep(2000); // Wait for URL verification
        logger.info("Waited for 2 seconds");

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://kalani.host4india.in/career";
        Assert.assertEquals(currentUrl, expectedUrl);
        test.pass("Verified the URL remains the same after empty form submission, test case passed successfully");
        logger.info("Verified the URL remains the same after empty form submission, test case passed successfully");

        // Take screenshot and add to Extent report
        String screenshotPath = takeScreenshot("testEmptyContactFormSubmission");
        test.addScreenCaptureFromPath(screenshotPath, "Empty Form Submission");
        logger.info("Screenshot taken and added to extent report");
    }
}

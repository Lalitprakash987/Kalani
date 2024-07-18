package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pageobject.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueryTC extends BaseClass {

    private static final Logger logger = LogManager.getLogger(QueryTC.class);

    @Test(priority = 1)
    public void testSubmitQueryForm() throws InterruptedException {
        test = extent.createTest("testSubmitQueryForm", "Test to submit a query form");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test.info("Set implicit wait to 10 seconds");
        logger.info("Set implicit wait to 10 seconds");

        Query.ClosePopup();
        logger.info("Closed the popup");

        Query.ClickQueryForm();
        test.info("Clicked on the Query form");
        logger.info("Clicked on the Query form");

        Query.EnterName("Lalit Fatehpuriya");
        test.info("Entered name");
        logger.info("Entered name");

        Query.EnterEmail("lalitprakash987@gmail.com");
        test.info("Entered email");
        logger.info("Entered email");

        Query.EnterDesignation("Quality analyst");
        test.info("Entered designation");
        logger.info("Entered designation");

        Query.EnterOrganization("W3care Technologies Pvt. Ltd.");
        test.info("Entered organization");
        logger.info("Entered organization");

        Query.EnterOfficeAddress("263/845, Sector 26, Pratap Nagar, Jaipur, Rajasthan 302033");
        test.info("Entered office address");
        logger.info("Entered office address");

        Query.EnterCity("Jaipur");
        test.info("Entered city");
        logger.info("Entered city");

        Query.EnterMobile("8769585956");
        test.info("Entered mobile number");
        logger.info("Entered mobile number");

        Query.EnterTelephone("5956525262");
        test.info("Entered telephone number");
        logger.info("Entered telephone number");

        Query.selectDropdownValue("Advisory- Company Law & Legal Matters");
        test.info("Selected dropdown value");
        logger.info("Selected dropdown value");

        Query.EnterSubject("Technology");
        test.info("Entered subject");
        logger.info("Entered subject");

        Query.EnterMessage("Lorem Ipsum is simply dummy text of the printing");
        test.info("Entered message");
        logger.info("Entered message");

        Query.scrollPage(0, 500);
        logger.info("Scrolled page");

        Thread.sleep(2000);
        Query.ClickSendMessage();
        test.info("Clicked on send message");
        logger.info("Clicked on send message");

        Thread.sleep(1000);
        String expectedText = "Your query has been successfully submitted. We will review your query and respond to you shortly";
        String actualText = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(actualText, expectedText);
        test.pass("Verified the success message,test case passed successfully");
        logger.info("Verified the success message,test case passed successfully");

        // Take screenshot and add to Extent report
        String screenshotPath = takeScreenshot("testSubmitQueryForm");
        test.addScreenCaptureFromPath(screenshotPath, "Success Message Verification");
        logger.info("Screenshot taken and added to extent report");
    }

    @Test(priority = 2)
    public void testEmptyQueryFormSubmission() throws InterruptedException {
        test = extent.createTest("testEmptyQueryFormSubmission", "Test to submit an empty query form");

        driver.get("https://kalani.host4india.in/query");
        test.info("Navigated to the query page");
        logger.info("Navigated to the query page");

        driver.navigate().refresh();
        test.info("Refreshed the page");
        logger.info("Refreshed the page");

        Query.scrollPage(0, 500);
        test.info("Scrolled the page");
        logger.info("Scrolled the page");

        Thread.sleep(2000);
        Query.ClickSendMessage();
        test.info("Clicked on send message with empty form");
        logger.info("Clicked on send message with empty form");

        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://kalani.host4india.in/query";
        Assert.assertEquals(currentUrl, expectedUrl);
        test.pass("Verified the URL remains the same after empty form submission,test case passed successfully");
        logger.info("Verified the URL remains the same after empty form submission,test case passed successfully");

        // Take screenshot and add to Extent report
        String screenshotPath = takeScreenshot("testEmptyQueryFormSubmission");
        test.addScreenCaptureFromPath(screenshotPath, "Empty Form Submission");
        logger.info("Screenshot taken and added to extent report");
    }
}

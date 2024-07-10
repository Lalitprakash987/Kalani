package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.BaseClass;

public class CareersFirmCollaborationsTC extends BaseClass {
	@Test(priority = 1)
	public void testCareers1ProfessionalsFormSubmission() throws InterruptedException {
		test = extent.createTest("testCareers1FirmCollaborationsFormSubmission",
				"Test to submit the Careers1FirmCollaborations form");

		Careers1.ClosePopup();

		Careers1.scrollPageToBottom();

		Thread.sleep(3000);
		Careers1.navigateToCareersPage();
		Thread.sleep(2000);
		Careers1.ClickFirmCollaborations();
		Careers1.EnterName("Lalit Prakash Fatehpuriya");
		Careers1.EnterEmail("lalitprakash987@gmail.com");
		Careers1.EnterContact("8769585652");
		Careers1.EnterNumberofPartners("10");
		Careers1.EnterNumberofStaffMembers("12");
		Careers1.EnterNumberofLocations("100");
		Careers1.EnterHeadofficelocation("22/458, Sector 26, Pratap Nagar, Jaipur, Rajasthan 302033");

	}
}
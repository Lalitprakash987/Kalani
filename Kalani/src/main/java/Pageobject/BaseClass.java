package Pageobject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.TestListener;

@Listeners(TestListener.class)
public class BaseClass {
	protected WebDriver driver;
	protected static ContacUs ContacUs;
	protected static Query Query;
	protected static CareersProfessionals Careers;
	protected static CareersFirmCollaborations Careers1;
	protected static Articleship Articleship;
	protected static ExtentReports extent;
	protected static ExtentTest test;

	@BeforeSuite
	public void setUpExtentReports() {
		// Initialize ExtentReports
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "Localhost");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Lalit Fatehpuriya");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\Kalani\\ChromeDriver\\chromedriver.exe");

		// Initialize a ChromeDriver instance
		driver = new ChromeDriver();
		// Set up implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to the website
		driver.get("https://kalani.host4india.in");

		ContacUs = new ContacUs(driver);
		Query = new Query(driver);
		Careers = new CareersProfessionals(driver);
		Careers1 = new CareersFirmCollaborations(driver);
		Articleship = new Articleship(driver);
	}

	// Method to set implicit waits
	@SuppressWarnings("deprecation")
	public void setImplicitWait(long duration, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(duration, unit);

	}

	public String takeScreenshot(String methodName) {
		String filePath = "screenshots/" + methodName + ".png";
		// Take a screenshot and store it as a file
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// Ensure the directory exists
			File file = new File(filePath);
			file.getParentFile().mkdirs();
			// Copy the file to the desired location
			FileUtils.copyFile(screenshot, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

	public void scrollPage(int x, int y) {
		// Scroll the page horizontally and vertically
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	public void scrollPageToTop() {
		// Scroll the page to the top
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}

	public void scrollPageToBottom() {
		// Scroll the page to the bottom
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	@AfterMethod
	public void onTestCompletion(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
			takeScreenshot("screenshots/" + result.getMethod().getMethodName() + ".png");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip(result.getThrowable());
		}
		test.info("Test End Time: " + result.getEndMillis());
	}

	@AfterClass
	public void tearDown() {
		// Quit the driver
		if (driver != null) {
		//	driver.quit();
		}
	}

	@AfterSuite
	public void tearDownExtentReports() {
		// Flush the ExtentReports
		if (extent != null) {
			extent.flush();
		}
	}
}

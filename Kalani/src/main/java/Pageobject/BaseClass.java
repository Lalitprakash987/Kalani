package Pageobject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.testng.annotations.BeforeTest;
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
	protected static ExtentReports extent;
	protected static ExtentTest test;
	private static final Logger logger = LogManager.getLogger(BaseClass.class);

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
		logger.info("WebDriver initialized and website opened");
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
		logger.info("Page scrolled horizontally by " + x + " and vertically by " + y);
	}

	public void scrollPageToTop() {
		// Scroll the page to the top
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		logger.info("Page scrolled to top");
	}

	public void scrollPageToBottom() {
		// Scroll the page to the bottom
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		logger.info("Page scrolled to bottom");
	}

	@AfterMethod
	public void onTestCompletion(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
			takeScreenshot("screenshots/" + result.getMethod().getMethodName() + ".png");
			logger.error("Test failed: " + result.getMethod().getMethodName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test passed");
			logger.info("Test passed: " + result.getMethod().getMethodName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip(result.getThrowable());
			logger.warn("Test skipped: " + result.getMethod().getMethodName());
		}
		test.info("Test End Time: " + result.getEndMillis());
	}

	@AfterClass
	public void tearDown() {
		// Quit the driver
		if (driver != null) {
		//	driver.quit();
			logger.info("WebDriver quit");
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

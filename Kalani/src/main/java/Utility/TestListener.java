package Utility;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener extends TestListenerAdapter implements IReporter {
    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname", "Localhost");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Tester Name", "Your Name");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test Started: " + result.getMethod().getMethodName());
        
        // Log parameters if available
        Object[] parameters = result.getParameters();
        if (parameters.length > 0) {
            StringBuilder params = new StringBuilder("Parameters: ");
            for (Object param : parameters) {
                params.append(param.toString()).append(" ");
            }
            test.info(params.toString());
        }

        // Log start time
        test.info("Start Time: " + result.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
        
        // Log end time and duration
        test.info("End Time: " + result.getEndMillis());
        test.info("Duration: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        
        // Log end time and duration
        test.info("End Time: " + result.getEndMillis());
        test.info("Duration: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip(result.getThrowable());
        
        // Log end time and duration
        test.info("End Time: " + result.getEndMillis());
        test.info("Duration: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }

        // Log summary of the test context
        test.info("Total Tests: " + context.getAllTestMethods().length);
        test.info("Passed Tests: " + context.getPassedTests().size());
        test.info("Failed Tests: " + context.getFailedTests().size());
        test.info("Skipped Tests: " + context.getSkippedTests().size());
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), "PASS");
                buildTestNodes(context.getFailedTests(), "FAIL");
                buildTestNodes(context.getSkippedTests(), "SKIP");
            }
        }
    }

    private void buildTestNodes(IResultMap tests, String status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));

                if (result.getThrowable() != null) {
                    test.log(status.equals("PASS") ? com.aventstack.extentreports.Status.PASS : com.aventstack.extentreports.Status.FAIL, result.getThrowable());
                } else {
                    test.log(com.aventstack.extentreports.Status.PASS, "Test passed");
                }

                for (String group : result.getMethod().getGroups()) {
                    test.assignCategory(group);
                }

                test.assignAuthor(result.getMethod().getRealClass().getSimpleName());
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}

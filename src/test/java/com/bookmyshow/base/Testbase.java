package com.bookmyshow.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bookmyshow.constants.Constants;
import com.bookmyshow.utilities.PropertiesOperation;

public class Testbase {

	public static ExtentSparkReporter sparkReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;

	BrowserFactory browserfactory = new BrowserFactory();

	private static String reportFileName = "PEER_TestCase_Report";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilePath = Constants.EXTENTREPORTFOLDER_PATH + fileSeperator;
	private static String reportFileLocation = "";

	@BeforeMethod
	public void launchApplication() throws InterruptedException {

		String browser = PropertiesOperation.getPropertyValueByKey("browser").toLowerCase();
		String url = PropertiesOperation.getPropertyValueByKey("bookMyShowURL");

		driver = browserfactory.createBrowserInstance(browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.AVG_IMPLICIT, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			test.log(Status.FAIL, result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, MarkupHelper.createLabel(
					"Test Case Status is Passed=>" + result.getMethod().getMethodName(), ExtentColor.GREEN));

		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel("Test Case Skipped=>" + result.getMethod().getMethodName(),
					ExtentColor.YELLOW));
		}
		driver.close();
		driver.quit();
	}

	public void initializeReport() {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		reportFileLocation = reportFilePath + reportFileName + "_" + actualDate + ".html";
		sparkReport = new ExtentSparkReporter(reportFileLocation);

		sparkReport.config().setEncoding("utf-8");
		sparkReport.config().setDocumentTitle("ListenersOnCall Automation Report");
		sparkReport.config().setReportName("ListenersOnCall_TestCases_Report");
		sparkReport.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperation.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed on User: ", System.getProperty("user.name"));
		extent.attachReporter(sparkReport);
	}

	@BeforeTest
	public void beforeTest() {
		initializeReport();
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}
}

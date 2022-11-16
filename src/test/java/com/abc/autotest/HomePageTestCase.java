package com.abc.autotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class HomePageTestCase {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest testcase;

@BeforeClass(alwaysRun=true)	
	public void GenerateReport() {
		report=new ExtentReports(); //It is 4 version
		spark=new ExtentSparkReporter("Result/Result.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report -OrangeHRMS");
		spark.config().setReportName("OrangeHRMS");
		report.attachReporter(spark);
	}
	
	@Test
	public void HomePage() {
			UtilityMethod utility=new UtilityMethod();
			utility.loadProperties();
			testcase=report.createTest("verify that user should be able to launch the application");
			if(UtilityMethod.prop.getProperty("browsername").equalsIgnoreCase("chrome")) {
			//Step 1 - register the driver
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipseworkspace\\AutoTests\\src\\test\\resources\\chromedriver.exe");
			//Step 2 - Object of browser related class
			driver=new ChromeDriver();
			}else if(UtilityMethod.prop.getProperty("browsername").equalsIgnoreCase("firefox")) {
			//Step 1- register the driver
			System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
			driver=new FirefoxDriver();
			} else {
				System.setProperty("webdriver.edge.driver", "Resources/msedgedriver.exe");
				driver=new EdgeDriver();
			}
			driver.get(UtilityMethod.prop.getProperty("url"));
			driver.manage().window().maximize();
			testcase.log(Status.PASS, "Application is able to launch the browser");
			report.flush();
			driver.close();
		}

}

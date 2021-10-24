package com.testBase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;
	
	public static WebDriver initialization () {		
		log.info("initializating browser"); // file
		String browser =PropertiesUtils.getproperty("browser");
		log.info(browser+"broweser is initialized");
		if(browser.equalsIgnoreCase ("Chrome")) {
			System.setProperty("Webdriver.chromedriver","D:/ChromeDriver.exe");
			driver= new ChromeDriver();
		}
		/*if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.gecko.driver","D:/geckoDriver.exe");
			driver= new FirefoxDriver();*/
	
	log.info("maximising browser window");
	driver.manage().window().maximize();
	driver.get(PropertiesUtils.getproperty("url"));
	log.info("applying common waits over a browser");
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	return driver;	
	}
	public void reportInit() {
spark = new ExtentSparkReporter (System.getProperty("user.dir"+"/target/Reports/ExtentReports.html"));
report = new ExtentReports();
report.setSystemInfo("Host Name"," Mangesh-JBK");
report.setSystemInfo("Platform","Windows");
report.setSystemInfo("Enviornment","Test Automation");
report.attachReporter(spark);	
	}
	public String takeScreenShot(String name) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	} }
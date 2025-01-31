package com.testim.TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.testim.featuresPage.LoginPage;
import com.testim.utility.Waits;

public class TestBase {
	
	public  LoginPage loginPage;

	public static WebDriver driver;
	public Logger log = LogManager.getLogger(this.getClass().getName());

	@Parameters({ "BR" })
	@BeforeTest

	public void setUPBrowser(String br) {

		if (br.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			log.info("Chrome Browser Launch.");
		} else if (br.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			log.info("FireFox Browser Launch.");
		} else if (br.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			log.info("Edge Browser Launch.");
		} else {
			log.info("Invalid Browser Name.");
		}

		driver.manage().window().maximize();
		
		 loginPage = new LoginPage();

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			log.info("Browser quit Sucessfully.");
		}
	}

}

package com.testim.utility;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.testim.TestBase.TestBase;

public class CapturedScreenShot extends TestBase {

	// get current date time for create fileName as per capture ScreenShot date and
	// Time
	public static String getCurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String captureScreenShot(String fileName) {

		String filePath = System.getProperty("user.dir") + "/src/test/resources/ScreenShots/" + fileName
				+ CapturedScreenShot.getCurrentDateTime() + ".png";
		TakesScreenshot typeCastObj = (TakesScreenshot) driver;
		try {

			File captureScreenShot = typeCastObj.getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(filePath);
			FileHandler.copy(captureScreenShot, destinationPath);
			

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}

}

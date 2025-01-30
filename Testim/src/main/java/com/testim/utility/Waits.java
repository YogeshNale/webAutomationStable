package com.testim.utility;

import java.time.Duration;

import com.testim.TestBase.TestBase;

public class Waits extends TestBase {
	
	public static void implicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(seconds));
	}

}

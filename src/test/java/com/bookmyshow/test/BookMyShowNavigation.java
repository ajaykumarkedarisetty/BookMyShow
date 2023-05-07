/**
 * 
 */
package com.bookmyshow.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bookmyshow.base.Testbase;

/**
 * @author Kedar
 *
 */
public class BookMyShowNavigation extends Testbase{
	
	@Test
	public void bookMyShowPageNavigation() {
		try {
			String methodName = new Exception().getStackTrace()[0].getMethodName();
			test = extent.createTest(methodName, "Verify ContactUs Functionality");
			test.log(Status.INFO, "...Running Peer ContactUs Functionality...");
			test.assignCategory("Functional");

			driver.findElement(
					By.xpath("//img[@src='//in.bmscdn.com/m6/images/common-modules/regions/hyd.png']"))
					.click();
			Reporter.log("Clicked On Hyderabad Location", true);

			boolean signInDisplay = driver.findElement(By.xpath("//div[text()='Sign in']")).isDisplayed();
			assertTrue(signInDisplay, "SignButton Is displayed");
		}catch (Exception e) {
			throw e;
		}
	}

}

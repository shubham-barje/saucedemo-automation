package com.qa.saucedemo.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseClass;
import com.qa.saucedemo.pages.Remove_ProductFromCart;

import com.qa.saucedemo.utils.TestUtils;

public class Remove_ProductFromCartTestCases extends BaseClass {
	int TCID;
	Remove_ProductFromCart rpft;

	@BeforeMethod
	public void setup() {
		intitilization();
		rpft = new Remove_ProductFromCart();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == result.SUCCESS) {
			TestUtils.Screenshots(TCID);
			driver.quit();
		}
	}
	@Test
	public void Remove_ProductFromCart() throws InterruptedException {
		TCID = 12;
		rpft.login(Props.getProperty("username"), Props.getProperty("password"));
		rpft.add_ToCartCheckAndRemove();

	}

	

}

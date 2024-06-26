package com.qa.saucedemo.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseClass;
import com.qa.saucedemo.pages.LogoutAndSideMenuPage;
import com.qa.saucedemo.utils.TestUtils;

public class LogoutAndSideMenuTestCase extends BaseClass{
	int TCID;
	LogoutAndSideMenuPage lsm ;
	
	@BeforeMethod
	public void setup() {
		intitilization();
		lsm = new LogoutAndSideMenuPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			TestUtils.Screenshots(TCID);
			driver.quit();
		}
	}
	
	@Test
	public void logout() throws InterruptedException {
		TCID=9;
		lsm.login(Props.getProperty("username"), Props.getProperty("password"));
		lsm.logOut();
	}
	
	
}


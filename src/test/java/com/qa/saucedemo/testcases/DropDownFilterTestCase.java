package com.qa.saucedemo.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseClass;
import com.qa.saucedemo.pages.DropDownFilterPage;
import com.qa.saucedemo.utils.TestUtils;

public class DropDownFilterTestCase extends BaseClass{
	int TCID;
	DropDownFilterPage dfp ;
	
	@BeforeMethod
	public void setup() {
		intitilization();
		dfp = new DropDownFilterPage();
	}
	
	@Test
	public void dropdown() {
		TCID=10;
		dfp.login(Props.getProperty("username"), Props.getProperty("password"));
		dfp.filter();
	}
	
	@AfterMethod
	public void screenshort(ITestResult result) throws IOException {
		if(result.getStatus() == result.SUCCESS) {
			TestUtils.Screenshots(TCID);
			driver.quit();
		}
	}
	

}

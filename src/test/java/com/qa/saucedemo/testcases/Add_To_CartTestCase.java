package com.qa.saucedemo.testcases;


import java.io.IOException;

import org.openqa.selenium.NoSuchSessionException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseClass;
import com.qa.saucedemo.pages.Add_To_CartPage;
import com.qa.saucedemo.utils.TestUtils;

public class Add_To_CartTestCase extends BaseClass {
	int TCID;
	Add_To_CartPage atc ;
	
	@BeforeMethod
	public void setup() {
		intitilization();
		atc = new Add_To_CartPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == result.SUCCESS) {
			TestUtils.Screenshots(TCID);
			driver.quit();
		}
	}
	
	@Test
	public void Add_To_Cart() throws InterruptedException, IOException {
		TCID=11;
		atc.login(Props.getProperty("username"), Props.getProperty("password"));
		atc.add_ToCartCheck();
		
	}
	
	
	
}
	


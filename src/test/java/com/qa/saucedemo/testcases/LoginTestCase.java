package com.qa.saucedemo.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseClass;
import com.qa.saucedemo.pages.LoginPage;
import com.qa.saucedemo.utils.TestUtils;

public class LoginTestCase extends BaseClass {
	int TCID;
	LoginPage lp = new LoginPage();
	
//	public LoginTestCase() {
//		super();
//	}
//	
	@BeforeMethod
	public void setUp() {
		intitilization();
		lp = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			TestUtils.Screenshots(TCID);
			driver.quit();
		}
	}
	@Test
	public void loginPageTitle() {
		TCID=1;
		String actTitle = lp.validateLoginPageTitle();
		String expTitle = "Swag Labs";
		Assert.assertEquals(actTitle, expTitle);
	}
	@Test
	public void loginLogoImage() {
		TCID=2;
		boolean actLogoImg = lp.validateImage();
		boolean expLogoImg = true;
		Assert.assertEquals(actLogoImg, expLogoImg);
	}
	@Test
	public void loginTest() {
		TCID=3;
		lp.login(Props.getProperty("username"), Props.getProperty("password"));
	}
	
	
	
	@DataProvider(name="credentials")
	public Object[][] getdata()
	{
		return new Object[][]
		{
			{"Valid","standard_user","secret_sauce"},
			{"InValid","abcd123","adcd@123"},
			{"InValidUN","abcd123","secret_sauce"},
			{"InValidPass","abcd123","adcd@123"},
			{"blank","",""}
		};
	}
	
	@Test(dataProvider="credentials")
	public void verifyLoginFunctionality (String senario,String username,String password) {
		lp.login(username, password);
		if(senario.equals("Valid")) {
			TCID=4;
			String actResult = lp.verifyUrl();
			String expResult = "https://www.saucedemo.com/v1/inventory.html";
			Assert.assertEquals(actResult, expResult);
		}
		else if (senario.equals("InValid")) {
			TCID=5;
			String actResult = lp.getErrorText();
			String expResult = "Epic sadface: Username and password do not match any user in this service";
			Assert.assertEquals(actResult, expResult )	;
		}
		else if (senario.equals("InValidUN")) {
			TCID=6;
			String actResult = lp.getErrorText();
			String expResult = "Epic sadface: Username and password do not match any user in this service";
			Assert.assertEquals(actResult, expResult )	;
		}
		else if (senario.equals("InValidPass")) {
			TCID=7;
			String actResult = lp.getErrorText();
			String expResult = "Epic sadface: Username and password do not match any user in this service";
			Assert.assertEquals(actResult, expResult )	;
		}
		else if (senario.equals("blank")) {
			TCID=8;
			String actResult = lp.getErrorText();
			String expResult = "Epic sadface: Username is required";
			Assert.assertEquals(actResult, expResult )	;
		}
	}
	
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}
}

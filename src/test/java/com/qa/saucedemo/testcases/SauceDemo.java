package com.qa.saucedemo.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseClass;
import com.qa.saucedemo.pages.HomePage;

public class SauceDemo extends BaseClass{
	HomePage hp ;
	
	@BeforeMethod
	public void setup() {
		intitilization();
		hp = new HomePage();
	}
	
	@Test
	public void loginForHomeSection() throws InterruptedException {
		hp.loginForHome(Props.getProperty("username"),Props.getProperty("password"));
		Thread.sleep(3000);
		hp.dropdownZtoA();
		
		hp.add_ToCartCheck();
		
		hp.logOut();
		
		driver.quit();
	}
	
	
	
	
}

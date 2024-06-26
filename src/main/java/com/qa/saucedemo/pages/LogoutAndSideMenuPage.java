package com.qa.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.saucedemo.base.BaseClass;

public class LogoutAndSideMenuPage extends BaseClass {
	@FindBy(id="user-name") private WebElement username;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="login-button")private WebElement login_btn;
	
	@FindBy(className="bm-burger-button") WebElement menu_btn;
	@FindBy(id="logout_sidebar_link") WebElement logout_sidebar;
	
	public LogoutAndSideMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		login_btn.click();
	}
	
	public void logOut() throws InterruptedException {
		menu_btn.click();
		Thread.sleep(2000);
		logout_sidebar.click();
		Thread.sleep(2000);
	}
}


package com.qa.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.saucedemo.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name") private WebElement username;
	@FindBy(id="password") private WebElement password;

	@FindBy(xpath="//h3[@data-test=\"error\"]")private WebElement errMessage;
	
	@FindBy(id="login-button")private WebElement login_btn;
	@FindBy(className="login_logo")private WebElement logo;
	
	public String validateLoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public boolean validateImage() {
		boolean bl = logo.isDisplayed();
		return bl;
	}
	public String verifyUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public void login(String un,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		login_btn.click();
		
	}
	public String getErrorText() {
		return errMessage.getText();
	}
	
	
}

package com.qa.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.saucedemo.base.BaseClass;

public class DropDownFilterPage extends BaseClass {
	@FindBy(id="user-name") private WebElement username;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="login-button")private WebElement login_btn;
	
	@FindBy(className="product_sort_container")private WebElement dropDown;
	
	public DropDownFilterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		login_btn.click();
	}
	
	public Select filter() {
		Select select = new Select(dropDown);
		select.selectByValue("za");
		return select;
	}
}

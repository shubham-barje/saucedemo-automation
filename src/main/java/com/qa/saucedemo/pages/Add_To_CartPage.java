package com.qa.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.saucedemo.base.BaseClass;

public class Add_To_CartPage extends BaseClass {
	@FindBy(id="user-name") private WebElement username;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="login-button")private WebElement login_btn;
	
	@FindBy(id="item_4_title_link") private WebElement item_name;
	@FindBy(xpath="//*[@id=\"inventory_item_container\"]/div/div/div/button") private WebElement add_To_Cart_Product;
	@FindBy(className="shopping_cart_container")private WebElement icon_cart;
	
	public Add_To_CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login (String un,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		login_btn.click();
	}
	
	public void add_ToCartCheck() throws InterruptedException {
		
		 item_name.click();
		 Thread.sleep(3000);
		 add_To_Cart_Product.click();
		 Thread.sleep(3000);
		 icon_cart.click();
		 Thread.sleep(3000);
		 
	}
	
}

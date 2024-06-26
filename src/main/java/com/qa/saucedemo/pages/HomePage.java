package com.qa.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.saucedemo.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(id="item_4_title_link") private WebElement item_name;
	@FindBy(xpath="//*[@id=\"inventory_item_container\"]/div/div/div/button") private WebElement add_To_Cart_Product;
	@FindBy(className="inventory_details_back_button")private WebElement back_button;
//	
	@FindBy(className="product_sort_container")private WebElement dropDown;
	
//	
////	@FindBy() WebElement products;
	@FindBy(className="bm-burger-button") WebElement menu_btn;
	@FindBy(id="logout_sidebar_link") WebElement logout_sidebar;
//	@FindBy(id="shopping_cart_container") WebElement add_To_Cart_logo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="user-name") private WebElement username;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="login-button")private WebElement login_btn;
	public String verifyHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}
//	public boolean addToCartBtnDisplayed() {
//		boolean addtoCart = add_To_Cart_logo.isDisplayed();
//		return addtoCart;
//	}
//	public boolean openMenuBarIsDisplayed() {
//		boolean menuBar = menu_btn.isDisplayed();
//		return menuBar;
//	}
//	
//	
	public Select dropdownZtoA() {
		Select select = new Select(dropDown);
		select.selectByValue("za");
		return select;
}
	public void add_ToCartCheck() throws InterruptedException {
		
		 item_name.click();
		 Thread.sleep(3000);
		 add_To_Cart_Product.click();
		 Thread.sleep(3000);
		 back_button.click();
		 Thread.sleep(3000);
	}
	
	public void loginForHome(String usern,String pass) {
		username.sendKeys(usern);
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

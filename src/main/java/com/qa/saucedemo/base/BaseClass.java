package com.qa.saucedemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties Props;
	
	public BaseClass(){
		Props = new Properties();
		try {
			FileInputStream file = new FileInputStream("D:\\ExclR_P1_saucedemo_automation\\ExclR_P1\\src\\main\\java\\com\\qa\\saucedemo\\config.properties");
			Props.load(file);
			
		}catch(FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void intitilization() {
		String browserName = Props.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Props.getProperty("url"));
		
	}
}

package com.qa.saucedemo.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.saucedemo.base.BaseClass;

public class TestUtils extends BaseClass{
	public static void Screenshots(int TCID) throws IOException {
//		String path = "./Screenshots/"+name+".png";
//		File takes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File location = new File(path);
//		try {
//			Files.copy(takes, location);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		File dest1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src1 = new File("D:\\ExclR_P1_saucedemo_automation_separte\\ExclR_P1\\Screenshortnew\\screenshot"+TCID+".png");
		FileHandler.copy(dest1, src1);//filehadler is for common filesystem activity
		
	
	}
}
